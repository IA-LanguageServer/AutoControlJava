package unittest.autocontroldrive.process;

import org.junit.Test;

import autocontroldriver.utils.process.OpenDriverProcess;

import java.nio.file.Path;


public class TestOpenDriver {

    @Test
    public void testOpen() {
        OpenDriverProcess openDriverProcess = new OpenDriverProcess(
                Path.of("").toAbsolutePath() + "/generate_autocontrol_driver_win.exe");
        openDriverProcess.start();
    }

}
