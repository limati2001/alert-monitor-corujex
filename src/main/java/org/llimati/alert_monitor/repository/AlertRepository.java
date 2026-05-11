package org.llimati.alert_monitor.repository;

import org.llimati.alert_monitor.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
