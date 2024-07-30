package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

public interface SpecialistService {
    Specialist createSpecialist(User user, RegisterRequest request);


}
