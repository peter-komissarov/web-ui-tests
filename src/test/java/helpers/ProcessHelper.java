package helpers;

import lombok.extern.java.Log;

import java.io.IOException;

@Log
public final class ProcessHelper {

    public static void killByName(String procName) {
        String script = System.getProperty("os.name").toLowerCase().contains("win")
                ? "taskkill /t /f /im " + procName + "*"
                : "pkill -9 -x " + procName;
        try {
            Runtime.getRuntime().exec(script).waitFor();
        } catch (IOException | InterruptedException e) {
            log.warning(e.getMessage());
        }
    }
}
