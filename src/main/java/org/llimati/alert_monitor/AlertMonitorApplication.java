package org.llimati.alert_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AlertMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertMonitorApplication.class, args);
    }

}
