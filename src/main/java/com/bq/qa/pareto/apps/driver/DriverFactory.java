package com.bq.qa.pareto.apps.driver;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * <p/>
 * This class defines an object builder for app drivers, depending on the operating system
 * <p/>
 */
public class DriverFactory {


    private Logger paretoLogger;

    /**
     * Constructor
     */
    public DriverFactory() {
        this.paretoLogger = ParetoAppLogger.getLogger();
    }

    public AndroidDriver createAndroidDriver(String url){
        AndroidDriver androidDriver = null;
        try {
            androidDriver = new AndroidDriver(new URL(url),getAndroidCapabilities());
            androidDriver.manage().timeouts().implicitlyWait(ParetoApp.getConfig().driver_timeout(), TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return androidDriver;
    }


    public IOSDriver createiOSDriver(String url){
        IOSDriver iosDriver = null;
        try {
            iosDriver = new IOSDriver(new URL(url),getIosCapabilities());
            iosDriver.manage().timeouts().implicitlyWait(ParetoApp.getConfig().driver_timeout(), TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return iosDriver;
    }

    /**
     * Gets the iOS desired capabilities from the properties file
     *
     * @return a DesiredCapabilities instance.
     */
    public DesiredCapabilities getIosCapabilities() {
        DesiredCapabilities iosDesiredCapabilities = new DesiredCapabilities();
        setUpIOSCap(iosDesiredCapabilities);
        paretoLogger.debug("Returning Ios capabilities");
        return iosDesiredCapabilities;
    }

    /**
     * Gets the Android desired capabilities read from the properties file
     *
     * @return desired capabilities instance
     */
    public DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities androidDesiredCapabilities = new DesiredCapabilities();
        setUpAndroidCap(androidDesiredCapabilities);
        paretoLogger.debug("Returning Android capabilities");
        return androidDesiredCapabilities;
    }

    private void setUpIOSCap(DesiredCapabilities capabilities){
        setCapability(capabilities, MobileCapabilityType.PLATFORM_VERSION, ParetoApp.getIOSConfig().appium_platformVersion());
        setCapability(capabilities, MobileCapabilityType.DEVICE_NAME, ParetoApp.getIOSConfig().appium_deviceName());
        setCapability(capabilities, MobileCapabilityType.PLATFORM_NAME, ParetoApp.getIOSConfig().appium_platformName());
        setCapability(capabilities, IOSMobileCapabilityType.CALENDAR_FORMAT, ParetoApp.getIOSConfig().ios_calendarFormat());
        setCapability(capabilities, IOSMobileCapabilityType.BUNDLE_ID, ParetoApp.getIOSConfig().ios_bundleId());
        setCapability(capabilities, IOSMobileCapabilityType.LAUNCH_TIMEOUT, ParetoApp.getIOSConfig().ios_launchTimeout());
        setCapability(capabilities, IOSMobileCapabilityType.LOCATION_SERVICES_ENABLED, ParetoApp.getIOSConfig().ios_locationServicesEnabled());
        setCapability(capabilities, IOSMobileCapabilityType.LOCATION_SERVICES_AUTHORIZED, ParetoApp.getIOSConfig().ios_locationServicesAuthorized());
        setCapability(capabilities, IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, ParetoApp.getIOSConfig().ios_autoAcceptAlerts());
        setCapability(capabilities, IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, ParetoApp.getIOSConfig().ios_autoDismissAlerts());
        setCapability(capabilities, IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB, ParetoApp.getIOSConfig().ios_nativeInstrumentsLib());
        setCapability(capabilities, IOSMobileCapabilityType.NATIVE_WEB_TAP, ParetoApp.getIOSConfig().ios_nativeWebTap());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_INITIAL_URL, ParetoApp.getIOSConfig().ios_safariInitialUrl());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_ALLOW_POPUPS, ParetoApp.getIOSConfig().ios_safariAllowPopups());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_IGNORE_FRAUD_WARNING, ParetoApp.getIOSConfig().ios_safariIgnoreFraudWarning());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_OPEN_LINKS_IN_BACKGROUND, ParetoApp.getIOSConfig().ios_safariOpenLinksInBackground());
        setCapability(capabilities, IOSMobileCapabilityType.KEEP_KEY_CHAINS, ParetoApp.getIOSConfig().ios_keepKeyChains());
        setCapability(capabilities, IOSMobileCapabilityType.LOCALIZABLE_STRINGS_DIR, ParetoApp.getIOSConfig().ios_localizableStringsDir());
        setCapability(capabilities, IOSMobileCapabilityType.PROCESS_ARGUMENTS, ParetoApp.getIOSConfig().ios_processArguments());
        setCapability(capabilities, IOSMobileCapabilityType.SHOW_IOS_LOG, ParetoApp.getIOSConfig().ios_showIOSLog());
        setCapability(capabilities, IOSMobileCapabilityType.SEND_KEY_STRATEGY, ParetoApp.getIOSConfig().ios_sendKeyStrategy());
        setCapability(capabilities, IOSMobileCapabilityType.SCREENSHOT_WAIT_TIMEOUT, ParetoApp.getIOSConfig().ios_screenshotWaitTimeout());
        setCapability(capabilities, IOSMobileCapabilityType.WAIT_FOR_APP_SCRIPT, ParetoApp.getIOSConfig().ios_waitForAppScript());
        setCapability(capabilities, IOSMobileCapabilityType.WEBVIEW_CONNECT_RETRIES, ParetoApp.getIOSConfig().ios_webviewConnectRetries());
    }

    private void setUpAndroidCap(DesiredCapabilities capabilities){
        setCapability(capabilities, MobileCapabilityType.PLATFORM_VERSION, ParetoApp.getAndroidConfig().appium_platformVersion());
        setCapability(capabilities, MobileCapabilityType.DEVICE_NAME, ParetoApp.getAndroidConfig().appium_deviceName());
        setCapability(capabilities, MobileCapabilityType.PLATFORM_NAME, ParetoApp.getAndroidConfig().appium_platformName());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_ACTIVITY, ParetoApp.getAndroidConfig().android_appActivity());
        setCapability(capabilities,AndroidMobileCapabilityType.APP_PACKAGE, ParetoApp.getAndroidConfig().android_appPackage());
        setCapability(capabilities,AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ParetoApp.getAndroidConfig().android_appWaitActivity());
        setCapability(capabilities,AndroidMobileCapabilityType.APP_WAIT_PACKAGE, ParetoApp.getAndroidConfig().android_appWaitPackage());
        setCapability(capabilities,AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_deviceReadyTimeout());
        setCapability(capabilities,AndroidMobileCapabilityType.ANDROID_COVERAGE, ParetoApp.getAndroidConfig().android_androidCoverage());
        setCapability(capabilities,AndroidMobileCapabilityType.ENABLE_PERFORMANCE_LOGGING, ParetoApp.getAndroidConfig().android_enablePerformanceLogging());
        setCapability(capabilities,AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_androidDeviceReadyTimeout());
        setCapability(capabilities,AndroidMobileCapabilityType.ANDROID_DEVICE_SOCKET, ParetoApp.getAndroidConfig().android_androidDeviceSocket());
        setCapability(capabilities,AndroidMobileCapabilityType.AVD, ParetoApp.getAndroidConfig().android_avd());
        setCapability(capabilities,AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_avdLaunchTimeout());
        setCapability(capabilities,AndroidMobileCapabilityType.AVD_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_avdReadyTimeout());
        setCapability(capabilities,AndroidMobileCapabilityType.AVD_ARGS, ParetoApp.getAndroidConfig().android_avdArgs());
        setCapability(capabilities,AndroidMobileCapabilityType.USE_KEYSTORE, ParetoApp.getAndroidConfig().android_useKeystore());
        setCapability(capabilities,AndroidMobileCapabilityType.KEYSTORE_PATH, ParetoApp.getAndroidConfig().android_keystorePath());
        setCapability(capabilities,AndroidMobileCapabilityType.KEYSTORE_PASSWORD, ParetoApp.getAndroidConfig().android_keystorePassword());
        setCapability(capabilities,AndroidMobileCapabilityType.KEY_ALIAS, ParetoApp.getAndroidConfig().android_keyAlias());
        setCapability(capabilities,AndroidMobileCapabilityType.KEY_PASSWORD, ParetoApp.getAndroidConfig().android_keyPassword());
        setCapability(capabilities,AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, ParetoApp.getAndroidConfig().android_chromedriverExecutable());
        setCapability(capabilities,AndroidMobileCapabilityType.AUTO_WEBVIEW_TIMEOUT, ParetoApp.getAndroidConfig().android_autoWebviewTimeout());
        setCapability(capabilities,AndroidMobileCapabilityType.INTENT_ACTION, ParetoApp.getAndroidConfig().android_intentAction());
        setCapability(capabilities,AndroidMobileCapabilityType.INTENT_CATEGORY, ParetoApp.getAndroidConfig().android_intentCategory());
        setCapability(capabilities,AndroidMobileCapabilityType.INTENT_FLAGS, ParetoApp.getAndroidConfig().android_intentFlags());
        setCapability(capabilities,AndroidMobileCapabilityType.OPTIONAL_INTENT_ARGUMENTS, ParetoApp.getAndroidConfig().android_optionalIntentArguments());
        setCapability(capabilities,AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, ParetoApp.getAndroidConfig().android_dontStopAppOnReset());
        setCapability(capabilities,AndroidMobileCapabilityType.UNICODE_KEYBOARD, ParetoApp.getAndroidConfig().android_unicodeKeyboard());
        setCapability(capabilities,AndroidMobileCapabilityType.RESET_KEYBOARD, ParetoApp.getAndroidConfig().android_resetKeyboard());
        setCapability(capabilities,AndroidMobileCapabilityType.NO_SIGN, ParetoApp.getAndroidConfig().android_noSign());
        setCapability(capabilities,AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, ParetoApp.getAndroidConfig().android_ignoreUnimportantViews());
        setCapability(capabilities,AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, ParetoApp.getAndroidConfig().android_disableAndroidWatchers());
//        setCapability(capabilities,AndroidMobileCapabilityType.CHROME_OPTIONS, ParetoApp.getAndroidConfig().android_chromeOptions());
    }

    private void setCapability(DesiredCapabilities cap, String key, Object value){
        if(value!=null){
            cap.setCapability(key,value);
            paretoLogger.debug("Set "+key+" : "+value);
        }
    }
}
