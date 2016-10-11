package com.bq.qa.pareto.web.server;

import com.bq.qa.pareto.apps.util.Timer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

public class SeleniumServerManagerTest {

    @Test
    public void testStartSeleniumServer() throws Exception {
        SeleniumServerManager serverManager = new SeleniumServerManager(4444);
        serverManager.startSeleniumServer();
        Boolean condition = true;
        for (int i = 0; i < 5; i++) {
            Timer.waitSeconds(1);
            condition = isPortInUse(4444);
        }
        serverManager.stopSeleniumServer();

        Assert.assertTrue(condition);
    }

    @Test
    public void testStopSeleniumServer() throws Exception {
        SeleniumServerManager serverManager = new SeleniumServerManager(4444);
        serverManager.startSeleniumServer();
        serverManager.stopSeleniumServer();
        Assert.assertFalse(isPortInUse(4444));
    }


    private boolean isPortInUse(int port) {
        String host = "localhost";
        boolean isConnected = false;
        try {
            Socket skt;
            skt = new Socket(host, port);
            isConnected = skt.isConnected();
            skt.close();
        } catch (IOException e) {
        }
        return isConnected;
    }
}