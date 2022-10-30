package autocontroldriver.bind.mouse;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Mouse {

    private final DriverManager driverManager;

    public Mouse(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void specialTable() {
        this.driverManager.sendCommand(("[[\"special_table\"]]"));
    }

    public void position(){
        this.driverManager.sendCommand("[[\"position\"]]");
    }

    public void setPosition(int x, int y){
        this.driverManager.sendCommand(
                String.format("[[\"set_position\", {\"x\": %d, \"y\": %d}]]", x, y)
        );
    }

    public void pressMouse(String mouse_keycode){
        this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }

    public void pressMouse(String mouse_keycode, int x, int y){
        this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }


    public void releaseMouse(String mouse_keycode){
        this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }

    public void releaseMouse(String mouse_keycode, int x, int y){
        this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }


    public void clickMouse(String mouse_keycode){
        this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }

    public void clickMouse(String mouse_keycode, int x, int y){
        this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }

    public void scroll(int scroll_value){
        this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d}]]", scroll_value)
        );
    }

    public void scroll(int scroll_value, int x, int y){
        this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d}]]",
                        scroll_value, x, y)
        );
    }

    public void scroll(int scroll_value, int x, int y, String scroll_direction){
        this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d, \"scroll_direction\": \"%s\"}]]",
                        scroll_value, x, y, scroll_direction)
        );
    }


}
