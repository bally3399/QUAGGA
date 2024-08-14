package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Notification;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;
import africa.semicolon.com.quagga.dtos.response.NotificationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
public class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;
    @Test
    public void testCreateNotification(){
        CreateNotificationRequest notificationRequest = new CreateNotificationRequest();
        notificationRequest.setMessage("You have a notification");
        notificationRequest.setReceiverId(105L);
        notificationRequest.setSenderId(101L);
        NotificationResponse response = notificationService.create(notificationRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Notification created successfully");
    }
    @Test
    public void findNotification(){
        Notification notification = notificationService.findById(1L);
        assertThat(notification).isNotNull();
        assertThat(notification.getMessage()).isEqualTo("You have a notification from Jane");
        assertThat(notification.getReceiver().getId()).isEqualTo(105L);
        assertThat(notification.getSender().getId()).isEqualTo(101L);
    }
}
