package africa.semicolon.com.quagga.dtos.request;


import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    @JsonProperty
    private Role role;
    private String LGA;
    private String state;
    private String companyName;
    private String companyRegNo;
    private Category Category;
    private String phoneNumber;

}
