package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.dtos.Request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.Response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);


}
