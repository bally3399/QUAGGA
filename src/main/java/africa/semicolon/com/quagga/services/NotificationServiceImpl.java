package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Notification;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.NotificationRepository;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;
import africa.semicolon.com.quagga.dtos.response.NotificationResponse;
import africa.semicolon.com.quagga.exceptions.NotificationNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository notificationRepository;
    private final UserService userService;

    @Override
    public NotificationResponse create(CreateNotificationRequest notificationRequest) {
        User notificationSender = userService.findUserById(notificationRequest.getSenderId());
        User notificationReceiver = userService.findUserById(notificationRequest.getReceiverId());

        Notification notification = new Notification();
        notification.setMessage("You have a notification from " + notificationSender.getFirstName());
        notification.setReceiver(notificationReceiver);
        notification.setSender(notificationSender);
        Notification savedNotification =notificationRepository.save(notification);
        NotificationResponse response = new NotificationResponse();
        response.setMessage("Notification created successfully");
        response.setNotification(savedNotification);
        return response;
    }

    @Override
    public Notification findById(long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
    }

    @Transactional
    @Override
    public void deleteAll() {
        notificationRepository.deleteAll();
    }


}
