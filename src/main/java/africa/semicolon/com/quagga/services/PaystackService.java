package africa.semicolon.com.quagga.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaystackService {

    private final RestTemplate restTemplate;

    @Value("${paystack.secret.key}")
    private String secretKey;

    public PaystackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String initializeTransaction(String email, int amount) {
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(secretKey);

        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("amount", amount); // amount in kobo (Naira x 100)

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();  // Contains payment details like authorization URL
    }

    public String verifyTransaction(String reference) {
        String url = "https://api.paystack.co/transaction/verify/" + reference;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(secretKey);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();  // Transaction verification details
    }
}

