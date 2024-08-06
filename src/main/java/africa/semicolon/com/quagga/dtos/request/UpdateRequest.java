package africa.semicolon.com.quagga.dtos.request;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String LGA;
    private String state;
    private String companyName;
    private String companyRegNo;
    private Category Category;
    private String phoneNumber;
}
