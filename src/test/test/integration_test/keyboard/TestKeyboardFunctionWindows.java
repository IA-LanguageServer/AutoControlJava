package test.integration_test.keyboard;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestKeyboardFunctionWindows {

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

    @AfterClass
    public static void afterTest() {
        Assert.assertNotNull(driverManager);
        driverManager.quit();
    }

    @Test
    public void testPressKey() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.pressKey("a", false, false);
    }

    @Test
    public void testReleaseKey() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.releaseKey("a", false, false);
    }

    @Test
    public void testTypeKey() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.typeKey("a", false, false);
    }

    @Test
    public void testCheckKeyIsPress() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.checkKeyIsPress("a");
    }

    @Test
    public void testWrite() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.write("abcdef", false);
    }

    @Test
    public void testHotKey() {
        Assert.assertNotNull(driverManager);
        List<String> list = new ArrayList<>();
        list.add("lcontrol");
        list.add("a");
        list.add("lcontrol");
        list.add("c");
        list.add("lcontrol");
        list.add("v");
        driverManager.keyboard.hotkey(list, false);
    }

    @Test
    public void testKeysTable() {
        Assert.assertNotNull(driverManager);
        driverManager.keyboard.keysTable();
    }

}
