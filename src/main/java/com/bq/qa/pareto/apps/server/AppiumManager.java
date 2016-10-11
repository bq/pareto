package com.bq.qa.pareto.apps.server;

import com.bq.qa.pareto.apps.emulator.AndroidEmulator;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

/**
 * <p/>
 * This class represents the facade for the apps module. Users must use it to get the driver,
 * start and stop the Appium server
 * <p/>
 */
public class AppiumManager {

    private Logger paretoLogger;

    private ArrayList<AppiumServer> appiumServerList;
    private ArrayList<AndroidEmulator> androidEmulators;

    /**
     * Constructor
     */
    public AppiumManager() {
        this.paretoLogger = ParetoAppLogger.getLogger();
        this.androidEmulators = new ArrayList<>();
        this.appiumServerList = new ArrayList<>();
    }

    /**
     * Starts android Emulator
     *
     * @param udid
     */
    public void startAndroidEmulator(String udid) {
        AndroidEmulator androidEmulator = new AndroidEmulator(udid);
        paretoLogger.debug("Starting the Android Emulator by UDID");
        androidEmulator.start();
        androidEmulators.add(androidEmulator);
    }

     /**
     * Stops the android emulator associated with an udid
     *
     * @param udid android device id
     */
    public void stopAndroidEmulator(String udid) {
        Optional<AndroidEmulator> androidEmulator = findAndroidEmulatorByUDID(udid);
        paretoLogger.debug("Stopping the Android Emulator by UDID");
        androidEmulator.ifPresent(AndroidEmulator::stop);
    }

    /**
     * Starts an Appium Server
     *
     * @return An instance of AppiumServer class
     */
    public AppiumServer startAppiumServer(String udid,String so) {
        AppiumServer server =  ServerFactory.initServer(udid,so);
        paretoLogger.debug("Starting the Appium Server");
        server.start();
        appiumServerList.add(server);
        return server;
    }

    /**
     * Stops the appium server associated with an udid
     *
     * @param udid android device id
     */
    public void stopAppiumServer(String udid) {
        Optional<AppiumServer> server = findAppiumByUDID(udid);
        paretoLogger.debug("Stopping the Appium Server by UDID");
        server.ifPresent(AppiumServer::stop);
    }

    /**
     * Find an emulator by device UDID
     *
     * @param udid android device id
     * @return an instance of AndroidEmulator class
     */
    private Optional<AndroidEmulator> findAndroidEmulatorByUDID(String udid) {
        return androidEmulators.stream().filter(server -> server.getUDID().equals(udid)).findFirst();
    }

    /**
     * Find an Appium server by device UDID
     *
     * @param udid android device id
     * @return an instance of AppiumServer class
     */
    private Optional<AppiumServer> findAppiumByUDID(String udid) {
        return appiumServerList.stream().filter(server -> server.getUDID().equals(udid)).findFirst();
    }


}
