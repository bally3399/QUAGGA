package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterUserRequest;
import africa.semicolon.com.quagga.dtos.Response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterRequest request);


}
