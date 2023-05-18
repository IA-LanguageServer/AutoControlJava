package test.integration_test.util;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestReportFunctionWindows {

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
            Assert.assertNotNull(driverManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetRecordEnable() {
        Assert.assertNotNull(driverManager);
        driverManager.report.setRecordEnable(true);
    }

    @Test
    public void useMouseTest() {
        Assert.assertNotNull(driverManager);
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
        Assert.assertNotNull(driverManager);
        driverManager.report.generateHtmlReport();
    }

    @AfterClass
    public static void afterTest() {
        Assert.assertNotNull(driverManager);
        driverManager.quit();
    }

}

