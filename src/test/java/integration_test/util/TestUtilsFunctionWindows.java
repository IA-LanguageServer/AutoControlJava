package integration_test.util;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestUtilsFunctionWindows {

    public static DriverManager driverManager;

    @BeforeClass
    public static void setDriver() {
        driverManager = null;
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9938,
                    Path.of("").toAbsolutePath() + "/generate_autocontrol_driver.exe",
                    "windows"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetRecordEnable() {
        driverManager.utils.setRecordEnable(true);
    }

    @Test
    public void useMouseTest() {
        driverManager.mouse.pressMouse("mouse_left");
        driverManager.mouse.releaseMouse("mouse_left");
        driverManager.mouse.pressMouse("mouse_left", 100, 100);
        driverManager.mouse.releaseMouse("mouse_left", 100, 100);
        driverManager.mouse.clickMouse("mouse_left");
        driverManager.mouse.clickMouse("mouse_left", 100, 100);
        driverManager.mouse.scroll(-100);
        driverManager.mouse.scroll(-100, 100, 100);
        driverManager.mouse.scroll(100, 100, 100, "scroll_down");
    }

    @Test
    public void testGenerateHtml() {
        driverManager.utils.generateHtml();
    }

    @AfterClass
    public static void afterTest() {
        driverManager.quit();
    }

}

