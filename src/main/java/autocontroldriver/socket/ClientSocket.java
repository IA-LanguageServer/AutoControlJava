package autocontroldriver.socket;


import java.io.*;
import java.net.Socket;

public class ClientSocket extends Thread {
    private Socket sendCommandSocket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public ClientSocket(String host, int port) throws IOException {
        this.sendCommandSocket = new Socket(host, port);
        this.printWriter = new PrintWriter(this.sendCommandSocket.getOutputStream());
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.sendCommandSocket.getInputStream()));
    }

    public void closeClient() throws IOException {
        if (sendCommandSocket != null)
            sendCommandSocket.close();
        if (printWriter != null)
            printWriter.close();
        if (bufferedReader != null)
            bufferedReader.close();
    }

    public void sendData(String stringToPrint){
        this.printWriter.write(stringToPrint);
        this.printWriter.flush();
    }

    public String receiveData() throws IOException {
        return this.bufferedReader.readLine();
    }

    @Override
    public void run() {
        super.run();
    }

}

