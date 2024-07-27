package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.RegisterSpecialistRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterSpecialistResponse;

public interface SpecialistService {
    RegisterSpecialistResponse registerSpecialist(RegisterSpecialistRequest request);
}
