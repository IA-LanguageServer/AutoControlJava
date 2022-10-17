package unittest.autocontroldrive.driver_manager;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestAutoControlDriverManager {

    @Test
    public void testDriverManagerDriverPath() {
        AutoControlDriverManager autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    Path.of("").toAbsolutePath() + "/generate_autocontrol_driver.exe",
                    "windows"
            );
            autoControlDriverManager.quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDriverManagerProcessCommand() {
        AutoControlDriverManager autoControlDriverManager = null;
        List<String> commandList = new ArrayList<>();
        commandList.add(Path.of("").toAbsolutePath() + "/generate_autocontrol_driver.exe");
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    commandList,
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
