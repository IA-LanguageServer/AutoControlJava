package autocontroldriver.bind.image;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Image {

    private DriverManager driverManager;

    public Image(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void locateAllImage(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.driverManager.sendCommand(
                String.format(  
                        "[[\"locate_all_image\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    public void locateImageCenter(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_image_center\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    public void locateAndClick(String imagePath, String mouseKeycode,double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.driverManager.sendCommand(
                String.format(
                        "[[\"locate_and_click\", {\"image\": \"%s\"," +
                                "\"mouse_keycode\": \"%s\"" +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, mouseKeycode,detectThreshold, drawImage)
        );
    }

}
