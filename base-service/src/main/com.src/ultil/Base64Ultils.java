package ultil;

import java.util.Base64;

public class Base64Ultils {
    public static String encodeStringToBase64(String text) {
        byte[] encodedBytes = Base64.getEncoder().encode((text).getBytes());
        return new String(encodedBytes);
    }

    public static String decodeBase64ToString(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());
        return new String(decodedBytes);
    }
}
