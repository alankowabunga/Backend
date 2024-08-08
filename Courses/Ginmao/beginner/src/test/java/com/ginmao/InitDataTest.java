package com.ginmao;

import com.ginmao.bean.GtJwks;
import com.ginmao.bean.x509.SimpleKeyPair;
import com.ginmao.constant.Role;
import com.ginmao.domain.*;
import com.ginmao.provider.CityProvider;
import com.ginmao.provider.GtProgramProvider;
import com.ginmao.repository.*;
import com.ginmao.security.bean.SecuritySetting;
import com.ginmao.security.cert.CaType;
import com.ginmao.service.GtDistrictService;
import com.ginmao.service.GtYaoService;
import com.ginmao.service.SecuritySettingService;
import com.ginmao.test.annotation.Slow;
import com.ginmao.util.CertificateUtils;
import com.ginmao.util.DateUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "spring.jpa.generate-ddl=true")
@ActiveProfiles("dev")
@Slf4j
public class InitDataTest {

    @Autowired
    private GtDepartmentRepository departmentRepository;

    @Autowired
    private GtProgramRepository programRepository;

    @Autowired
    private GtRoleRepository roleRepository;

    @Autowired
    private GtAccessRuleRepository accessRuleRepository;

    @Autowired
    private GtUserRepository mgbUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SecuritySettingService securitySettingService;

    @Autowired
    private GtYaoService yaoService;

    @Autowired
    private GtDistrictService districtService;

    @Autowired
    private GtJwks jwks;

    @Slow
    @Commit
    @Test
    void init() {
        initKeys();
        initCities();
        initDepartments();
        initPrograms();
        initRoles();
        initAccessRules();
        initSecuritySetting();
        initUsers();
    }

    @SneakyThrows
    private void initKeys() {

        PrivateKey privateKey = jwks.getPrivateKey();
        PublicKey publicKey = jwks.getPublicKey();

        GtYao target = yaoService.findOne(GtYao_.SELF_BUILT, Boolean.TRUE);
        if (Objects.isNull(target)) {
            target = new GtYao();
            target.setType(YaoType.OAUTH2);
            target.setActivatedOn(LocalDateTime.now());
            target.setAlgorithm(privateKey.getAlgorithm());
            target.setSelfBuilt(Boolean.TRUE);
            target.setYao(privateKey.getEncoded());
            target.setPublicYao(publicKey.getEncoded());
            yaoService.save(target);
        } else {
            target.setType(YaoType.OAUTH2);
            yaoService.update(target);
        }

        for (CaType caType : CaType.values()) {
            Optional<GtYao> yaoOptional = yaoService.findByAlias(caType.name());
            if (!yaoOptional.isPresent()) {
                SimpleKeyPair caKeyPair = null;
                byte[] cert;
                if (caType == CaType.TEMPCA) {
                    caKeyPair = CertificateUtils.createRootCA("CN=gtweb,OU=ginmao,C=TW", 3650);
                    cert = caKeyPair.getCert().getEncoded();
                } else {
                    String resourceName = "/" + caType.name() + ".cer";
                    cert = IOUtils.resourceToByteArray(resourceName);
                }

                X509Certificate x509 = CertificateUtils.load(cert).get();
                GtYao source = new GtYao();
                source.setType(YaoType.CA);
                source.setPublicYao(cert);
                source.setAlgorithm("RSA");
                source.setAlias(caType.name());
                source.setSelfBuilt(Boolean.FALSE);
                source.setActivatedOn(DateUtils.asLocalDateTime(x509.getNotBefore()));
                source.setDeactivatedOn(DateUtils.asLocalDateTime(x509.getNotAfter()));

                if (Objects.nonNull(caKeyPair)) {
                    source.setYao(caKeyPair.getPrivateKey().getEncoded());
                }
                yaoService.save(source);
            } else {
                GtYao yao = yaoOptional.get();
                yao.setType(YaoType.CA);
                yaoService.update(yao);
            }
        }
    }

    @SneakyThrows
    private void initCities() {
        List<GtDistrict> cities = CityProvider.list();
        int sort = -1;
        for (GtDistrict city : cities) {
            sort++;
            GtDistrict target = districtService.findByCode(city.getCode());
            if (Objects.isNull(target)) {
                city.setSort(sort);
                districtService.save(city);
            }
        }
    }

    @SneakyThrows
    void initDepartments() {

        GtDepartment ginmao = departmentRepository.findByNo("27661926");
        if (Objects.isNull(ginmao)) {
            ginmao = new GtDepartment();
        }
        ginmao.setNo("27661926");
        ginmao.setName("晶茂資訊");
        ginmao.setAddress("北區健行路371之11號12樓");
        ginmao.setLeft(0);
        ginmao.setRight(1);
        departmentRepository.save(ginmao);
    }

    void initPrograms() {
        List<GtProgram> programs = GtProgramProvider.list();

        int folderIdx = -1;
        for (GtProgram folder : programs) {
            folderIdx++;
            GtProgram dbFolder = programRepository.findOne("name", folder.getName());
            if (Objects.isNull(dbFolder)) {
                folder.setSort(folderIdx);
                dbFolder = programRepository.save(folder);
            }

            int itemIdx = -1;
            for (GtProgram item : folder.getChildren()) {
                itemIdx++;
                GtProgram dbItem;
                if (StringUtils.isNotEmpty(item.getUrl())) {
                    dbItem = programRepository.findOne("url", item.getUrl());
                } else {
                    dbItem = programRepository.findOne("name", item.getName());
                }

                if (Objects.isNull(dbItem)) {
                    item.setParent(dbFolder);
                    item.setSort(itemIdx);
                    log.info("item={}", item);
                    programRepository.save(item);
                }
            }
        }
    }

    void initRoles() {
        GtRole role = roleRepository.findOne("no", Role.ADMIN);
        if (Objects.isNull(role)) {
            role = new GtRole();
            role.setNo(Role.ADMIN);
            role.setName("系統管理者");
            roleRepository.save(role);
        }
    }

    void initAccessRules() {
        List<GtRole> roles = roleRepository.findAll();
        List<GtProgram> programs = programRepository.findAll();
        for (GtRole role : roles) {
            for (GtProgram program : programs) {
                Map<String, Object> conditions = new HashMap<>();
                conditions.put("role", role);
                conditions.put("program", program);
                GtAccessRule rule = accessRuleRepository.findOne(conditions);
                if (Objects.isNull(rule)) {
                    rule = new GtAccessRule();
                    rule.setRole(role);
                    rule.setProgram(program);
                    for (String action : program.getActions()) {
                        rule.getActions().put(action, Boolean.TRUE);
                    }
                    accessRuleRepository.save(rule);
                }
            }
        }
    }

    void initUsers() {

        GtUser user = mgbUserRepository.findOne("account", "admin");
        if (Objects.isNull(user)) {
            user = new GtUser();
            user.setAccount("admin");
        }
        user.setName("系統管理者");
        user.setEmail("franky.tang@ginmao.com.tw");
        user.setDepartment(departmentRepository.findOne("no", "27661926"));
        user.setMima(passwordEncoder.encode("1111"));
        user.setLastMimaDate(LocalDate.now());
        user.setRoles(new HashSet<>());
        user.getRoles().add(roleRepository.findOne("no", "ADMIN"));
        mgbUserRepository.save(user);
    }

    private void initSecuritySetting() {
        SecuritySetting config = new SecuritySetting();
        config.setMultiFactorAuth(0);
        config.setSessionTimeout(60);
        config.setAccountUnmaskLength(2);
        config.setTempMimaLife(30);
        config.setAuthTryTimes(99);
        config.setAccountUnlock(0);
        config.setLockTime(5);
        config.setMimaLength(8);
        config.setMimaComplexity(2);
        config.setMimaMinLife(0);
        config.setMimaMaxLife(999);

        securitySettingService.save(config);
    }
}
