package integration_test.image;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestImageFunctionWindows {

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
   public void testLocateAllImage(){
        driverManager.image.locateAllImage(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );
   }

    @Test
    public void testLocateImageCenter(){
        driverManager.image.locateImageCenter(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );

    }

    @Test
    public void testLocateAndClick(){
        driverManager.image.locateAndClick(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                "mouse_left",
                0.9,
                false
        );

    }


    @AfterClass
    public static void afterTest() {
        driverManager.quit();
    }

}
