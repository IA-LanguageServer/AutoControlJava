package autocontroldriver.bind.screen;

import autocontroldriver.bind.AutoControlDriverManager;

public class Screen {

    private final AutoControlDriverManager autoControlDriverManager;

    public Screen(AutoControlDriverManager autoControlDriverManager) {
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void screenSize() {
        this.autoControlDriverManager.sendCommand("[[\"size\"]]");
    }

    public void screenshot() {
        this.autoControlDriverManager.sendCommand(("[[\"screenshot\"]]"));
    }

    public void screenshot(String filePath) {
        filePath = filePath.replace("\\", "/");
        this.autoControlDriverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\"}]]", filePath)
        );
    }

    public void screenshot(int left_x, int left_y, int right_x, int right_y) {
        this.autoControlDriverManager.sendCommand("" +
                String.format("[[\"screenshot\", {\"region\": [%d, %d, %d, %d]}]]", left_x, left_y, right_x, right_y)
        );
    }

    public void screenshot(String filePath, int left_x, int left_y, int right_x, int right_y) {
        filePath = filePath.replace("\\", "/");
        this.autoControlDriverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\", \"region\": [%d, %d, %d, %d]}]]",
                        filePath, left_x, left_y, right_x, right_y)
        );
    }

}
