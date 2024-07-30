package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Admin;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{


    @Override
    public Admin createAdmin(User savedUser, RegisterRequest request) {
        return null;
    }
}
