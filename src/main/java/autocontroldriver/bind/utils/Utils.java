package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Utils {

    private final DriverManager driverManager;

    public Utils(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void setRecordEnable(boolean setEnable) {
        driverManager.sendCommand(
                String.format("[[\"set_record_enable\", {\"set_enable\": %b}]]", setEnable)
        );
    }

    public void generateHtml() {
        driverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }

    public void generateHtml(String htmlName) {
        driverManager.sendCommand(
                String.format("[[\"generate_html\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

}
