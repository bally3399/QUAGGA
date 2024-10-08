package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.data.repositories.SpecialistRepository;
import africa.semicolon.com.quagga.exceptions.SpecialistDoesNotExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        specialist.setCategory(request.getCategory());
//        specialist.setSubCategory(request.getSubCategory());
        specialist.setCategory(request.getCategory());
        specialist.setCompanyName(request.getCompanyName());
        specialist.setCompanyRegNo(request.getCompanyRegNo());
        return specialistRepository.save(specialist);

    }

    @Override
    public List<Specialist> findAllAvailableSpecialist() {
//        List<Specialist> specialists = specialistRepository.findAll();
        List<Specialist> availableSpecialists = new ArrayList<>();
        for (Specialist specialist : specialistRepository.findAll()) {
            if (specialist.isAvailability()){
                availableSpecialists.add(specialist);
            }
        }
        return availableSpecialists;
    }
    @Override
    public List<Specialist> findAllSpecialist() {
        return specialistRepository.findAll();
    }

    @Override
    public Specialist findById(Long specialistId) {
        return specialistRepository.findById(specialistId)
                .orElseThrow(()-> new SpecialistDoesNotExistException("Specialist does not exist"));
    }

    @Override
    public void delete(long id) {
        specialistRepository.deleteById(id);
    }

    @Override
    public Specialist findByUserId(Long id) {
        return null;
    }

    @Override
    public Specialist findSpecialistByUser(User specialist) {
        return specialistRepository.findSpecialistByUser(specialist);
    }

    @Override
    public void deleteAll() {
        specialistRepository.deleteAll();
    }

    @Override
    public List<Specialist> findSpecialistsByCategory(Category category) {
        List<Specialist> allSpecialist = findAllSpecialist();
        List<Specialist> specialistByCategory = new ArrayList<>();

        for (Specialist specialist : allSpecialist) {
            if (specialist.getCategory() != null && specialist.getCategory().equals(category)) {
                specialistByCategory.add(specialist);
            }
        }
        return specialistByCategory;
    }

    @Override
    public Specialist update(Specialist specialist) {
        return specialistRepository.save(specialist);
    }


}
