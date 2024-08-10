package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String companyName;
    private String companyRegNo;
    private String phoneNumber;

}
