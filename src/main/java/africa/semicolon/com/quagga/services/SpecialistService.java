package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;

public interface SpecialistService {
    RegisterSpecialistResponse registerSpecialist(RegisterRequest request);

    void createSpecialist(User savedUser);
}
