package autocontroldriver.bind.record;

import autocontroldriver.bind.AutoControlDriverManager;

public class Record {

    private final AutoControlDriverManager autoControlDriverManager;

    public Record(AutoControlDriverManager autoControlDriverManager) {
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void record(){
        this.autoControlDriverManager.sendCommand("[[\"record\"]]");
    }

    public void stopRecord(){
        this.autoControlDriverManager.sendCommand("[[\"stopRecord\"]]");
    }

}
