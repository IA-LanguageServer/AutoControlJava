package test.unittest.autocontroldrive.driver_manager;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestDriverManager {

    @Test
    public void testDriverManagerDriverPath() {
        DriverManager driverManager = null;
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9938,
                    Path.of("").toAbsolutePath() + "/AutoControlDriverWindows.exe",
                    "windows"
            );
            Assert.assertNotNull(driverManager);
            driverManager.quit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDriverManagerProcessCommand() {
        DriverManager driverManager = null;
        List<String> commandList = new ArrayList<>();
        commandList.add(Path.of("").toAbsolutePath() + "/AutoControlDriverWindows.exe");
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9938,
                    commandList,
                    "windows"
            );
            Assert.assertNotNull(driverManager);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert driverManager != null;
            driverManager.quit();
        }
    }
}
