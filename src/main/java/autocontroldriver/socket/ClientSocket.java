package autocontroldriver.socket;


import java.io.*;
import java.net.Socket;

public class ClientSocket extends Thread {
    private Socket sendCommandSocket;
    private PrintWriter printWriter;
    private String host;
    private int port;

    public ClientSocket(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.setDaemon(true);
    }

    public void closeClient() throws IOException {
        if (sendCommandSocket != null)
            sendCommandSocket.close();
        if (printWriter != null)
            printWriter.close();
    }

    public void sendData(String stringToPrint){
        try {
            this.sendCommandSocket = new Socket(this.host, this.port);
            this.printWriter = new PrintWriter(this.sendCommandSocket.getOutputStream());
            this.printWriter.write(stringToPrint);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        super.run();
    }

}

