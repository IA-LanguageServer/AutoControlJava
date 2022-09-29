package unittest.autocontroldrive.driver_manager;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.Test;

import java.io.IOException;

public class TestAutoControlDriverManager {

    @Test
    public void testDriverManager() {
        AutoControlDriverManager autoControlDriverManager = null;
        try {
            autoControlDriverManager = new AutoControlDriverManager(
                    "localhost",
                    9938,
                    "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver.exe",
                    "windows"
            );
            while (!autoControlDriverManager.isAlive()){
            }
            autoControlDriverManager.sendCommand("[[\"size\"]]");
            autoControlDriverManager.sendCommand("[[\"type_key\", {\"keycode\": 65}]]");
            autoControlDriverManager.sendCommand("[[\"type_key\", {\"keycode\": 66}]]");
            autoControlDriverManager.sendCommand("[[\"type_key\", {\"keycode\": 67}]]");
            for(int i=0; i<10; i++) {
                autoControlDriverManager.sendCommand("[[\"set_position\", {\"x\": 100, \"y\": 100}]]");
                autoControlDriverManager.sendCommand("[[\"set_position\", {\"x\": 500, \"y\": 500}]]");
            }
            autoControlDriverManager.screen.screenshot();
            autoControlDriverManager.screen.screenshot("C:/program_workspace/java/AutoControlJava/test_resource/test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert autoControlDriverManager != null;
            autoControlDriverManager.quit();
        }
    }
}
