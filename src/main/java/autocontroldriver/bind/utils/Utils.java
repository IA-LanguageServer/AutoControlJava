package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Utils {

    private final DriverManager driverManager;

    public Utils(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String setRecordEnable(boolean setEnable) {
        return driverManager.sendCommand(
                String.format("[[\"set_record_enable\", {\"set_enable\": %b}]]", setEnable)
        );
    }

    public String generateHtml() {
        return driverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }

    public String generateHtml(String htmlName) {
        return driverManager.sendCommand(
                String.format("[[\"generate_html\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

}
