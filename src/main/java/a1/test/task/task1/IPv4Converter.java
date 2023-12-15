package a1.test.task.task1;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IpConverter {
    public static int parseIpAddressToInt(String ipAddress) {

    }

    public static String parserIpAddressToString(int ipAddress) {
        StringBuilder sa = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sa.append(0xff & ipAddress >> 24);
            ipAddress <<= 8;
            if (i != 4 - 1)
                sa.append('.');
        }
        return sa.toString();
    }
}
