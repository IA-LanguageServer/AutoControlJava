package integration_test.image;

import autocontroldriver.bind.AutoControlDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class TestImageFunctionWindows {

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
   public void testLocateAllImage(){
        autoControlDriverManager.image.locateAllImage(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );
   }

    @Test
    public void testLocateImageCenter(){
        autoControlDriverManager.image.locateImageCenter(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                0.9,
                false
        );

    }

    @Test
    public void testLocateAndClick(){
        autoControlDriverManager.image.locateAndClick(
                Path.of("").toAbsolutePath() + "/test_resource/test_image.png",
                "mouse_left",
                0.9,
                false
        );

    }


    @AfterClass
    public static void afterTest() {
        autoControlDriverManager.quit();
    }

}
