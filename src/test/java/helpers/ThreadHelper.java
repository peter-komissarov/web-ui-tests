package helpers;

public final class ThreadHelper {

    public final String getThreadId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
