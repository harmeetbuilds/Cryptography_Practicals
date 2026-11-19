
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESExample {

    public static void main(String[] args) throws Exception {

        // Original message
        String message = "Hello, this is a secure message";

        // Generate AES secret key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Generate random IV
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Create AES Cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));

        String encryptedText = Base64.getEncoder()
                .encodeToString(encrypted);

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decrypted = cipher.doFinal(encrypted);

        String decryptedText = new String(decrypted, "UTF-8");

        // Display results
        System.out.println("AES Encryption");
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedText);
        System.out.println("Decrypted Message: " + decryptedText);
    }
}

