package autocontroldriver.bind.mouse;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Mouse {

    private final DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Mouse(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    /**
     * return all special keycode can be used
     * */
    public String specialTable() {
        return this.driverManager.sendCommand(("[[\"special_table\"]]"));
    }
    /**
     * get current mouse position x, y
     * */
    public String position(){
        return this.driverManager.sendCommand("[[\"position\"]]");
    }
    /**
     * set mouse position
     * @param x: set mouse position x
     * @param y: set mouse position y
     * */
    public String setPosition(int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"set_position\", {\"x\": %d, \"y\": %d}]]", x, y)
        );
    }
    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * */
    public String pressMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * @param x: pressMouse on position x
     * @param y: pressMouse on position y
     * */
    public String pressMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }
    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * */
    public String releaseMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * @param x: releaseMouse event on position x
     * @param y: releaseMouse event on position y
     * */
    public String releaseMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }

    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * */
    public String clickMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode: mouse keycode we want to press
     * @param x: scroll event on position x
     * @param y: scroll event on position y
     * */
    public String clickMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }
    /**
     *
     * @param scroll_value: wheel scroll value
     * */
    public String scroll(int scroll_value){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d}]]", scroll_value)
        );
    }
    /**
     *
     * @param scroll_value: wheel scroll value
     * @param x: scroll on position x
     * @param y: scroll on position y
     * */
    public String scroll(int scroll_value, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d}]]",
                        scroll_value, x, y)
        );
    }
    /**
     *
     * @param scroll_value: wheel scroll value
     * @param x: scroll on position x
     * @param y: scroll on position y
     * @param scroll_direction: scroll which direction (scroll_up, scroll_down, scroll_left, scroll_right)
     * */
    public String scroll(int scroll_value, int x, int y, String scroll_direction){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d, \"scroll_direction\": \"%s\"}]]",
                        scroll_value, x, y, scroll_direction)
        );
    }


}
