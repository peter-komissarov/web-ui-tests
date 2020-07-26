package helpers;

import lombok.extern.java.Log;

import java.io.IOException;

@Log
public final class ProcessHelper {

    public final void killByName(String processName) {
        String script = System.getProperty("os.name").toLowerCase().contains("win")
                ? "taskkill /t /f /im " + processName + "*"
                : "pkill -9 -x " + processName;
        try {
            Runtime.getRuntime().exec(script).waitFor();
        } catch (IOException | InterruptedException e) {
            log.warning(e.getMessage());
        }
    }
}
