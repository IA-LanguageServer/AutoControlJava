package autocontroldriver.bind.keyboard;

import autocontroldriver.utils.driver_manager.DriverManager;

import java.util.List;

public class Keyboard {

    private DriverManager driverManager;

    public Keyboard(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void keysTable() {
        this.driverManager.sendCommand(("[[\"keys_table\"]]"));
    }

    public void pressKey(String keycode, boolean isShift, boolean skipRecord) {
        this.driverManager.sendCommand(
                String.format("[[\"press_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }

    public void releaseKey(String keycode, boolean isShift, boolean skipRecord) {
        this.driverManager.sendCommand(
                String.format("[[\"release_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }

    public void typeKey(String keycode, boolean isShift, boolean skipRecord) {
        this.driverManager.sendCommand(
                String.format("[[\"type_key\", " +
                                "{" +
                                "\"keycode\": \"%s\"," +
                                "\"is_shift\": %b, " +
                                "\"skip_record\": %b " +
                                "}]]",
                        keycode, isShift, skipRecord)
        );
    }

    public void checkKeyIsPress(String keycode) {
        this.driverManager.sendCommand(
                String.format("[[\"check_key_is_press\", {\"keycode\": \"%s\"}]]", keycode)
        );
    }

    public void write(String writeString, boolean isShift) {
        this.driverManager.sendCommand(
                String.format("[[\"write\", " +
                                "{" +
                                "\"write_string\": \"%s\", " +
                                "\"is_shift\": %b " +
                                "}]]",
                        writeString, isShift)
        );
    }

    public void hotkey(List<String> keyCodeList, boolean isShift) {
        StringBuffer hotKeyCommandBuildBuffer = new StringBuffer();
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
        System.out.println(hotKeyCommandBuildBuffer);
        this.driverManager.sendCommand(hotKeyCommandBuildBuffer.toString());
    }

}

