package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Notification;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;
import africa.semicolon.com.quagga.dtos.response.NotificationResponse;

public interface NotificationService {
    NotificationResponse create(CreateNotificationRequest notificationRequest);

    Notification findById(long id);
}
