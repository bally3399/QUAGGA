package africa.semicolon.com.quagga.controllers;

import africa.semicolon.com.quagga.dtos.Response.ApiResponse;
import africa.semicolon.com.quagga.dtos.request.CreateNotificationRequest;
import africa.semicolon.com.quagga.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quagga/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public ResponseEntity<?>notification(@RequestBody CreateNotificationRequest notificationRequest){
        try{
            return new ResponseEntity<>(new ApiResponse(true, notificationService.create(notificationRequest)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findNotification/{Id}")
    public ResponseEntity<?> findNotification(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(new ApiResponse(true, notificationService.findById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
        }

