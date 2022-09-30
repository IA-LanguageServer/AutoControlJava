package integration_test.mouse;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestMouseFunctionWindows {

    public static AutoControlDriverManager autoControlDriverManager;

    @BeforeClass
    public static void setDriver() {
        autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
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
    public void positionTest() {
        autoControlDriverManager.mouse.position();
    }

    @Test
    public void setPositionTest() {
        for (int i = 0; i < 11; i++) {
            autoControlDriverManager.mouse.setPosition(100, 100);
            autoControlDriverManager.mouse.setPosition(500, 500);
        }
    }

    @Test
    public void useMouseTest() {
        autoControlDriverManager.mouse.pressMouse("mouse_left");
        autoControlDriverManager.mouse.releaseMouse("mouse_left");
        autoControlDriverManager.mouse.pressMouse("mouse_left", 100, 100);
        autoControlDriverManager.mouse.releaseMouse("mouse_left", 100, 100);
        autoControlDriverManager.mouse.clickMouse("mouse_left");
        autoControlDriverManager.mouse.clickMouse("mouse_left", 100, 100);
        autoControlDriverManager.mouse.scroll(-100);
        autoControlDriverManager.mouse.scroll(-100, 100, 100);
        autoControlDriverManager.mouse.scroll(100, 100, 100, "scroll_down");
    }

    @AfterClass
    public static void afterTest() {
        autoControlDriverManager.quit();
    }

}
