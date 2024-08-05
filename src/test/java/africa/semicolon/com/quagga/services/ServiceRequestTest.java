package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.dtos.request.AcceptServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.response.AcceptServiceResponse;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static africa.semicolon.com.quagga.data.models.ServiceRequestStatus.ACCEPTED;
import static africa.semicolon.com.quagga.data.models.ServiceRequestStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;

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
    public void testAcceptService(){
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

}
