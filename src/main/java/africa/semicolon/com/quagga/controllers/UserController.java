package africa.semicolon.com.quagga.controllers;

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
@CrossOrigin("*")
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

//    @GetMapping("/findUser/{id}")
//    public ResponseEntity<?> findUserById(@PathVariable("id"){
//        try{
//
//        }
//    }


}
