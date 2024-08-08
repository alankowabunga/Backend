package com.ginmao;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BeginnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeginnerApplication.class, args);
        try {
            Runtime rt = Runtime.getRuntime();
            String url = "https://localhost:8443/gt";

            String osName = System.getProperty("os.name");
            if (StringUtils.containsAnyIgnoreCase(osName, "Mac")) {
                rt.exec("/usr/bin/open " + url);
            } else {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        } catch (Exception e) {
            log.warn("開啟瀏覽器失敗", e);
        }
    }
}
