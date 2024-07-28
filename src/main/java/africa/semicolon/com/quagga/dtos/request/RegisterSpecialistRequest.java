package africa.semicolon.com.quagga.dtos.request;


import africa.semicolon.com.quagga.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterSpecialistRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private String address;
    private Role role;
    private int rating;
    private String comment;
    private String companyName;
    private String companyRegNo;
    private String professionalSkills;

}
