package unittest.autocontroldrive.process;

import org.junit.Test;

import autocontroldriver.utils.process.OpenDriverProcess;


public class TestOpenDriver {

    @Test
    public void testOpen() {
        OpenDriverProcess openDriverProcess = new OpenDriverProcess(
                "C:\\program_workspace\\java\\AutoControlJava\\test_resource\\generate_autocontrol_driver.exe");
        openDriverProcess.start();
    }

}
