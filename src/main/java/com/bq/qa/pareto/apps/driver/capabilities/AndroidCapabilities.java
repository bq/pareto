package com.bq.qa.pareto.apps.driver.capabilities;

import com.bq.qa.pareto.apps.ParetoApp;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {


    private DesiredCapabilities desiredCapabilities;


    /**
     * Gets the Android desired capabilities read from the properties file
     *
     * @return desired capabilities instance
     */
    public AndroidCapabilities() {
        desiredCapabilities = new DesiredCapabilities();
        setUpAndroidCap(desiredCapabilities);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    private void setUpAndroidCap(DesiredCapabilities capabilities) {
        setCapability(capabilities, MobileCapabilityType.PLATFORM_VERSION, ParetoApp.getAndroidConfig().appium_platformVersion());
        setCapability(capabilities, MobileCapabilityType.DEVICE_NAME, ParetoApp.getAndroidConfig().appium_deviceName());
        setCapability(capabilities, MobileCapabilityType.PLATFORM_NAME, ParetoApp.getAndroidConfig().appium_platformName());

        setCapability(capabilities, AndroidMobileCapabilityType.APP_ACTIVITY, ParetoApp.getAndroidConfig().android_appActivity());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_PACKAGE, ParetoApp.getAndroidConfig().android_appPackage());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ParetoApp.getAndroidConfig().android_appWaitActivity());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_WAIT_PACKAGE, ParetoApp.getAndroidConfig().android_appWaitPackage());
        setCapability(capabilities, AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_deviceReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_COVERAGE, ParetoApp.getAndroidConfig().android_androidCoverage());
        setCapability(capabilities, AndroidMobileCapabilityType.ENABLE_PERFORMANCE_LOGGING, ParetoApp.getAndroidConfig().android_enablePerformanceLogging());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_androidDeviceReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.ADB_PORT, ParetoApp.getAndroidConfig().android_adbPord());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_DEVICE_SOCKET, ParetoApp.getAndroidConfig().android_androidDeviceSocket());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, ParetoApp.getAndroidConfig().android_androidInstallTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD, ParetoApp.getAndroidConfig().android_avd());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, ParetoApp.getAndroidConfig().android_avdLaunchTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_READY_TIMEOUT, ParetoApp.getAndroidConfig().android_avdReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_ARGS, ParetoApp.getAndroidConfig().android_avdArgs());
        setCapability(capabilities, AndroidMobileCapabilityType.USE_KEYSTORE, ParetoApp.getAndroidConfig().android_useKeystore());
        setCapability(capabilities, AndroidMobileCapabilityType.KEYSTORE_PATH, ParetoApp.getAndroidConfig().android_keystorePath());
        setCapability(capabilities, AndroidMobileCapabilityType.KEYSTORE_PASSWORD, ParetoApp.getAndroidConfig().android_keystorePassword());
        setCapability(capabilities, AndroidMobileCapabilityType.KEY_ALIAS, ParetoApp.getAndroidConfig().android_keyAlias());
        setCapability(capabilities, AndroidMobileCapabilityType.KEY_PASSWORD, ParetoApp.getAndroidConfig().android_keyPassword());
        setCapability(capabilities, AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, ParetoApp.getAndroidConfig().android_chromedriverExecutable());
        setCapability(capabilities, AndroidMobileCapabilityType.AUTO_WEBVIEW_TIMEOUT, ParetoApp.getAndroidConfig().android_autoWebviewTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_ACTION, ParetoApp.getAndroidConfig().android_intentAction());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_CATEGORY, ParetoApp.getAndroidConfig().android_intentCategory());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_FLAGS, ParetoApp.getAndroidConfig().android_intentFlags());
        setCapability(capabilities, AndroidMobileCapabilityType.OPTIONAL_INTENT_ARGUMENTS, ParetoApp.getAndroidConfig().android_optionalIntentArguments());
        setCapability(capabilities, AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, ParetoApp.getAndroidConfig().android_dontStopAppOnReset());
        setCapability(capabilities, AndroidMobileCapabilityType.UNICODE_KEYBOARD, ParetoApp.getAndroidConfig().android_unicodeKeyboard());
        setCapability(capabilities, AndroidMobileCapabilityType.RESET_KEYBOARD, ParetoApp.getAndroidConfig().android_resetKeyboard());
        setCapability(capabilities, AndroidMobileCapabilityType.NO_SIGN, ParetoApp.getAndroidConfig().android_noSign());
        setCapability(capabilities, AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, ParetoApp.getAndroidConfig().android_ignoreUnimportantViews());
        setCapability(capabilities, AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, ParetoApp.getAndroidConfig().android_disableAndroidWatchers());
        setCapability(capabilities, AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, ParetoApp.getAndroidConfig().android_recreateChromeDriverSessions());
        setCapability(capabilities, AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, ParetoApp.getAndroidConfig().android_nativeWebScreenshot());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_SCREENSHOT_PATH, ParetoApp.getAndroidConfig().android_androidScreenshotPath());
        setCapability(capabilities, AndroidMobileCapabilityType.SELENDROID_PORT, ParetoApp.getAndroidConfig().android_selendroidPort());
    }

    private void setCapability(DesiredCapabilities cap, String key, Object value) {
        if (value != null) {
            cap.setCapability(key, value);
        }
    }



}
