package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateNotificationRequest {
    private Long receiverId;
    private Long senderId;
    private String message;
}
