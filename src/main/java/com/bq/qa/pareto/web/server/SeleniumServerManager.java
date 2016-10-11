package com.bq.qa.pareto.web.server;

import com.bq.qa.pareto.web.util.ParetoWebLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

public class SeleniumServerManager {

    private final Logger paretoLogger = ParetoWebLogger.getLogger();


    private SeleniumServer server = null;

    public SeleniumServerManager(int port){
        RemoteControlConfiguration rcc = new RemoteControlConfiguration();
        rcc.setPort(port);
        initSeleniumServer(rcc);
    }

    /**
     * Starts the Selenium server
     */
    public void startSeleniumServer() {
        try {
            paretoLogger.debug("Starting the Selenium server");
            server.start();
            paretoLogger.debug("The Selenium server is up");
        } catch (Exception e) {
            paretoLogger.fatal("Could not start Selenium Server because of: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Stops the Selenium server
     */
    public void stopSeleniumServer() {
        if (server != null) {
            try {
                paretoLogger.debug("Stopping the active selenium server");
                server.stop();
                server = null;
                paretoLogger.debug("The Selenium server is down");
            } catch (Exception e) {
                paretoLogger.fatal("Could not stop the Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * @param config : Initializes the Selenium server
     */
    private void initSeleniumServer(RemoteControlConfiguration config) {
        if (server == null) {
            try {
                server = new SeleniumServer(config);
            } catch (Exception e) {
                paretoLogger.fatal("Could not create Selenium Server because of: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
