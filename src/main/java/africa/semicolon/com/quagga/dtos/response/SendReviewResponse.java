package africa.semicolon.com.quagga.dtos.Response;

import africa.semicolon.com.quagga.data.models.Review;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendReviewResponse {
    private String message;
    private Review review;
}
