package test.integration_test.image;

import autocontroldriver.utils.driver_manager.DriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
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
   public void testLocateAllImage(){
       Assert.assertNotNull(driverManager);
        driverManager.image.locateAllImage(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );
   }

    @Test
    public void testLocateImageCenter(){
        Assert.assertNotNull(driverManager);
        driverManager.image.locateImageCenter(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );

    }

    @Test
    public void testLocateAndClick(){
        Assert.assertNotNull(driverManager);
        driverManager.image.locateAndClick(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                "mouse_left",
                0.9,
                false
        );

    }




}
