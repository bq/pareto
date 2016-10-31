package com.bq.qa.pareto.apps.driver.capabilities;

import com.bq.qa.pareto.apps.ParetoApp;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSCapabilities {

    private DesiredCapabilities iosDesiredCapabilities;


    /**
     * Gets the iOS desired capabilities from the properties file
     *
     * @return a DesiredCapabilities instance.
     */
    public IOSCapabilities() {
        iosDesiredCapabilities = new DesiredCapabilities();
        setUpIOSCap(iosDesiredCapabilities);
    }

    private void setUpIOSCap(DesiredCapabilities capabilities) {
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

    private void setCapability(DesiredCapabilities cap, String key, Object value) {
        if (value != null) {
            cap.setCapability(key, value);
        }
    }

    public DesiredCapabilities getIosDesiredCapabilities() {
        return iosDesiredCapabilities;
    }
}
