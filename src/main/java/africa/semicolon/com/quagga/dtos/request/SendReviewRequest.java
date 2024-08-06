package africa.semicolon.com.quagga.dtos.request;

import africa.semicolon.com.quagga.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendReviewRequest {
    private Long senderId;
    private Long receiverId;
    private int rating;
    private String comment;
}
