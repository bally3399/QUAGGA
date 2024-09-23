package africa.semicolon.com.quagga.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String LGA;
    private String state;
    private String phoneNumber;
}
