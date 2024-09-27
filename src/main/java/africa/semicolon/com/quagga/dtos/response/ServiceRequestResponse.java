package africa.semicolon.com.quagga.dtos.Response;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.services.ServiceRequestServices;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceRequestResponse {
    private String message;
    private ServiceRequest serviceRequest;
}
