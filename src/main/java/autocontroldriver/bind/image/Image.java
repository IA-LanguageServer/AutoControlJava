package autocontroldriver.bind.image;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Image {

    private final DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Image(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     * this method is used to locate all image detected on screen
     * @param imagePath what image we want to locate string full path;
     * @param detectThreshold how strict of detect;
     * @param drawImage draw detect image area;
     * @return  server response string
     * */
    public String locateAllImage(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(  
                        "[[\"locate_all_image\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    /**
     * this method is used to find image and locate on image's center
     * @param imagePath what image we want to locate string full path;
     * @param detectThreshold how strict of detect;
     * @param drawImage draw detect image area;
     * @return  server response string
     * */
    public String locateImageCenter(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_image_center\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    /**
     * this method is used to locate image and click on it center
     * @param imagePath what image we want to locate string full path;
     * @param detectThreshold how strict of detect;
     * @param mouseKeycode click mouse keycode on detected image center
     * @param drawImage draw detect image area;
     * @return  server response string
     * */
    public String locateAndClick(String imagePath, String mouseKeycode,double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_and_click\", {\"image\": \"%s\"," +
                                "\"mouse_keycode\": \"%s\"" +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, mouseKeycode,detectThreshold, drawImage)
        );
    }

}
