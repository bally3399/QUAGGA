package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;

public interface RequestService {

    ServiceRequestResponse create(CreateServiceRequest serviceRequest);
}
