package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.dtos.request.AcceptServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CompleteServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.request.RejectServiceRequest;
import africa.semicolon.com.quagga.dtos.response.AcceptServiceResponse;
import africa.semicolon.com.quagga.dtos.response.CompleteServiceResponse;
import africa.semicolon.com.quagga.dtos.response.RejectServiceResponse;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;
import africa.semicolon.com.quagga.exceptions.UnacceptedServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static africa.semicolon.com.quagga.data.models.ServiceRequestStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class ServiceRequestTest {

    @Autowired
    private ServiceRequestServices serviceRequestServices;

    @Test
    public void testCreateService(){
        CreateServiceRequest serviceRequest = new CreateServiceRequest();
        serviceRequest.setClientId(301L);
        serviceRequest.setSpecialistId(201L);
        serviceRequest.setServiceDescription("I am in need of plumbing service");
        ServiceRequestResponse response = serviceRequestServices.create(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request sent successfully");
    }

    @Test
    public void testFindService(){
        ServiceRequest serviceRequest = serviceRequestServices.findById(401L);
        assertThat(serviceRequest).isNotNull();
        assertThat(serviceRequest.getDescription()).isEqualTo("I am in need of Electrical service");
    }

    @Test
    public void testAcceptServiceRequest(){
        ServiceRequest foundPendingServiceRequest = serviceRequestServices.findById(401L);
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);
        AcceptServiceRequest serviceRequest = new AcceptServiceRequest();
        serviceRequest.setServiceId(401L);
        serviceRequest.setSpecialistId(203L);
        AcceptServiceResponse response = serviceRequestServices.accept(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Service accepted");
        ServiceRequest foundAcceptedServiceRequest = serviceRequestServices.findById(401L);
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(ACCEPTED);
    }

    @Test
    public void testRejectServiceRequest(){
        ServiceRequest foundPendingServiceRequest = serviceRequestServices.findById(401L);
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);
        RejectServiceRequest rejectServiceRequest = new RejectServiceRequest();
        rejectServiceRequest.setServiceId(401L);
        rejectServiceRequest.setSpecialistId(203L);
        rejectServiceRequest.setReason("Not enough time");
        RejectServiceResponse response = serviceRequestServices.reject(rejectServiceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request rejected, Not enough time");
        ServiceRequest foundAcceptedServiceRequest = serviceRequestServices.findById(401L);
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(REJECTED);
    }

    @Test
    public void testCompleteServiceRequest(){
        ServiceRequest foundPendingServiceRequest = serviceRequestServices.findById(403L);
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);

        AcceptServiceRequest serviceRequest = new AcceptServiceRequest();
        serviceRequest.setServiceId(403L);
        serviceRequest.setSpecialistId(202L);
        serviceRequestServices.accept(serviceRequest);
        ServiceRequest foundAcceptedServiceRequest = serviceRequestServices.findById(403L);
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(ACCEPTED);

        CompleteServiceRequest completeServiceRequest = new CompleteServiceRequest();
        completeServiceRequest.setServiceId(403L);
        completeServiceRequest.setSpecialistId(202L);
        CompleteServiceResponse response = serviceRequestServices.complete(completeServiceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Service completed");
    }

    @Test
    public void testCompleteServiceRequestThrowExceptionIfStatusIsNotAccepted(){
        ServiceRequest foundPendingServiceRequest = serviceRequestServices.findById(403L);
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);

        CompleteServiceRequest completeServiceRequest = new CompleteServiceRequest();
        completeServiceRequest.setServiceId(403L);
        completeServiceRequest.setSpecialistId(202L);
        assertThrows(UnacceptedServiceException.class, ()->serviceRequestServices.complete(completeServiceRequest));

    }


}
