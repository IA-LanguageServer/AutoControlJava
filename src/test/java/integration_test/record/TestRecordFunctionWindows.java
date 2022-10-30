package integration_test.record;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestRecordFunctionWindows {

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

    @Test
    public void testRecord(){
        driverManager.record.record();
        driverManager.record.stopRecord();
    }

    @AfterClass
    public static void afterTest() {
        driverManager.quit();
    }

}
