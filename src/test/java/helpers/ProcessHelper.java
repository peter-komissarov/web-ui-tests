package helpers;

import lombok.extern.java.Log;

import java.io.IOException;

@Log
public final class ProcessHelper {
    public static void killByName(String procName) {
        String os = System.getProperty("os.name").toLowerCase();
        String script;

        if (os.contains("win")) {
            script = "taskkill /t /f /im " + procName + "*";
        } else {
            script = "pkill -9 -x " + procName;
        }

        try {
            Runtime.getRuntime().exec(script).waitFor();
        } catch (IOException | InterruptedException e) {
            log.warning(e.getMessage());
        }
    }
}
