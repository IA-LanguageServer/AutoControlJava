package autocontroldriver.bind.screen;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Screen {

    private DriverManager driverManager;

    public Screen(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String screenSize() {
        return this.driverManager.sendCommand("[[\"size\"]]");
    }

    public String screenshot() {
        return this.driverManager.sendCommand(("[[\"screenshot\"]]"));
    }

    public String screenshot(String filePath) {
        filePath = filePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\"}]]", filePath)
        );
    }

    public String screenshot(int left_x, int left_y, int right_x, int right_y) {
        return this.driverManager.sendCommand("" +
                String.format("[[\"screenshot\", {\"region\": [%d, %d, %d, %d]}]]", left_x, left_y, right_x, right_y)
        );
    }

    public String screenshot(String filePath, int left_x, int left_y, int right_x, int right_y) {
        filePath = filePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\", \"region\": [%d, %d, %d, %d]}]]",
                        filePath, left_x, left_y, right_x, right_y)
        );
    }

}
