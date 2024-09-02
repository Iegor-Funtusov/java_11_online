package ua.com.alevel;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@AllArgsConstructor
public class FinalProjectApplication {

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
    private void run() {
        String password1 = "Test123";

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash1 = digest.digest(
                    password1.getBytes(StandardCharsets.UTF_8));
            String hash1 = bytesToHex(encodedhash1);
            String bCrypt1 = passwordEncoder.encode(password1);
            System.out.println("encoded hash1: " + hash1);
            System.out.println("encoded bCrypt1: " + bCrypt1);
            byte[] encodedhash2 = digest.digest(
                    password1.getBytes(StandardCharsets.UTF_8));
            String hash2 = bytesToHex(encodedhash2);
            String bCrypt2 = passwordEncoder.encode(password1);
            System.out.println("encoded hash2: " + hash2);
            System.out.println("encoded bCrypt2: " + bCrypt2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
