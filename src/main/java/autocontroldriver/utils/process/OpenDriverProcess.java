package autocontroldriver.utils.process;

import java.io.*;

public class OpenDriverProcess extends Thread {

    // AutoControl Driver path
    private String driverPath;
    // Process use to open driver
    private Process process;
    // use to read process output
    private BufferedInputStream driverProcessReader;
    // use to read process error output
    private BufferedInputStream driverErrorReader;

    public OpenDriverProcess(String driverPath) {
        this.driverPath = driverPath;
        this.setDaemon(true);
    }


    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getDriverPath() {
        return this.driverPath;
    }

    public void close(){
        if(this.process != null) {
            process.destroy();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            File checkDriver = new File(this.driverPath);
            if (checkDriver.exists()) {
                process = Runtime.getRuntime().exec(this.driverPath);
                driverProcessReader = new BufferedInputStream(process.getInputStream());
                driverErrorReader = new BufferedInputStream(process.getErrorStream());
                while (process.isAlive()){
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
