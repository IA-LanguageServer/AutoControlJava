package autocontroldriver.bind.record;

import autocontroldriver.utils.driver_manager.DriverManager;

public class Record {

    private DriverManager driverManager;
    /**
     * class init with driver manager
     * @param driverManager driver manager that manage driver:
     * */
    public Record(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     * start record test
     * @return server response string
     */
    public String record(){
        return this.driverManager.sendCommand("[[\"record\"]]");
    }

    /**
     * stop record test
     * @return  server response string
     */
    public String stopRecord(){
        return this.driverManager.sendCommand("[[\"stopRecord\"]]");
    }

}
