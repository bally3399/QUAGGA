package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Supplier;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;

import africa.semicolon.com.quagga.data.repositories.SupplierRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    @Lazy
    private final EmailService emailService;

    @Override
    public Supplier createSupplier(User savedUser, RegisterRequest request) {
        Supplier newSupplier = new Supplier();
        newSupplier.setUser(savedUser);
        newSupplier.setCategory(request.getCategory());
        emailService.sendEmail(savedUser.getEmail(), "REGISTRATION SUCCESSFUL",
                "Hello " + savedUser.getFirstName() + " "
                        + savedUser.getLastName() +
                        "\nYou have successfully registered to quagga as a " + savedUser.getRole()
        );
        return supplierRepository.save(newSupplier);
    }

    @Override
    public void deleteAll() {
        supplierRepository.deleteAll();
    }

}
