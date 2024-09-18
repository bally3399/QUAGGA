package africa.semicolon.com.quagga.dtos.response;

import africa.semicolon.com.quagga.data.models.Notification;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationResponse {
    private Notification notification;
    private String message;
}
