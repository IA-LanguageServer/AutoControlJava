package autocontroldriver.bind.screen;

import autocontroldriver.bind.AutoControlDriverManager;

import java.util.ArrayList;

public class Screen {

    private AutoControlDriverManager autoControlDriverManager;

    public Screen(AutoControlDriverManager autoControlDriverManager){
        this.autoControlDriverManager = autoControlDriverManager;
    }

    public void screen(){
        this.autoControlDriverManager.sendCommand("[[\"size\"]]");
    }

    public void screenshot(){
        this.autoControlDriverManager.sendCommand(("[[\"screenshot\"]]"));
    }

    public void screenshot(String filePath){
        this.autoControlDriverManager.sendCommand(
                String.format("[[\"screenshot\", {\"file_path\": %s}]]", filePath)
                );
    }

    public void screenshot(ArrayList<Integer> region){
        this.autoControlDriverManager.sendCommand("");
    }

    public void screenshot(String filePath, ArrayList<Integer> region){
        this.autoControlDriverManager.sendCommand("");
    }

}
