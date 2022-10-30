package integration_test.screen;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestScreenFunctionWindows {

    public static DriverManager driverManager;

    @BeforeClass
    public static void setDriver() {
        driverManager = null;
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9938,
                    Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_win.exe",
                    "windows"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterTest() {
       driverManager.quit();
    }

    @Test
    public void testSize() {
        driverManager.screen.screenSize();
    }

    @Test
    public void testScreenshot() {
        driverManager.screen.screenshot();
        driverManager.screen.screenshot(Path.of("").toAbsolutePath() + "/test.png");
        driverManager.screen.screenshot(100, 100, 500, 500);
        driverManager.screen.screenshot(
                Path.of("").toAbsolutePath() + "/test1.png",
                100, 100, 500, 500);
    }


}

