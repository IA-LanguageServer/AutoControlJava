package integration_test.keyboard;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestKeyboardFunctionWindows {

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
    public void testPressKey(){
        autoControlDriverManager.keyboard.pressKey("a", false, false);
    }

    @Test
    public void testReleaseKey(){
        autoControlDriverManager.keyboard.releaseKey("a", false, false);
    }

    @Test
    public void testTypeKey(){
        autoControlDriverManager.keyboard.typeKey("a", false, false);
    }

    @Test
    public void testCheckKeyIsPress(){
        autoControlDriverManager.keyboard.checkKeyIsPress("a");
    }

    @Test
    public void testWrite(){
        autoControlDriverManager.keyboard.write("abcdef", false);
    }

    @Test
    public void testHotKey(){
        List<String> list = new ArrayList<>();
        list.add("lcontrol");
        list.add("a");
        list.add("lcontrol");
        list.add("c");
        list.add("lcontrol");
        list.add("v");
        autoControlDriverManager.keyboard.hotkey(list, false);
    }

    @Test
    public void testKeysTable(){
        autoControlDriverManager.keyboard.keysTable();
    }

    @AfterClass
    public static void afterTest() {
        autoControlDriverManager.quit();
    }

}
