package autocontroldriver.process;

import autocontroldriver.socket.ClientSocket;

import java.io.File;
import java.io.IOException;

public class OpenDriverProcess extends Thread {

    private String driverPath;
    private Process openDriverProcess;

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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        OpenDriverProcess openDriverProcess = new OpenDriverProcess(
                "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver_win64.exe");
        openDriverProcess.start();
        while (true){
        }
    }
}
