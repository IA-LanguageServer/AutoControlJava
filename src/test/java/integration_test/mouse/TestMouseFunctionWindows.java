package integration_test.mouse;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestMouseFunctionWindows {

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
    public void positionTest() {
        driverManager.mouse.position();
    }

    @Test
    public void setPositionTest() {
        for (int i = 0; i < 11; i++) {
            driverManager.mouse.setPosition(100, 100);
            driverManager.mouse.setPosition(500, 500);
        }
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
    public void testSpecialTable() {
        driverManager.mouse.specialTable();
    }


}
