package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

    public static String getRandomString() {
        return getRandomString(10);
    }

    public static String getRandomString(int symbolCount) {
        return RandomStringUtils.randomAlphabetic(symbolCount);
    }

    public static int getRandomNumber() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(2));
    }
}
