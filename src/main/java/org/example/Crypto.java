package org.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class Crypto {
    private static final String HMAC_ALGO = "HmacSHA256";
    private byte[] key;

    public Crypto() {
        generateKey();
    }

    private void generateKey() {
        SecureRandom secureRandom = new SecureRandom();
        key = new byte[32]; // 256 bits
        secureRandom.nextBytes(key);
    }

    public String getKey() {
        return bytesToHex(key);
    }

    public String calculateHMAC(String message) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGO);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, HMAC_ALGO);
            mac.init(secretKeySpec);
            byte[] hmacBytes = mac.doFinal(message.getBytes());
            return bytesToHex(hmacBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

