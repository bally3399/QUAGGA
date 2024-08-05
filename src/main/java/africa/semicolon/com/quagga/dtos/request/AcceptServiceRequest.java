package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcceptServiceRequest {
    private Long serviceId;
    private Long specialistId;
}
