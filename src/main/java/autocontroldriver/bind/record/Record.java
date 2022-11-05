package autocontroldriver.bind.record;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Record {

    private DriverManager driverManager;

    public Record(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String record(){
        return this.driverManager.sendCommand("[[\"record\"]]");
    }

    public String stopRecord(){
        return this.driverManager.sendCommand("[[\"stopRecord\"]]");
    }

}
