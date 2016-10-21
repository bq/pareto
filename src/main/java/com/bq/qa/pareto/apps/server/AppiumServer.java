package com.bq.qa.pareto.apps.server;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.util.FileHandler;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * <p/>
 * This class allows to save and manage server configuration arguments
 * <p/>
 */
public class AppiumServer {

    private final Logger paretoLogger = ParetoAppLogger.getLogger();
    private AppiumDriverLocalService service;

    private String pathAppium;
    private String UDID;

    /**
     * Constructor: creates a server with configuration by default
     * ({@see com.bq.com.apps.server.DefaultServerOptions})
     */
    public AppiumServer(DesiredCapabilities desiredCapabilities, String UDID) {
        this.UDID = UDID;
        pathAppium = getAppiumPath();

        ServerArgument bootstrapPort = () -> "--bootstrap-port";

        ServerArgument options = () -> ParetoApp.getConfig().appium_options();
        String log_level = ParetoApp.getConfig().appium_log_level();
        File logFile = new File(FileHandler.getLogPath());
        if(!"default".equals(UDID))
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,UDID);

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withAppiumJS(new File(pathAppium))
                .withIPAddress(ParetoApp.getConfig().appium_ip())
                .withArgument(bootstrapPort, getRandomPort())
                .withArgument(GeneralServerFlag.LOG_LEVEL, log_level)
                .withLogFile(logFile)
                .withCapabilities(desiredCapabilities)
                .withArgument(options);

        service = builder.build();
        paretoLogger.debug("The Appium Server For Real Devices has been created succesfully");

    }


    /**
     * Starts Appium server
     */
    public void start() {
        service.start();
    }

    /**
     * Stops Appium server
     */
    public void stop() {
        service.stop();
    }

    /**
     * Get URL of Appium
     *
     * @return endpoint of appium
     */
    public String getURL() {
        return service.getUrl().toString();
    }



    /**
     * Get Appium JS PATH
     *
     * @return pathAppium
     */
    public String getPathAppium() {
        return pathAppium;
    }


    /**
     * Setups the version on an Appium command
     */
    private String getAppiumPath() {
        String baseCommand = ParetoApp.getConfig().appium_bin();
        return baseCommand;
    }

    /**
     * Gets a random port
     *
     * @return
     */
    private String getRandomPort() {
        return Integer.toString(PortProber.findFreePort());
    }

    public String getUDID() {
        return UDID;
    }
}
