package africa.semicolon.com.quagga.controllers;

import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.dtos.request.ForgetPasswordRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.response.ApiResponse;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequest request){
        try{
            RegisterResponse response = userService.register(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),  HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/generateOtp")
    public ResponseEntity<?> generateOtp(@RequestParam String email){
        try{
            userService.generateOtp(email);
            return new ResponseEntity<>(new ApiResponse(true, userService.generateOtp(email)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/changeForgetPassword")
    public ResponseEntity<?> changePassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest){
        try{
            return new ResponseEntity<>(new ApiResponse(true, userService.changeForgetPassword(forgetPasswordRequest)), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
