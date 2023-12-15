package a1.test.task.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPv4ConverterTest {
    private static final String IP_STRING = "128.32.10.0";
    private static final String INVALID_IP_STRING_1 = "192.168.1";
    private static final String INVALID_IP_STRING_2 = "192.468.10.0";
    private static final String INVALID_IP_STRING_3 = "192.-468.1";
    private static final String INVALID_IP_STRING_4 = "128.032.10.0";
    private static final long IP_INT = 2149583360L;

    @Test
    public void shouldReturnIntValueWhenParseIPFromString() {
        long result = IPv4Converter.parseStringIPv4ToInt(IP_STRING);

        assertEquals(IP_INT, result);
    }

    @Test
    public void shouldReturnStringValueWhenParseIPFromInt() {
        String result = IPv4Converter.parseIntIPv4ToInt(IP_INT);

        assertEquals(IP_STRING, result);
    }

    @Test
    public void shouldThrowIllegalExceptionWhenValueOctetMoreThanItCouldBe() {
        assertThrows(IllegalArgumentException.class, () ->
                IPv4Converter.parseStringIPv4ToInt(INVALID_IP_STRING_2));
    }

    @Test
    public void shouldThrowIllegalExceptionWhenValueOctetLessThanItCouldBe() {
        assertThrows(IllegalArgumentException.class, () ->
                IPv4Converter.parseStringIPv4ToInt(INVALID_IP_STRING_3));
    }

    @Test
    public void shouldThrowIllegalExceptionWhenThereAreNotFourOctets() {
        assertThrows(IllegalArgumentException.class, () ->
                IPv4Converter.parseStringIPv4ToInt(INVALID_IP_STRING_1));
    }

    @Test
    public void shouldThrowIllegalExceptionWhenOctetStartsWith0() {
        assertThrows(IllegalArgumentException.class, () ->
                IPv4Converter.parseStringIPv4ToInt(INVALID_IP_STRING_4));
    }
}
