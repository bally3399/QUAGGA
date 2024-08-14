package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Token;

public interface TokenService {

    String  createToken(String email);

    Token findByUserEmail(String email);

    void deleteToken(Long id);

}
