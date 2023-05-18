package test.unittest.autocontroldrive.process;

import org.junit.Assert;
import org.junit.Test;

import autocontroldriver.utils.process.OpenDriverProcess;

import java.nio.file.Path;


public class TestOpenDriver {

    @Test
    public void testOpen() {
        OpenDriverProcess openDriverProcess = new OpenDriverProcess(
                Path.of("").toAbsolutePath() + "/AutoControlDriverWindows.exe");
        openDriverProcess.start();
        Assert.assertNotNull(openDriverProcess);
    }

}
