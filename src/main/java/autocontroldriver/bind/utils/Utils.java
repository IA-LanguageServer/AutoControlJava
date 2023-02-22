package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Utils {

    private final DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Utils(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    /**
     * @param setEnable: enable record or not
     * @return server response string
     * */
    public String setRecordEnable(boolean setEnable) {
        return driverManager.sendCommand(
                String.format("[[\"set_record_enable\", {\"set_enable\": %b}]]", setEnable)
        );
    }
    /**
     * generate html report
     * @return server response string
     * */
    public String generateHtml() {
        return driverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }
    /**
     * generate html report
     * @param htmlName: save html use htmlName
     * @return server response string
     * */
    public String generateHtml(String htmlName) {
        return driverManager.sendCommand(
                String.format("[[\"generate_html\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

}
