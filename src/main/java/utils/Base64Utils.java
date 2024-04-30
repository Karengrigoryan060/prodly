package utils;

import java.util.Base64;

public class Base64Utils {

    public static <T> String encode(T object) {
        return Base64.getEncoder().encodeToString(object.toString().getBytes());
    }

    public static String decode(String data) {
        return new String(Base64.getDecoder().decode(data.replace("\n", "").trim()));
    }
}
