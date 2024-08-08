package africa.semicolon.com.quagga.security.config.utils;

import java.util.List;

public class SecurityUtils {
    private SecurityUtils () {}
    public static final List<String> PUBLIC_ENDPOINTS = List.of("/api/v1/");

    public static final String JWT_PREFIX = "BEARER ";
    
}
