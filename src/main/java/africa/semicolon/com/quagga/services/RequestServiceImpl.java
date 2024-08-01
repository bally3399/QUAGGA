package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.repositories.ServiceRepository;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService{

    private final ServiceRepository serviceRepository;
    private final ClientService clientService;
    private final SpecialistService specialistService;

    @Override
    public ServiceRequestResponse create(CreateServiceRequest serviceRequest) {
        Client client = clientService.findById(serviceRequest.getClientId());
        Specialist specialist = specialistService.findById(serviceRequest.getSpecialistId());
        ServiceRequest newServiceRequest = new ServiceRequest();

        newServiceRequest.setClient(client);
        newServiceRequest.setSpecialist(specialist);
        newServiceRequest.setDescription(serviceRequest.getServiceDescription());
        serviceRepository.save(newServiceRequest);

        ServiceRequestResponse response = new ServiceRequestResponse();
        response.setMessage("Request sent successfully");
        return response;
    }

}
