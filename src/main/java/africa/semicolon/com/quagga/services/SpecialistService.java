package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

import java.util.List;

public interface SpecialistService {
    Specialist createSpecialist(User user, RegisterRequest request);


    List<Specialist> findAllAvailableSpecialist();

    List<Specialist> findAllSpecialist();

    Specialist findById(Long specialistId);

    void delete(long id);

    Specialist findByUserId(Long id);

    Specialist findSpecialistByUser(User specialist);

    void deleteAll();
}
