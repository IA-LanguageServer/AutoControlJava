package autocontroldriver.bind.screen;

import autocontroldriver.bind.AutoControlDriverManager;

public class Screen {

    private AutoControlDriverManager autoControlDriverManager;

    public Screen(AutoControlDriverManager autoControlDriverManager){
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void screen(){
        this.autoControlDriverManager.sendCommand("[[\"size\"]]");
    }

    public void screenshot(){
        this.autoControlDriverManager.sendCommand("");
    }

}
