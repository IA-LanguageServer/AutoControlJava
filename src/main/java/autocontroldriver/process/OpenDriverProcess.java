package autocontroldriver.process;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OpenDriverProcess extends Thread {

    private String driverPath;
    private Process openDriverProcess;
    private BufferedInputStream driverProcessReader;
    private BufferedInputStream driverErrorReader;
    private OutputStreamWriter driverProcessWriter;

    public OpenDriverProcess(String driverPath) {
        this.driverPath = driverPath;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        try {
            File checkDriver = new File(this.driverPath);
            if (checkDriver.exists()) {
                openDriverProcess = Runtime.getRuntime().exec(this.driverPath);
                driverProcessReader = new BufferedInputStream(openDriverProcess.getInputStream());
                driverErrorReader = new BufferedInputStream(openDriverProcess.getErrorStream());
                driverProcessWriter = new OutputStreamWriter(openDriverProcess.getOutputStream(), StandardCharsets.UTF_8);
            }
            while (openDriverProcess.isAlive()){
                // Normal output
                ByteArrayOutputStream driverProcessReaderByteArrayOutputStream = new ByteArrayOutputStream();
                for(int result = driverProcessReader.read(); result!=-1; result = driverProcessReader.read()){
                    driverProcessReaderByteArrayOutputStream.write(result);
                }
                System.out.print(driverProcessReaderByteArrayOutputStream);
                // Error output
                driverProcessReaderByteArrayOutputStream = new ByteArrayOutputStream();
                for(int result = driverErrorReader.read(); result!=-1; result = driverErrorReader.read()){
                    driverProcessReaderByteArrayOutputStream.write(result);
                }
                System.out.print(driverProcessReaderByteArrayOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
