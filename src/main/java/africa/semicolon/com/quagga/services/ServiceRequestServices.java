package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.dtos.Response.*;
import africa.semicolon.com.quagga.dtos.request.*;
public interface ServiceRequestServices {

    ServiceRequestResponse create(CreateServiceRequest serviceRequest);

    AcceptServiceResponse accept(AcceptServiceRequest serviceRequest);

    ServiceRequest findById(long id);

    RejectServiceResponse reject(RejectServiceRequest rejectServiceRequest);
    CompleteServiceResponse complete(CompleteServiceRequest completeServiceRequest);

    void deleteAll();
}
