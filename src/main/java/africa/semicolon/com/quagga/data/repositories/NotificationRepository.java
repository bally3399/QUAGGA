package africa.semicolon.com.quagga.data.repositories;

import africa.semicolon.com.quagga.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
