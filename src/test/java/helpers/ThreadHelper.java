package helpers;

public final class ThreadHelper {
    public static String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
