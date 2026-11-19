
import java.math.BigInteger;

public class DiffieHellman {
    public static void main(String[] args) {

        // Step 1: Public values
        BigInteger p = BigInteger.valueOf(23);
        BigInteger g = BigInteger.valueOf(5);

        // Step 2: Private keys
        BigInteger alicePrivate = BigInteger.valueOf(6);
        BigInteger bobPrivate = BigInteger.valueOf(15);

        // Step 3: Calculate public keys
        BigInteger alicePublic =
                g.modPow(alicePrivate, p);

        BigInteger bobPublic =
                g.modPow(bobPrivate, p);

        // Step 4: Calculate shared secret keys
        BigInteger aliceSecret =
                bobPublic.modPow(alicePrivate, p);

        BigInteger bobSecret =
                alicePublic.modPow(bobPrivate, p);

        // Step 5: Display results
        System.out.println("Diffie-Hellman Key Exchange");

        System.out.println("Public Prime: " + p);
        System.out.println("Generator: " + g);

        System.out.println("Alice Public Key: " + alicePublic);
        System.out.println("Bob Public Key: " + bobPublic);

        System.out.println("Alice Shared Secret: " + aliceSecret);
        System.out.println("Bob Shared Secret: " + bobSecret);

        if (aliceSecret.equals(bobSecret)) {
            System.out.println("Secure Key Exchange Successful!");
        } else {
            System.out.println("Key Exchange Failed!");
        }
    }
}
