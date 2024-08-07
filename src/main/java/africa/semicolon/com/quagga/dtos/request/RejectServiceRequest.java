package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RejectServiceRequest {
    private Long serviceId;
    private Long specialistId;
    private String reason;
}
