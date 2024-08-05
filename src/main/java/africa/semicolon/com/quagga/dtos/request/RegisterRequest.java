package africa.semicolon.com.quagga.dtos.request;


import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.SubCategory;
import jakarta.persistence.Column;
import lombok.Getter;
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
    private Role role;
    private String companyName;
    private String companyRegNo;
    private Category Category;
    private String typeOfMaterial;
    private String phoneNumber;
    private String LGA;
    private String state;
    private SubCategory subCategory;
}
