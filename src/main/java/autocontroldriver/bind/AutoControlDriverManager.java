package autocontroldriver.bind;

import autocontroldriver.bind.image.Image;
import autocontroldriver.bind.mouse.Mouse;
import autocontroldriver.bind.record.Record;
import autocontroldriver.bind.screen.Screen;
import autocontroldriver.utils.process.OpenDriverProcess;
import autocontroldriver.utils.socket.ClientSocket;

import java.io.IOException;
import java.nio.file.Path;

public class AutoControlDriverManager {

    private final ClientSocket clientSocket;
    private static OpenDriverProcess openDriverProcess;
    public String driverPath;
    public Screen screen = new Screen(this);
    public Mouse mouse = new Mouse(this);
    public Image image = new Image(this);
    public Record record = new Record(this);

    public AutoControlDriverManager(String host, int port, String driverPath, String platform) throws IOException {
        this.driverPath = driverPath;
        switch (platform) {
            case "windows":
                if (this.driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_win64.exe";
                break;
            case "linux":
                if (this.driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_liinux";
                break;
            case "macos":
                if (driverPath == null)
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_macos";
                break;

        }
        this.driverPath = this.driverPath.replace("\\", "/");
        if (openDriverProcess == null) {
            openDriverProcess = new OpenDriverProcess(this.driverPath);
            openDriverProcess.start();
            this.clientSocket = new ClientSocket(host, port);
            clientSocket.start();
            while (!openDriverProcess.isAlive()) {
            }
        } else {
            throw new IOException("Can't init AutoControlDriverManager");
        }

    }

    public void sendCommand(String commandToSend) {
        boolean retry = true;
        int retryCount = 5;
        while (retry && retryCount >= 0) {
            if (openDriverProcess.isAlive() && this.clientSocket != null) {
                this.clientSocket.sendData(commandToSend);
                retry = false;
            } else {
                System.err.printf("Driver not ready %s%n", commandToSend);
                retryCount -=1;
            }
        }
    }


    public void quit() {
        try {
            this.clientSocket.sendData("quit_server");
            this.clientSocket.closeClient();
            openDriverProcess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
