package autocontroldriver.bind.image;

import autocontroldriver.bind.AutoControlDriverManager;

public class Image {

    private final AutoControlDriverManager autoControlDriverManager;

    public Image(AutoControlDriverManager autoControlDriverManager) {
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void locateAllImage(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.autoControlDriverManager.sendCommand(
                String.format(  
                        "[[\"locate_all_image\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    public void locateImageCenter(String imagePath, double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.autoControlDriverManager.sendCommand(
                String.format(
                        "[[\"locate_image_center\", {\"image\": \"%s\"," +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, detectThreshold, drawImage)
        );
    }

    public void locateAndClick(String imagePath, String mouseKeycode,double detectThreshold, boolean drawImage) {
        imagePath = imagePath.replace("\\", "/");
        this.autoControlDriverManager.sendCommand(
                String.format(
                        "[[\"locate_and_click\", {\"image\": \"%s\"," +
                                "\"mouse_keycode\": \"%s\"" +
                                "\"detect_threshold\": %.1f," +
                                "\"draw_image\": %b}]]",
                        imagePath, mouseKeycode,detectThreshold, drawImage)
        );
    }

}
