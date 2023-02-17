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
     * @param x:
     * @param y:
     * */
    public String setPosition(int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"set_position\", {\"x\": %d, \"y\": %d}]]", x, y)
        );
    }
    /**
     *
     * @param mouse_keycode:
     * */
    public String pressMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode:
     * @param x:
     * @param y:
     * */
    public String pressMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"press_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }
    /**
     *
     * @param mouse_keycode:
     * */
    public String releaseMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode:
     * @param x:
     * @param y:
     * */
    public String releaseMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"release_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }

    /**
     *
     * @param mouse_keycode:
     * */
    public String clickMouse(String mouse_keycode){
        return this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\"}]]", mouse_keycode)
        );
    }
    /**
     *
     * @param mouse_keycode:
     * @param x:
     * @param y:
     * */
    public String clickMouse(String mouse_keycode, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"click_mouse\", {\"mouse_keycode\": \"%s\", \"x\": %d, \"y\": %d}]]", mouse_keycode, x, y)
        );
    }
    /**
     *
     * @param scroll_value:
     * */
    public String scroll(int scroll_value){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d}]]", scroll_value)
        );
    }
    /**
     *
     * @param scroll_value:
     * @param x:
     * @param y:
     * */
    public String scroll(int scroll_value, int x, int y){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d}]]",
                        scroll_value, x, y)
        );
    }
    /**
     *
     * @param scroll_value:
     * @param x:
     * @param y:
     * @param scroll_direction:
     * */
    public String scroll(int scroll_value, int x, int y, String scroll_direction){
        return this.driverManager.sendCommand(
                String.format("[[\"scroll\", {\"scroll_value\": %d, \"x\": %d, \"y\": %d, \"scroll_direction\": \"%s\"}]]",
                        scroll_value, x, y, scroll_direction)
        );
    }


}
