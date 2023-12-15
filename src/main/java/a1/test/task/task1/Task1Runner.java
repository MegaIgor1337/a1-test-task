package a1.test.task.task1;

public class Main {
    public static void main(String[] args)  {
        System.out.println(IpV4Converter.parseIntIPv4ToInt(255));
        System.out.println(IpV4Converter.parseStringIPv4ToInt("0.0.0.255"));
    }
}