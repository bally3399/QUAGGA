package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.dtos.request.AcceptServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.response.AcceptServiceResponse;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;

public interface ServiceRequestServices {

    ServiceRequestResponse create(CreateServiceRequest serviceRequest);

    AcceptServiceResponse accept(AcceptServiceRequest serviceRequest);

    ServiceRequest findById(long id);
}
