package a1.test.task.task1;

public class Task1Runner {
    public static void main(String[] args) {
        System.out.println(IPv4Converter.parseIntIPv4ToInt(2149583360L));
        System.out.println(IPv4Converter.parseStringIPv4ToInt("0.0.0.255"));
    }
}