package africa.semicolon.com.quagga.dtos.response;

import africa.semicolon.com.quagga.data.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
private String message;
private String jwtToken;
private String role;
}
