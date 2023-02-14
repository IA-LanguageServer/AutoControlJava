package autocontroldriver.utils.process;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class OpenDriverProcess extends Thread {

    private final String driverPath;
    // Process use to open driver
    private Process process;
    // string command list use to create process
    private List<String> processCommandList;

    /**
     * @param driverPath;
     */
    public OpenDriverProcess(String driverPath) {
        this.driverPath = driverPath;
        this.setDaemon(true);
    }

    /**
     * @param processCommandList;
     */
    public OpenDriverProcess(List<String> processCommandList) {
        this.driverPath = processCommandList.get(0);
        this.processCommandList = processCommandList;
        this.setDaemon(true);
    }


    public void close() {
        if (this.process != null) {
            process.destroy();
        }
    }

    /**
     *
     */
    @Override
    public void run() {
        super.run();
        try {
            File checkDriver = new File(this.driverPath);
            if (checkDriver.exists()) {
                ProcessBuilder processBuilder;
                if (processCommandList == null) {
                    processBuilder = new ProcessBuilder(this.driverPath);
                    processBuilder.directory(new File(Path.of("").toAbsolutePath().toString()));
                    processBuilder.inheritIO();
                } else {
                    processBuilder = new ProcessBuilder(this.processCommandList);
                    processBuilder.directory(new File(Path.of("").toAbsolutePath().toString()));
                    processBuilder.inheritIO();
                }
                this.process = processBuilder.start();
                while (process.isAlive()) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
