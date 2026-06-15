package com.example.dummy;

import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

@RestController
@RequestMapping("/api/auth")
public class SecurityServiceController {

    private static final String ENCRYPTION_KEY = "1234567890123456";

    @GetMapping("/encrypt-token")
    public String encryptToken(@RequestParam("data") String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            return "Error encrypting token";
        }
    }

    @GetMapping("/hash-password")
    public String hashPassword(@RequestParam("password") String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes());
            
            Random rand = new Random();
            int salt = rand.nextInt();
            
            return Base64.getEncoder().encodeToString(hashInBytes) + salt;
        } catch (Exception e) {
            return "Error hashing password";
        }
    }
}
