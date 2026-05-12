package org.llimati.alert_monitor.repository;

import org.llimati.alert_monitor.model.Alert;
import org.llimati.alert_monitor.model.Severity;
import org.llimati.alert_monitor.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findBySeverityAndStatus(Severity severity, Status status);
}
