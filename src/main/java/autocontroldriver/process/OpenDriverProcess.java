package autocontroldriver.process;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OpenDriverProcess extends Thread {

    private String driverPath;
    private Process openDriverProcess;
    private InputStreamReader driverProcessReader;
    private InputStreamReader driverErrorReader;
    private OutputStreamWriter driverProcessWriter;

    public OpenDriverProcess(String driverPath) {
        this.driverPath = driverPath;
    }

    @Override
    public void run() {
        super.run();
        try {
            File checkDriver = new File(this.driverPath);
            if (checkDriver.exists()) {
                openDriverProcess = Runtime.getRuntime().exec(this.driverPath);
                driverProcessReader = new InputStreamReader(openDriverProcess.getInputStream(), StandardCharsets.UTF_8);
                driverProcessWriter = new OutputStreamWriter(openDriverProcess.getOutputStream(), StandardCharsets.UTF_8);
                driverErrorReader = new InputStreamReader(openDriverProcess.getErrorStream(), StandardCharsets.UTF_8);
            }
            while (openDriverProcess.isAlive()){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
