package africa.semicolon.com.quagga.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgetPasswordRequest {
    private String otp;
    private String newPassword;
}
