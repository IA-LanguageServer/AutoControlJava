package unittest.autocontroldrive.socket;

import autocontroldriver.utils.socket.ClientSocket;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class TestSocketClient {

    @Test
    public void testSocketSend() {
        try {
            ClientSocket clientSocket = new ClientSocket("localhost", 9938);
            Assert.assertNotNull(clientSocket);
            clientSocket.sendData("[[\"size\"]]");
            clientSocket.sendData("quit_server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
