package autocontroldrive.socket;

import autocontroldriver.socket.ClientSocket;
import org.junit.Test;

import java.io.IOException;


public class TestSocketClient {

    @Test
    public void testSocketSend() {
        try {
            ClientSocket clientSocket = new ClientSocket("localhost", 9938);
            clientSocket.sendData("[[\"size\"]]");
            clientSocket.sendData("quit_server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
