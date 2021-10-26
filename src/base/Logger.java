package base;

public class Logger {
    public static void d(String fmt, Object... args) {
        System.out.printf(fmt + "\n", args);
    }
}
