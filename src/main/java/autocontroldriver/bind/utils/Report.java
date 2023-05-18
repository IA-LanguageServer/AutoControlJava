package autocontroldriver.bind.utils;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Report {

    private final DriverManager driverManager;

    /**
     * class init with driver manager
     *
     * @param driverManager driver manager that manage driver:
     */
    public Report(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     * @param setEnable: enable record or not
     * @return server response string
     */
    public String setRecordEnable(boolean setEnable) {
        return driverManager.sendCommand(
                String.format("[[\"set_record_enable\", {\"set_enable\": %b}]]", setEnable)
        );
    }

    /**
     * generate html report
     *
     * @return server response string
     */
    public String generateHtml() {
        return driverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }

    public String generateJson() {
        return driverManager.sendCommand(
                "[[\"generate_json\"]]"
        );
    }

    public String generateXML() {
        return driverManager.sendCommand(
                "[[\"generate_xml\"]]"
        );
    }

    /**
     * generate html report
     *
     * @return server response string
     */
    public String generateHtmlReport() {
        return driverManager.sendCommand("[[\"generate_html_report\"]]");
    }

    public String generateHtmlReport(String htmlName) {
        return driverManager.sendCommand(
                String.format("[[\"generate_html_report\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

    public String generateJsonReport(String jsonFileName) {
        return driverManager.sendCommand(
                String.format("[[\"generate_json_report\", {\"json_file_name\": \"%s\"}]]", jsonFileName)
        );
    }

    public String generateXMLReport(String xmlFileName) {
        return driverManager.sendCommand(
                String.format("[[\"generate_xml_report\", {\"xml_file_name\": \"%s\"}]]", xmlFileName)
        );
    }

}
