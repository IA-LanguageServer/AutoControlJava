package autocontroldriver.bind.keyboard;

import autocontroldriver.utils.driver_manager.DriverManager;

import java.util.List;

public class Keyboard {

    private DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Keyboard(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     *
     * @return return all keycode can be used; server response string
     */
    public String keysTable() {
        return this.driverManager.sendCommand(("[[\"keys_table\"]]"));
    }
    /**
     *
     * @param keycode: which keycode we want to press
     * @param isShift: auto press shift when use this method
     * @param skipRecord: make this press event skip recode true or false
     * @return  server response string
     * */
    public String pressKey(String keycode, boolean isShift, boolean skipRecord) {
        return this.driverManager.sendCommand(
                String.format("[[\"press_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }
    /**
     *
     * @param keycode: which keycode we want to press
     * @param isShift: auto press shift when use this method
     * @param skipRecord: make this press event skip recode true or false
     * @return  server response string
     * */
    public String releaseKey(String keycode, boolean isShift, boolean skipRecord) {
        return this.driverManager.sendCommand(
                String.format("[[\"release_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }
    /**
     *
     * @param keycode: which keycode we want to press
     * @param isShift: auto press shift when use this method
     * @param skipRecord: make this press event skip recode true or false
     * @return  server response string
     * */
    public String typeKey(String keycode, boolean isShift, boolean skipRecord) {
        return this.driverManager.sendCommand(
                String.format("[[\"type_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }
    /**
     *
     * @param keycode: check this keycode key is pressed or not
     * @return  server response string
     * */
    public String checkKeyIsPress(String keycode) {
        return this.driverManager.sendCommand(
                String.format("[[\"check_key_is_press\", {\"keycode\": \"%s\"}]]", keycode)
        );
    }
    /**
     *
     * @param writeString: all string we want to type
     * @param isShift: auto press shift when use this method
     * @return  server response string
     * */
    public String write(String writeString, boolean isShift) {
        return this.driverManager.sendCommand(
                String.format("[[\"write\", " +
                                "{" +
                                "\"write_string\": \"%s\", " +
                                "\"is_shift\": %b " +
                                "}]]",
                        writeString, isShift)
        );
    }
    /**
     *
     * @param keyCodeList: all keycode will press and
     * @param isShift: auto press shift when use this method
     * @return  server response string
     * */
    public String hotkey(List<String> keyCodeList, boolean isShift) {
        StringBuilder hotKeyCommandBuildBuffer = new StringBuilder();
        hotKeyCommandBuildBuffer.append("[[\"hotkey\", ").append("{").append("\"key_code_list\": ");
        hotKeyCommandBuildBuffer.append("[");
        for (int index = 0; index < keyCodeList.size(); index++) {
            if(index < keyCodeList.size() - 1)
                hotKeyCommandBuildBuffer.append("\"").append(keyCodeList.get(index)).append("\"").append(", ");
            else
                hotKeyCommandBuildBuffer.append("\"").append(keyCodeList.get(index)).append("\"");
        }
        hotKeyCommandBuildBuffer.append("]");
        hotKeyCommandBuildBuffer.append(String.format(", \"is_shift\": %b}]]", isShift));
        return this.driverManager.sendCommand(hotKeyCommandBuildBuffer.toString());
    }

}

