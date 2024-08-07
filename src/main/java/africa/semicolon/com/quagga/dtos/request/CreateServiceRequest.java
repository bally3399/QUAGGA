package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateServiceRequest {
    private Long ClientId;
    private Long SpecialistId;
    private String ServiceDescription;
}
