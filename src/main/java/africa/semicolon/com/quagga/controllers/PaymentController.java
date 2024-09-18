package africa.semicolon.com.quagga.controllers;

import africa.semicolon.com.quagga.services.PaystackService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaystackService paystackService;

    @Autowired
    public PaymentController(PaystackService paystackService) {
        this.paystackService = paystackService;
    }

    @PostMapping("/initialize")
    public String initializePayment(@RequestParam String email, @RequestParam int amount) {
        return paystackService.initializeTransaction(email, amount);
    }

    @GetMapping("/verify/{reference}")
    public String verifyPayment(@PathVariable String reference) {
        return paystackService.verifyTransaction(reference);
    }
}

