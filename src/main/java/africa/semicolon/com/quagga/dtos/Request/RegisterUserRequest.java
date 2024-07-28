package africa.semicolon.com.quagga.dtos.Request;

import africa.semicolon.com.quagga.data.models.Order;
import africa.semicolon.com.quagga.data.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Role role;
    private List<Order> orders;
}
