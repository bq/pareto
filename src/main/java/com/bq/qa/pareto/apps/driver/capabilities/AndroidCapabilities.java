package com.bq.qa.pareto.apps.driver.capabilities;

import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {


    private DesiredCapabilities desiredCapabilities;
    private AndroidAppConfig androidAppConfig;


    /**
     * Gets the Android desired capabilities read from the properties file
     *
     * @return desired capabilities instance
     */
    public AndroidCapabilities(AndroidAppConfig androidAppConfig) {
        this.androidAppConfig = androidAppConfig;
        desiredCapabilities = new DesiredCapabilities();
        setUpAndroidCap(desiredCapabilities);
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    private void setUpAndroidCap(DesiredCapabilities capabilities) {
        setCapability(capabilities, MobileCapabilityType.PLATFORM_VERSION, androidAppConfig.appium_platformVersion());
        setCapability(capabilities, MobileCapabilityType.DEVICE_NAME, androidAppConfig.appium_deviceName());
        setCapability(capabilities, MobileCapabilityType.PLATFORM_NAME, androidAppConfig.appium_platformName());

        setCapability(capabilities, AndroidMobileCapabilityType.APP_ACTIVITY, androidAppConfig.android_appActivity());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_PACKAGE, androidAppConfig.android_appPackage());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, androidAppConfig.android_appWaitActivity());
        setCapability(capabilities, AndroidMobileCapabilityType.APP_WAIT_PACKAGE, androidAppConfig.android_appWaitPackage());
        setCapability(capabilities, AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, androidAppConfig.android_deviceReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_COVERAGE, androidAppConfig.android_androidCoverage());
        setCapability(capabilities, AndroidMobileCapabilityType.ENABLE_PERFORMANCE_LOGGING, androidAppConfig.android_enablePerformanceLogging());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, androidAppConfig.android_androidDeviceReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.ADB_PORT, androidAppConfig.android_adbPord());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_DEVICE_SOCKET, androidAppConfig.android_androidDeviceSocket());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, androidAppConfig.android_androidInstallTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD, androidAppConfig.android_avd());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, androidAppConfig.android_avdLaunchTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_READY_TIMEOUT, androidAppConfig.android_avdReadyTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.AVD_ARGS, androidAppConfig.android_avdArgs());
        setCapability(capabilities, AndroidMobileCapabilityType.USE_KEYSTORE, androidAppConfig.android_useKeystore());
        setCapability(capabilities, AndroidMobileCapabilityType.KEYSTORE_PATH, androidAppConfig.android_keystorePath());
        setCapability(capabilities, AndroidMobileCapabilityType.KEYSTORE_PASSWORD, androidAppConfig.android_keystorePassword());
        setCapability(capabilities, AndroidMobileCapabilityType.KEY_ALIAS, androidAppConfig.android_keyAlias());
        setCapability(capabilities, AndroidMobileCapabilityType.KEY_PASSWORD, androidAppConfig.android_keyPassword());
        setCapability(capabilities, AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, androidAppConfig.android_chromedriverExecutable());
        setCapability(capabilities, AndroidMobileCapabilityType.AUTO_WEBVIEW_TIMEOUT, androidAppConfig.android_autoWebviewTimeout());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_ACTION, androidAppConfig.android_intentAction());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_CATEGORY, androidAppConfig.android_intentCategory());
        setCapability(capabilities, AndroidMobileCapabilityType.INTENT_FLAGS, androidAppConfig.android_intentFlags());
        setCapability(capabilities, AndroidMobileCapabilityType.OPTIONAL_INTENT_ARGUMENTS, androidAppConfig.android_optionalIntentArguments());
        setCapability(capabilities, AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, androidAppConfig.android_dontStopAppOnReset());
        setCapability(capabilities, AndroidMobileCapabilityType.UNICODE_KEYBOARD, androidAppConfig.android_unicodeKeyboard());
        setCapability(capabilities, AndroidMobileCapabilityType.RESET_KEYBOARD, androidAppConfig.android_resetKeyboard());
        setCapability(capabilities, AndroidMobileCapabilityType.NO_SIGN, androidAppConfig.android_noSign());
        setCapability(capabilities, AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, androidAppConfig.android_ignoreUnimportantViews());
        setCapability(capabilities, AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, androidAppConfig.android_disableAndroidWatchers());
        setCapability(capabilities, AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, androidAppConfig.android_recreateChromeDriverSessions());
        setCapability(capabilities, AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, androidAppConfig.android_nativeWebScreenshot());
        setCapability(capabilities, AndroidMobileCapabilityType.ANDROID_SCREENSHOT_PATH, androidAppConfig.android_androidScreenshotPath());
        setCapability(capabilities, AndroidMobileCapabilityType.SELENDROID_PORT, androidAppConfig.android_selendroidPort());
    }

    private void setCapability(DesiredCapabilities cap, String key, Object value) {
        if (value != null) {
            cap.setCapability(key, value);
        }
    }



}
