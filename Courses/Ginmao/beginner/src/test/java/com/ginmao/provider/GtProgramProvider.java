package com.ginmao.provider;

import com.ginmao.bean.SimpleRequestMap;
import com.ginmao.domain.GtProgram;
import com.ginmao.util.ControllerUtils;

import java.util.*;

public class GtProgramProvider {

    private static Set<SimpleRequestMap> srms = null;

    private static Set<SimpleRequestMap> getSrms() {
        if (Objects.isNull(srms)) {
            srms = ControllerUtils.getAllAdminRequestMappings();
        }
        return srms;
    }

    public static List<GtProgram> list() {

        List<GtProgram> GtPrograms = new ArrayList<>();
        GtProgram folder = createFolder("dashboard", "儀表板", "/gt/index");
        GtPrograms.add(folder);


        folder = createFolder("windows", "系統管理");
        GtPrograms.add(folder);

        folder.getChildren().add(createGtProgram(
            "building", "縣市代碼管理", "/gt/gt-district"
        ));
        folder.getChildren().add(createGtProgram(
            "gear", "參數管理", "/gt/gt-code"
        ));
        folder.getChildren().add(createGtProgram(
            "key", "資安參數設定", "/gt/security-setting"
        ));
        folder.getChildren().add(createGtProgram(
            "list", "選單管理", "/gt/gt-program"
        ));
        folder.getChildren().add(createGtProgram(
            "sitemap", "單位管理", "/gt/gt-department"
        ));
        folder.getChildren().add(createGtProgram(
            "group", "角色管理", "/gt/gt-role"
        ));

        folder.getChildren().add(createGtProgram(
            "user", "使用者管理", "/gt/gt-user"
        ));

        folder.getChildren().add(createGtProgram(
            "user-secret", "個人基本資料", "/gt/profile"
        ));

        folder.getChildren().add(createGtProgram(
            "linux", "系統基本資料", "/gt/gt-app"
        ));

        folder.getChildren().add(createGtProgram(
            "newspaper-o", "最新消息", "/gt/gt-bulletin"
        ));
        folder.getChildren().add(createGtProgram(
            "user-o", "使用者異動紀錄查詢", "/gt/gt-user-change-log"
        ));
        folder.getChildren().add(createGtProgram(
            "lock", "使用者登入登出紀錄查詢", "/gt/gt-user-auth-log"
        ));


        folder = createFolder("certificate", "憑證管理");
        GtPrograms.add(folder);

        folder.getChildren().add(createGtProgram(
            "download", "廢止清冊匯入紀錄查詢", "/gt/gt-cert-revoke-log"
        ));

        folder.getChildren().add(createGtProgram(
            "id-card", "憑證廢止清冊", "/gt/gt-cert-revoke"
        ));


        return GtPrograms;
    }

    private static GtProgram createFolder(String icon, String name) {
        return createFolder(icon, name, null);
    }

    private static GtProgram createFolder(String icon, String name, String url) {
        GtProgram folder = new GtProgram();
        folder.setIcon(icon);
        folder.setName(name);
        folder.setUrl(url);
        folder.setChildren(new ArrayList<>());
        return folder;
    }

    private static GtProgram createGtProgram(
        String icon, String name, String url
    ) {
        GtProgram GtProgram = new GtProgram();
        GtProgram.setIcon(icon);
        GtProgram.setName(name);
        GtProgram.setUrl(url);
        fillControllerAndActions(GtProgram, getSrms());
        return GtProgram;
    }

    private static void fillControllerAndActions(
        GtProgram GtProgram, Collection<SimpleRequestMap> srms
    ) {
        for (SimpleRequestMap srm : srms) {
            if (srm.getBase().equals(GtProgram.getUrl())) {
                GtProgram.setController(srm.getController());
                GtProgram.setActions(srm.getMains());
                break;
            }
        }
    }


}
