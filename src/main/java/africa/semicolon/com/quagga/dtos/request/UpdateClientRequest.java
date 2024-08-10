package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateClientRequest {
    private Long clientId;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String phoneNumber;
}
