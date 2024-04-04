package hash_code;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    /**
     * This method generates a SHA-256 hash for a given string.
     * The hash is a 64-character long hexadecimal string.
     *
     * @param input the original string to be hashed
     * @return the SHA-256 hash as a string, or null if the hashing fails due to a NoSuchAlgorithmException
     *
     * @throws NullPointerException if the input string is null
     */

    public static String getSHA256Hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }



}