package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Client;
import africa.semicolon.com.quagga.data.models.ServiceRequest;
import africa.semicolon.com.quagga.data.models.ServiceRequestStatus;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.repositories.ServiceRepository;
import africa.semicolon.com.quagga.dtos.request.AcceptServiceRequest;
import africa.semicolon.com.quagga.dtos.request.CreateServiceRequest;
import africa.semicolon.com.quagga.dtos.response.AcceptServiceResponse;
import africa.semicolon.com.quagga.dtos.response.ServiceRequestResponse;
import africa.semicolon.com.quagga.exceptions.ServiceDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceRequestServicesImpl implements ServiceRequestServices {

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
        newServiceRequest.setServiceRequestStatus(ServiceRequestStatus.PENDING);
        serviceRepository.save(newServiceRequest);

        ServiceRequestResponse response = new ServiceRequestResponse();
        response.setMessage("Request sent successfully");
        return response;
    }

    @Override
    public AcceptServiceResponse accept(AcceptServiceRequest serviceRequest) {
        Long serviceId = serviceRequest.getServiceId();
        Long specialistId = serviceRequest.getSpecialistId();

//        ServiceRequest foundService = findServiceById(serviceId);
        for (ServiceRequest service : serviceRepository.findAll()){
            if (service.getId().equals(serviceId) && service.getSpecialist().getSpecialistId().equals(specialistId)){
                service.setServiceRequestStatus(ServiceRequestStatus.ACCEPTED);
                serviceRepository.save(service);
                AcceptServiceResponse response = new AcceptServiceResponse();
                response.setMessage("Service accepted");
                return response;
            }
        }
        throw new ServiceDoesNotExistException("Service does not exist");
    }

    @Override
    public ServiceRequest findById(long id) {
        return serviceRepository.findById(id)
                .orElseThrow(()-> new ServiceDoesNotExistException("Service does not exist exception"));
    }

}
