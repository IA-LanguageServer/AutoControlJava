package autocontroldrive.driver_manager;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.Test;

import java.io.IOException;

public class TestAutoControlDriverManager {

    @Test
    public void testDriverManager() {
        AutoControlDriverManager autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver_win64.exe",
                    "windows"
            );
            autoControlDriverManager.sendCommand("[[\"size\"]]");
            autoControlDriverManager.sendCommand("quit_server");
            autoControlDriverManager.quit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (autoControlDriverManager != null)
                autoControlDriverManager.quit();
        }
    }

}
