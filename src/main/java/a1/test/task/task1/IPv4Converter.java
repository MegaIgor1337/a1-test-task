package a1.test.task.task1;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IPv4Converter {
    public static long parseStringIPv4ToInt(String addr) {
        String[] addrArray = addr.split("\\.");

        if (addrArray.length != 4) {
            throw new IllegalArgumentException("Incorrectly IPv4 address: " + addr);
        }

        long num = 0;
        for (String part : addrArray) {
            int octet = Integer.parseInt(part);

            if (octet < 0 || octet > 255) {
                throw new IllegalArgumentException("Incorrectly IPv4 address: " + addr);
            }

            if (part.length() > 1 && part.startsWith("0")) {
                throw new IllegalArgumentException("Incorrectly IPv4 address: " + addr);
            }

            num = (num << 8) + octet;
        }
        return num;
    }

    public static String parseIntIPv4ToInt(long i) {
        return ((i >> 24) & 0xFF) + "." +
               ((i >> 16) & 0xFF) + "." +
               ((i >> 8) & 0xFF) + "." +
               (i & 0xFF);
    }
}
