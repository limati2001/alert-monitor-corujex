package org.llimati.alert_monitor.controller;

import lombok.RequiredArgsConstructor;
import org.llimati.alert_monitor.model.Alert;
import org.llimati.alert_monitor.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @PatchMapping("/{id}/acknowledge")
    public Alert acknowledge(@PathVariable Long id) {
        return alertService.acknowledge(id);
    }
}
