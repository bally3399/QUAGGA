package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateReviewRequest {
    private Long reviewId;
    private Long userId;
}
