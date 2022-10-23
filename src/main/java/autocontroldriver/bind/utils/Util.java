package autocontroldriver.bind.utils;

import autocontroldriver.bind.AutoControlDriverManager;

public class Util {

    private final AutoControlDriverManager autoControlDriverManager;

    public Util(AutoControlDriverManager autoControlDriverManager) {
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void setRecordEnable(boolean setEnable) {
        autoControlDriverManager.sendCommand(
                String.format("[[\"set_record_enable\", {\"set_enable\": %b}]]", setEnable)
        );
    }

    public void generateHtml() {
        autoControlDriverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }

    public void generateHtml(String htmlName) {
        autoControlDriverManager.sendCommand(
                String.format("[[\"generate_html\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

}
