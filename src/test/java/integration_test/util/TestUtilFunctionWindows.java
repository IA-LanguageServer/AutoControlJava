package integration_test.util;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestUtilFunctionWindows {

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
    public void testSetRecordEnable() {
        autoControlDriverManager.util.setRecordEnable(true);
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

    @Test
    public void testGenerateHtml() {
        autoControlDriverManager.util.generateHtml();
    }

    @AfterClass
    public static void afterTest() {
        autoControlDriverManager.quit();
    }

}

