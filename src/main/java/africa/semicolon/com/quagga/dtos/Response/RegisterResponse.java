package africa.semicolon.com.quagga.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private String message;
    private String jwtToken;
}
