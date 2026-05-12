package org.llimati.alert_monitor.service;

import lombok.RequiredArgsConstructor;
import org.llimati.alert_monitor.model.Alert;
import org.llimati.alert_monitor.model.Severity;
import org.llimati.alert_monitor.repository.AlertRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlertService {
    private final AlertRepository alertRepository;
    private final JavaMailSender mailSender;

    public Alert createAlert (Alert alert){
        Alert saved = alertRepository.save(alert);

        if (alert.getSeverity() == Severity.CRITICAL){
            sendCriticalAlertEmail(saved);
        }
        return saved;
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    private void sendCriticalAlertEmail(Alert alert) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("llimati2001@gmail.com");
        message.setSubject("CRITICAL Alert: " + alert.getSource());
        message.setText("Alert message: " + alert.getMessage() + "\nSource: " + alert.getSource() + "\nTime: " + alert.getCreatedAt());
        mailSender.send(message);
    }

}
