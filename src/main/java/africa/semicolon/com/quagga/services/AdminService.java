package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Admin;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;

public interface AdminService {
    Admin createAdmin(User savedUser, RegisterRequest request);
}
