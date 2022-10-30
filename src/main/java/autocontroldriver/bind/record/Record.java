package autocontroldriver.bind.record;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Record {

    private DriverManager driverManager;

    public Record(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void record(){
        this.driverManager.sendCommand("[[\"record\"]]");
    }

    public void stopRecord(){
        this.driverManager.sendCommand("[[\"stopRecord\"]]");
    }

}
