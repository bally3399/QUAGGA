package africa.semicolon.com.quagga.controllers;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Specialist;
import africa.semicolon.com.quagga.dtos.Response.ApiResponse;
import africa.semicolon.com.quagga.dtos.request.LoginRequest;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.services.SpecialistService;
import africa.semicolon.com.quagga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quagga/specialist")
public class SpecialistController {

    @Autowired
    private UserService userService;
    @Autowired
    private SpecialistService specialistService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.register(registerRequest)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
     try {
            return new ResponseEntity<>(new ApiResponse(true, userService.login(loginRequest)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getSpecialist(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.findSpecialistById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllSpecialists() {
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.getAllSpecialists()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpecialist(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.deleteSpecialistById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<?> getSpecialistsByCategory(@PathVariable("category") Category category) {
        try{
            List<Specialist> specialists = specialistService.findSpecialistsByCategory(category);
            if (specialists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No specialists found
            }
            return new ResponseEntity<>(new ApiResponse(true, specialists), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
