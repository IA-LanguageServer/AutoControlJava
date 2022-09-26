package autocontroldriver.bind;

import autocontroldriver.bind.screen.Screen;
import autocontroldriver.process.OpenDriverProcess;
import autocontroldriver.socket.ClientSocket;

import java.io.IOException;
import java.nio.file.Path;

public class AutoControlDriverManager {

    private ClientSocket clientSocket;
    private static OpenDriverProcess openDriverProcess;
    private String driverPath;

    public AutoControlDriverManager(String host, int port, String driverPath, String platform) throws IOException {
        this.driverPath = driverPath;
        switch (platform) {
            case "windows":
                if (driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_win64.exe";
                break;
            case "linux":
                if (driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_liinux";
                break;
            case "macos":
                if (driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_macos";
                break;

        }
        if (openDriverProcess == null) {
            openDriverProcess = new OpenDriverProcess(this.driverPath);
            openDriverProcess.start();
            this.clientSocket = new ClientSocket(host, port);
        }else {
            throw new IOException("Can't init AutoControlDriverManager");
        }

    }

    public void sendCommand(String commandToSend){
        this.clientSocket.sendData(commandToSend);
    }

    public boolean isAlive(){
        return openDriverProcess.isAlive();
    }

    public void quit(){
        try {
            this.clientSocket.closeClient();
            openDriverProcess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
