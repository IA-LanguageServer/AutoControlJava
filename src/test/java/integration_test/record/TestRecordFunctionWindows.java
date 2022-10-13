package integration_test.record;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestRecordFunctionWindows {

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
    public void testRecord(){
        autoControlDriverManager.record.record();
        autoControlDriverManager.record.stopRecord();
    }

    @AfterClass
    public static void afterTest() {
        autoControlDriverManager.quit();
    }

}
