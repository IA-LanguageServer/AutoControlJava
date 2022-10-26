package autocontroldriver.bind.screen;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Screen {

    private final DriverManager driverManager;

    public Screen(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void screenSize() {
        this.driverManager.sendCommand("[[\"size\"]]");
    }

    public void screenshot() {
        this.driverManager.sendCommand(("[[\"screenshot\"]]"));
    }

    public void screenshot(String filePath) {
        filePath = filePath.replace("\\", "/");
        this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\"}]]", filePath)
        );
    }

    public void screenshot(int left_x, int left_y, int right_x, int right_y) {
        this.driverManager.sendCommand("" +
                String.format("[[\"screenshot\", {\"region\": [%d, %d, %d, %d]}]]", left_x, left_y, right_x, right_y)
        );
    }

    public void screenshot(String filePath, int left_x, int left_y, int right_x, int right_y) {
        filePath = filePath.replace("\\", "/");
        this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\", \"region\": [%d, %d, %d, %d]}]]",
                        filePath, left_x, left_y, right_x, right_y)
        );
    }

}
