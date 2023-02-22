package autocontroldriver.bind.screen;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Screen {

    private DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Screen(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     * get screen size
     * @return  server response string
     */
    public String screenSize() {
        return this.driverManager.sendCommand("[[\"size\"]]");
    }

    /**
     * make a screenshot
     * @return  server response string
     */
    public String screenshot() {
        return this.driverManager.sendCommand(("[[\"screenshot\"]]"));
    }
    /**
     * @param filePath: save screenshot path
     * @return  server response string
     * */
    public String screenshot(String filePath) {
        filePath = filePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\"}]]", filePath)
        );
    }
    /**
     * @param left_x: screenshot zone left x
     * @param left_y: screenshot zone left y
     * @param right_x: screenshot zone right x
     * @param right_y: screenshot zone right y
     * @return  server response string
     * */
    public String screenshot(int left_x, int left_y, int right_x, int right_y) {
        return this.driverManager.sendCommand("" +
                String.format("[[\"screenshot\", {\"region\": [%d, %d, %d, %d]}]]", left_x, left_y, right_x, right_y)
        );
    }
    /**
     * @param filePath: save screenshot path
     * @param left_x: screenshot zone left x
     * @param left_y: screenshot zone left y
     * @param right_x: screenshot zone right x
     * @param right_y: screenshot zone right y
     * @return  server response string
     * */
    public String screenshot(String filePath, int left_x, int left_y, int right_x, int right_y) {
        filePath = filePath.replace("\\", "/");
        return this.driverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": \"%s\", \"region\": [%d, %d, %d, %d]}]]",
                        filePath, left_x, left_y, right_x, right_y)
        );
    }

}
