package com.bq.qa.pareto.apps.driver.connection;

import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.android.Connection;
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
     * @see Connection#WIFI
     */
    @Override
    public void turnOnWifi() {
        paretoLogger.debug("Turning on Wifi");
        androidDriver.setConnection(Connection.WIFI);
    }

    /**
     * @see Connection#WIFI
     */
    @Override
    public void turnOffWifi() {
        paretoLogger.debug("Turning off Wifi");
        androidDriver.setConnection(Connection.DATA);
    }

    /**
     * @see Connection#AIRPLANE
     */
    @Override
    public void turnOnAirPlaneMode() {
        paretoLogger.debug("Turning on Air Plane Mode");
        androidDriver.setConnection(Connection.AIRPLANE);
    }

    /**
     * @see Connection#AIRPLANE
     */
    @Override
    public void turnOffAirPlaneMode() {
        paretoLogger.debug("Turning off Air Plane Mode");
        androidDriver.setConnection(Connection.DATA);
    }

    /**
     * @see Connection#DATA
     */
    @Override
    public void turnOnData() {
        paretoLogger.debug("Turning on Data");
        androidDriver.setConnection(Connection.DATA);
    }

    /**
     * @see Connection#NONE
     */
    @Override
    public void turnOffData() {
        paretoLogger.debug("Turning off Data");
        androidDriver.setConnection(Connection.NONE);
    }


    /**
     * @see Network#isAirPlaneModeEnabled()
     */
    @Override
    public boolean isAirPlaneModeEnabled() {
        return androidDriver.getConnection().compareTo(Connection.AIRPLANE)==0;
    }

    /**
     * @see Network#isDataEnabled()
     */
    @Override
    public boolean isDataEnabled() {
        return androidDriver.getConnection().compareTo(Connection.DATA)==0;
    }

    /**
     * @see Network#isWifiEnabled()
     */
    @Override
    public boolean isWifiEnabled() {
        return androidDriver.getConnection().compareTo(Connection.WIFI)==0;
    }
}
