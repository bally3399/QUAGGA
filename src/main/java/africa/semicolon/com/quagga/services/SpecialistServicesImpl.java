package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.repository.SpecialistRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialistServicesImpl implements SpecialistService {
    private final ModelMapper modelMapper;
    private final SpecialistRepository specialistRepository;


    @Override
    public Specialist createSpecialist(User user, RegisterRequest request) {
        Specialist specialist = new Specialist();
        specialist.setUser(user);
        specialist.setAvailability(true);
        specialist.setProfessionalSkills(request.getProfessionalSkills());
        specialist.setCompanyName(request.getCompanyName());
        specialist.setCompanyRegNo(request.getCompanyRegNo());
        return specialistRepository.save(specialist);

    }

}
