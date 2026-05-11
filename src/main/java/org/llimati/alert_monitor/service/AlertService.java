package org.llimati.alert_monitor.service;

import lombok.RequiredArgsConstructor;
import org.llimati.alert_monitor.model.Alert;
import org.llimati.alert_monitor.repository.AlertRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlertService {
    private final AlertRepository alertRepository;

    public Alert createAlert (Alert alert){
        return alertRepository.save(alert);
    }

}
