package africa.semicolon.com.quagga.controllers;

import africa.semicolon.com.quagga.dtos.Response.ApiResponse;
import africa.semicolon.com.quagga.dtos.Response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quagga")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/createAdmin")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest request){
        try{
            RegisterResponse response = userService.register(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),  HttpStatus.BAD_REQUEST);
        }
    }

}
