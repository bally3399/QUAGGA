package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Notification;
import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.UserRepository;
import africa.semicolon.com.quagga.dtos.Response.NotificationResponse;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
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
    @Autowired
    private UserService userService;
    private User receiver;
    private User sender;

    @BeforeEach
    public void setNotificationService(){
        notificationService.deleteAll();
        userService.deleteAll();

        User user = new User();
        user.setFirstName("Paul");
        user.setLastName("Bond");
        user.setPassword("911");
        user.setEmail("paul@gmail.com");
        user.setAddress("No 30, Helen Street, Idumota, Lagos");
        user.setPhoneNumber("08133856789");
        user.setRole(Role.CLIENT);
        user.setLGA("Sabo");
        user.setState("Lagos");

        receiver = userService.save(user);

        User user2 = new User();
        user2.setFirstName("Seun");
        user2.setLastName("Bond");
        user2.setPassword("9111");
        user2.setEmail("seun@gmail.com");
        user2.setAddress("No 30, Helena Street, Idumota, Lagos");
        user2.setPhoneNumber("08133855789");
        user2.setRole(Role.SUPPLIER);
        user2.setLGA("Yaba");
        user2.setState("Lagos");

        sender = userService.save(user2);
    }

    @Test
    public void testCreateNotification(){
        CreateNotificationRequest notificationRequest = new CreateNotificationRequest();
        notificationRequest.setMessage("You have a notification");
        notificationRequest.setReceiverId(receiver.getId());
        notificationRequest.setSenderId(sender.getId());
        NotificationResponse response = notificationService.create(notificationRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Notification created successfully");
        notificationService.deleteAll();
        userService.deleteAll();
    }
    @Test
    public void findNotification(){
        CreateNotificationRequest notificationRequest = new CreateNotificationRequest();
        notificationRequest.setMessage("You have a notification");
        notificationRequest.setReceiverId(receiver.getId());
        notificationRequest.setSenderId(sender.getId());
        NotificationResponse response = notificationService.create(notificationRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Notification created successfully");

        Notification notification = notificationService.findById(response.getNotification().getId());
        assertThat(notification).isNotNull();
        assertThat(notification.getMessage()).isEqualTo("You have a notification from Seun");
        assertThat(notification.getReceiver().getId()).isEqualTo(receiver.getId());
        assertThat(notification.getSender().getId()).isEqualTo(sender.getId());
        notificationService.deleteAll();
        userService.deleteAll();
    }
}
