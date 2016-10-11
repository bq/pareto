package com.bq.qa.pareto.apps.driver.connection;

import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.NetworkConnectionSetting;
import org.apache.logging.log4j.Logger;

/**
 * <p/>
 * This class provides methods for switching on<br>
 * and off multiple connections in Android devices<br>
 * <p/>
 * References: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/network_connection.md
 *
 */
public class AndroidNetwork implements Network {

    private AndroidDriver androidDriver;
    private Logger paretoLogger;

    private static final int NO_CONEXIONS = 0;
    private static final int AIRPLANE_MODE = 1;
    private static final int WIFI_ONLY = 2;
    private static final int DATA_ONLY = 4;
    private static final int ALL_CONEXIONS = 6;

    /**
     * Constructor
     *
     * @param androidDriver
     */
    public AndroidNetwork(AndroidDriver androidDriver) {
        this.paretoLogger = ParetoAppLogger.getLogger();
        this.androidDriver = androidDriver;
    }

    /**
     * @see Network#turnOnWifi()
     */
    @Override
    public void turnOnWifi() {
        paretoLogger.debug("Turning on Wifi");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(WIFI_ONLY));
    }

    /**
     * @see Network#turnOffWifi()
     */
    @Override
    public void turnOffWifi() {
        paretoLogger.debug("Turning off Wifi");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(DATA_ONLY));
    }

    /**
     * @see Network#turnOnAirPlaneMode()
     */
    @Override
    public void turnOnAirPlaneMode() {
        paretoLogger.debug("Turning on Air Plane Mode");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(AIRPLANE_MODE));
    }

    /**
     * @see Network#turnOffAirPlaneMode()
     */
    @Override
    public void turnOffAirPlaneMode() {
        paretoLogger.debug("Turning off Air Plane Mode");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(ALL_CONEXIONS));
    }

    /**
     * @see Network#turnOnData()
     */
    @Override
    public void turnOnData() {
        paretoLogger.debug("Turning on Data");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(DATA_ONLY));
    }

    /**
     * @see Network#turnOffData()
     */
    @Override
    public void turnOffData() {
        paretoLogger.debug("Turning off Data");
        androidDriver.setNetworkConnection(new NetworkConnectionSetting(AIRPLANE_MODE));
    }


    /**
     * @see Network#isAirPlaneModeEnabled()
     */
    @Override
    public boolean isAirPlaneModeEnabled() {
        boolean isAirPlaneModeEnabled = androidDriver.getNetworkConnection().airplaneModeEnabled();
        paretoLogger.debug("Is Air Plane Mode enabled ? : " + isAirPlaneModeEnabled);
        return isAirPlaneModeEnabled;
    }

    /**
     * @see Network#isDataEnabled()
     */
    @Override
    public boolean isDataEnabled() {
        boolean isDataEnabled = androidDriver.getNetworkConnection().dataEnabled();
        paretoLogger.debug("Is data enabled ? : " + isDataEnabled);
        return isDataEnabled;
    }

    /**
     * @see Network#isWifiEnabled()
     */
    @Override
    public boolean isWifiEnabled() {
        boolean isWifiEnabled = androidDriver.getNetworkConnection().wifiEnabled();
        paretoLogger.debug("Is Wifi enabled ? : " + isWifiEnabled);
        return isWifiEnabled;
    }
}
