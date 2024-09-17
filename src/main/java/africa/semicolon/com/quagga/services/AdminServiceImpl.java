package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Admin;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.AdminRepository;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    @Lazy
    private final EmailService emailService;

    @Override
    public Admin createAdmin(User savedUser, RegisterRequest request) {
        Admin newAdmin = new Admin();
        newAdmin.setUser(savedUser);
        Admin savedAdmin = adminRepository.save(newAdmin);
        emailService.sendEmail(savedUser.getEmail(), "REGISTRATION SUCCESSFUL",
                "Hello " + savedUser.getFirstName() + " "
                        + savedUser.getLastName() +
                        "\nYou have successfully registered to quagga as a " + savedUser.getRole()
        );
        return savedAdmin;
    }



}
