package org.llimati.alert_monitor.scheduler;


import lombok.RequiredArgsConstructor;
import org.llimati.alert_monitor.model.Alert;
import org.llimati.alert_monitor.service.AlertService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AlertScheduler {

    private final AlertService alertService;

    @Scheduled(fixedDelay = 60000)
    public void renotifyCriticalAlerts() {
        List<Alert> criticalAlerts = alertService.findCriticalUnacknowledged();
        for (Alert alert : criticalAlerts) {
            alertService.sendCriticalAlertEmail(alert);
        }
    }

}
