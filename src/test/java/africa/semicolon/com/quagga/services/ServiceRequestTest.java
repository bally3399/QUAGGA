package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.*;
import africa.semicolon.com.quagga.dtos.Response.*;
import africa.semicolon.com.quagga.dtos.request.*;
import africa.semicolon.com.quagga.exceptions.UnacceptedServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static africa.semicolon.com.quagga.data.models.ServiceRequestStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
public class ServiceRequestTest {

    @Autowired
    public UserService userService;

    @Autowired
    public ClientService clientService;

    @Autowired
    public SpecialistService specialistService;

    @Autowired
    public SupplierService supplierService;

    @Autowired
    public ServiceRequestServices requestService;
    private User client;
    private User specialist;
    private User supplier;
    private ServiceRequest serviceRequest1;

    private RegisterResponse clientsResponse;
    private RegisterResponse specialistResponse;
    private RegisterResponse supplierResponse;
    private ServiceRequestResponse response;



    @BeforeEach
    public void setUserService(){
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Paul");
        request.setLastName("Bond");
        request.setPassword("911");
        request.setEmail("paul@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08133856789");
        request.setRole(Role.CLIENT);
        request.setCategory(Category.STRUCTURAL);
        request.setLGA("Sabo");
        request.setState("Lagos");

        clientsResponse = userService.register(request);
        client = clientsResponse.getUser();

        RegisterRequest request2 = new RegisterRequest();
        request2.setFirstName("Seun");
        request2.setLastName("Bond");
        request2.setPassword("9111");
        request2.setEmail("seun@gmail.com");
        request2.setAddress("No 30, Helena Street, Idumota, Lagos");
        request2.setPhoneNumber("08134856789");
        request2.setRole(Role.SPECIALIST);
        request2.setCategory(Category.STRUCTURAL);
        request2.setLGA("Sabo");
        request2.setState("Lagos");

        specialistResponse = userService.register(request2);
        specialist = specialistResponse.getUser();

        RegisterRequest request3 = new RegisterRequest();
        request3.setFirstName("Tayo");
        request3.setLastName("Bond");
        request3.setPassword("9211");
        request3.setEmail("tayo@gmail.com");
        request3.setAddress("No 30, Helenaw Street, Idumota, Lagos");
        request3.setPhoneNumber("08134556789");
        request3.setRole(Role.SUPPLIER);
        request3.setCategory(Category.STRUCTURAL);
        request3.setLGA("Sabo");
        request3.setState("Lagos");

        supplierResponse = userService.register(request3);
        supplier = supplierResponse.getUser();

        Client foundClient = clientService.findClientByUser(this.client);
        Specialist foundSpecialist = specialistService.findSpecialistByUser(this.specialist);

        CreateServiceRequest serviceRequest = new CreateServiceRequest();
        serviceRequest.setClientId(foundClient.getId());
        serviceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        serviceRequest.setServiceDescription("I am in need of plumbing service");
        response = requestService.create(serviceRequest);
        serviceRequest1= response.getServiceRequest();
    }

    @Test
    public void testCreateService(){

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request sent successfully");
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testFindService(){
        ServiceRequest serviceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(serviceRequest).isNotNull();
        assertThat(serviceRequest.getDescription()).isEqualTo("I am in need of plumbing service");
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testAcceptServiceRequest(){
        Specialist foundSpecialist = specialistService.findSpecialistByUser(this.specialist);
        ServiceRequest foundPendingServiceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);
        AcceptServiceRequest serviceRequest = new AcceptServiceRequest();
        serviceRequest.setServiceId(serviceRequest1.getId());
        serviceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        AcceptServiceResponse response = requestService.accept(serviceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Service accepted");
        ServiceRequest foundAcceptedServiceRequest = requestService.findById(foundPendingServiceRequest.getId());
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(ACCEPTED);
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testRejectServiceRequest(){
        Specialist foundSpecialist = specialistService.findSpecialistByUser(this.specialist);
        ServiceRequest foundPendingServiceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);
        RejectServiceRequest rejectServiceRequest = new RejectServiceRequest();
        rejectServiceRequest.setServiceId(foundPendingServiceRequest.getId());
        rejectServiceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        rejectServiceRequest.setReason("Not enough time");
        RejectServiceResponse response = requestService.reject(rejectServiceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Request rejected, Not enough time");
        ServiceRequest foundAcceptedServiceRequest = requestService.findById(foundPendingServiceRequest.getId());
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(REJECTED);
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testCompleteServiceRequest(){
        Specialist foundSpecialist = specialistService.findSpecialistByUser(this.specialist);
        ServiceRequest foundPendingServiceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);

        AcceptServiceRequest serviceRequest = new AcceptServiceRequest();
        serviceRequest.setServiceId(serviceRequest1.getId());
        serviceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        requestService.accept(serviceRequest);
        ServiceRequest foundAcceptedServiceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(foundAcceptedServiceRequest.getServiceRequestStatus()).isEqualTo(ACCEPTED);

        CompleteServiceRequest completeServiceRequest = new CompleteServiceRequest();
        completeServiceRequest.setServiceId(serviceRequest1.getId());
        completeServiceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        CompleteServiceResponse response = requestService.complete(completeServiceRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Service completed");
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testCompleteServiceRequestThrowExceptionIfStatusIsNotAccepted(){
        Specialist foundSpecialist = specialistService.findSpecialistByUser(this.specialist);
        ServiceRequest foundPendingServiceRequest = requestService.findById(serviceRequest1.getId());
        assertThat(foundPendingServiceRequest.getServiceRequestStatus()).isEqualTo(PENDING);

        CompleteServiceRequest completeServiceRequest = new CompleteServiceRequest();
        completeServiceRequest.setServiceId(serviceRequest1.getId());
        completeServiceRequest.setSpecialistId(foundSpecialist.getSpecialistId());
        assertThrows(UnacceptedServiceException.class, ()->requestService.complete(completeServiceRequest));
        requestService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }


}
