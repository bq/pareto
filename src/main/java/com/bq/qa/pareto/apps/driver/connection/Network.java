package com.bq.qa.pareto.apps.driver.connection;

/**
 * <p/>
 * This interface provides methods for turn on<br>
 * and turn off the multiple connections on the devices<br>
 * <p/>
 */
public interface Network {


    /**
     * Turns on WiFi in the device
     */
    void turnOnWifi();

    /**
     * Turns off WiFi in the device
     */
    void turnOffWifi();

    /**
     * Turns on airplane mode in the device
     */
    void turnOnAirPlaneMode();

    /**
     * Turns off airplane mode in the device
     */
    void turnOffAirPlaneMode();

    /**
     * Turns on mobile data in the device
     */
    void turnOnData();

    /**
     * Turns off mobile data in the device
     */
    void turnOffData();


    /**
     * Returns true if the airplane mode is enabled. Otherwise, false
     */
    boolean isAirPlaneModeEnabled();

    /**
     * Returns true if the mobile data is enabled. Otherwise, false
     */
    boolean isDataEnabled();

    /**
     * Returns true if the WiFi is enabled. Otherwise, false
     */
    boolean isWifiEnabled();
}
