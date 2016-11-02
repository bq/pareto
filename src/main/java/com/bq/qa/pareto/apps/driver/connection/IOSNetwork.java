package com.bq.qa.pareto.apps.driver.connection;


import com.bq.qa.pareto.apps.config.IOSAppConfig;
import com.bq.qa.pareto.apps.exceptions.DeviceNotIdentified;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.Logger;

/**
 * <p/>
 * This class provides methods for switching on<br>
 * and off multiple connections in iOS devices<br>
 * <p/>
 */
public class IOSNetwork implements Network {

    //TODO revisar las coordenadas y adaptarlas a los distintos dispositivo. Sólo soporta iPhone 5-5C-5S



    private static final String IPHONE5 = "iPhone 5";
    private static final String IPHONE6_PLUS = "iPhone 6 Plus";
    private static final String IPAD_AIR = "iPad Air";
    private static final String DEVICE_NOT_IDENTIFIED_ERR_MSG = "The ios device cannot be identified ";

    private Logger paretoLogger;
    private IOSDriver iosDriver;
    private String deviceType;
    private IOSAppConfig iosAppConfig;

    /**
     * Constructor
     *
     * @param iosDriver
     */
    public IOSNetwork(IOSDriver iosDriver, IOSAppConfig iosAppConfig) {
        this.iosAppConfig = iosAppConfig;
        this.paretoLogger = ParetoAppLogger.getLogger();
        this.iosDriver = iosDriver;
        this.deviceType = iosAppConfig.appium_deviceName();

    }

    /**
     * Gets the coordinates of the WiFi button depending on the device type
     *
     * @return array with the specific coordinates
     * @throws DeviceNotIdentified
     */
    private double[] getWifiCoordinates() throws DeviceNotIdentified {
        paretoLogger.debug("Getting the WiFi icon coordinates depending on the device type");

        if (deviceType.contains(IPHONE5)) return new double[]{95.00, 186.50};
        else if (deviceType.equalsIgnoreCase(IPHONE6_PLUS)) return new double[]{137.67, 374.00};
        else if (deviceType.contains(IPAD_AIR)) return new double[]{322.50, 898.50};
        else throw new DeviceNotIdentified(DEVICE_NOT_IDENTIFIED_ERR_MSG);
    }

    /**
     * Gets the coordinates of the airplane button depending of the device type
     *
     * @return array with the coordinates
     * @throws DeviceNotIdentified
     */
    private double[] getAirPlaneCoordinates() throws DeviceNotIdentified {
        paretoLogger.debug("Getting the airplane icon coordinates depending on the device type");

        if (deviceType.contains(IPHONE5)) return new double[]{45.50, 174.00};
        else if (deviceType.equalsIgnoreCase(IPHONE6_PLUS)) return new double[]{57.67, 348.33};
        else if (deviceType.contains(IPAD_AIR)) return new double[]{268.00, 905.50};
        else throw new DeviceNotIdentified(DEVICE_NOT_IDENTIFIED_ERR_MSG);
    }

    /**
     * @see Network#turnOnWifi()
     */
    @Override
    public void turnOnWifi() {
        paretoLogger.debug("Turning on WiFi");
        try {
            double[] coordinates = getWifiCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + ");");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }

    }

    /**
     * @see Network#turnOffWifi()
     */
    @Override
    public void turnOffWifi() {
        paretoLogger.debug("Turning off WiFi");

        try {
            double[] coordinates = getWifiCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + ");");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }
    }

    /**
     * @see Network#turnOnAirPlaneMode()
     */
    @Override
    public void turnOnAirPlaneMode() {
        paretoLogger.debug("Turning on airplane mode");

        try {
            double[] coordinates = getAirPlaneCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + "});");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }
    }

    /**
     * @see Network#turnOffAirPlaneMode()
     */
    @Override
    public void turnOffAirPlaneMode() {
        paretoLogger.debug("Turning off airplane mode");

        try {
            double[] coordinates = getAirPlaneCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + "});");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }
    }

    /**
     * turnOnData via AirPlaneMode on
     *
     * @see Network#turnOnData()
     */
    @Override
    public void turnOnData() {
        paretoLogger.debug("Turning on data mobile");

        try {
            double[] coordinates = getAirPlaneCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + "});");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }
    }

    /**
     * turnOffData via AirPlaneMode off
     *
     * @see Network#turnOffData()
     */
    @Override
    public void turnOffData() {
        paretoLogger.debug("Turning off data mobile");

        try {
            double[] coordinates = getAirPlaneCoordinates();
            iosDriver.executeScript("target.dragFromToForDuration({x:0.1, y:557.00},{x:211.00, y:206.00},0.5);");
            iosDriver.executeScript("target.delay(3);");
            iosDriver.executeScript("target.tap({x:" + coordinates[0] + ", y:" + coordinates[1] + "});");
        } catch (DeviceNotIdentified deviceNotIdentified) {
            deviceNotIdentified.printStackTrace();
        }
    }

    /**
     * @see Network#isAirPlaneModeEnabled()
     */
    @Override
    public boolean isAirPlaneModeEnabled() {
        paretoLogger.debug("Is Air Plane Mode enabled ? : " + false);
        return false;
    }

    /**
     * @see Network#isDataEnabled()
     */
    @Override
    public boolean isDataEnabled() {
        paretoLogger.debug("Is data enabled ? : " + false);
        return false;
    }

    /**
     * @see Network#isWifiEnabled()
     */
    @Override
    public boolean isWifiEnabled() {
        paretoLogger.debug("Is Wifi enabled ? : " + false);
        return false;
    }

}
