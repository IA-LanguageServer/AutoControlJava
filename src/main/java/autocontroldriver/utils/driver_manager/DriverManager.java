package autocontroldriver.utils.driver_manager;

import autocontroldriver.bind.image.Image;
import autocontroldriver.bind.keyboard.Keyboard;
import autocontroldriver.bind.mouse.Mouse;
import autocontroldriver.bind.record.Record;
import autocontroldriver.bind.screen.Screen;
import autocontroldriver.bind.utils.Utils;
import autocontroldriver.utils.process.OpenDriverProcess;
import autocontroldriver.utils.socket.ClientSocket;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class DriverManager {

    private final ClientSocket clientSocket;
    private static OpenDriverProcess openDriverProcess;
    private String host;
    private int port;
    public String driverPath;
    public Screen screen = new Screen(this);
    public Mouse mouse = new Mouse(this);
    public Keyboard keyboard = new Keyboard(this);
    public Image image = new Image(this);
    public Record record = new Record(this);
    public Utils utils = new Utils(this);

    /**
     * @param host;
     * @param port;
     * @param platform;
     * @return driverPath;
     */
    private String setDriver(String host, int port, String platform){
        switch (platform) {
            case "windows":
                if (this.driverPath.equals(""))
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_win.exe";
                break;
            case "linux":
                if (this.driverPath.equals(""))
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_linux";
                break;
            case "macos":
                if (this.driverPath.equals(""))
                    this.driverPath = Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_macos";
                break;
        }
        this.host = host;
        this.port = port;
        this.driverPath = this.driverPath.replace("\\", "/");
        return this.driverPath;
    }

    /**
     * @param host;
     * @param port;
     * @param driverPath;
     * @param platform;
     * @throws IOException;
     */
    public DriverManager(String host, int port, String driverPath, String platform) throws IOException {
        this.driverPath = driverPath;
        setDriver(host, port, platform);
        if (openDriverProcess == null) {
            openDriverProcess = new OpenDriverProcess(this.driverPath);
            openDriverProcess.start();
            this.clientSocket = new ClientSocket(this.host, this.port);
            while (!openDriverProcess.isAlive()) {
            }
        } else {
            throw new IOException("Can't init DriverManager");
        }
    }

    /**
     * @param host;
     * @param port;
     * @param processCommandList;
     * @param platform;
     * @throws IOException;
     */
    public DriverManager(String host, int port, List<String> processCommandList, String platform) throws IOException {
        this.driverPath = processCommandList.get(0);
        setDriver(host, port, platform);
        if (openDriverProcess == null) {
            openDriverProcess = new OpenDriverProcess(processCommandList);
            openDriverProcess.start();
            this.clientSocket = new ClientSocket(this.host, this.port);
            while (!openDriverProcess.isAlive()) {
            }
        } else {
            throw new IOException("Can't init DriverManager");
        }
    }

    /**
     * @param commandToSend;
     * @return string;
     */
    public String sendCommand(String commandToSend) {
        int retryCount = 5;
        while (retryCount >= 0) {
            if (openDriverProcess.isAlive() && this.clientSocket != null) {
                return this.clientSocket.sendData(commandToSend);
            } else {
                System.err.printf("Driver not ready %s%n", commandToSend);
                retryCount -= 1;
            }
        }
        return "";
    }


    public void quit() {
        try {
            this.clientSocket.sendData("quit_server");
            this.clientSocket.closeClient();
            openDriverProcess.close();
            openDriverProcess = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
