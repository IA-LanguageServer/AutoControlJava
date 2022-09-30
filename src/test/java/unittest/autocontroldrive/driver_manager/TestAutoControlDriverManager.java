package unittest.autocontroldrive.driver_manager;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestAutoControlDriverManager {

    @Test
    public void testDriverManager() {
        AutoControlDriverManager autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    Path.of("").toAbsolutePath() + "generate_autocontrol_driver.exe",
                    "windows"
            );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert autoControlDriverManager != null;
            autoControlDriverManager.quit();
        }
    }
}
