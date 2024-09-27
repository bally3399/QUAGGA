package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Notification;
import africa.semicolon.com.quagga.dtos.Response.NotificationResponse;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;

public interface NotificationService {
    NotificationResponse create(CreateNotificationRequest notificationRequest);

    Notification findById(long id);

    void deleteAll();

}
