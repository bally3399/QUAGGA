package africa.semicolon.com.quagga.dtos.Response;

import africa.semicolon.com.quagga.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private String message;
    private User user;
}
