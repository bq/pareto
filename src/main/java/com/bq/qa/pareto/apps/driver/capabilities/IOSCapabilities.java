package com.bq.qa.pareto.apps.driver.capabilities;

import com.bq.qa.pareto.apps.config.IOSAppConfig;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSCapabilities {

    private DesiredCapabilities iosDesiredCapabilities;
    private IOSAppConfig iosAppConfig;


    /**
     * Gets the iOS desired capabilities from the properties file
     *
     * @return a DesiredCapabilities instance.
     */
    public IOSCapabilities(IOSAppConfig iosAppConfig) {
        this.iosAppConfig = iosAppConfig;
        iosDesiredCapabilities = new DesiredCapabilities();
        setUpIOSCap(iosDesiredCapabilities);
    }

    private void setUpIOSCap(DesiredCapabilities capabilities) {
        setCapability(capabilities, MobileCapabilityType.PLATFORM_VERSION, iosAppConfig.appium_platformVersion());
        setCapability(capabilities, MobileCapabilityType.DEVICE_NAME, iosAppConfig.appium_deviceName());
        setCapability(capabilities, MobileCapabilityType.PLATFORM_NAME, iosAppConfig.appium_platformName());

        setCapability(capabilities, IOSMobileCapabilityType.CALENDAR_FORMAT, iosAppConfig.ios_calendarFormat());
        setCapability(capabilities, IOSMobileCapabilityType.BUNDLE_ID, iosAppConfig.ios_bundleId());
        setCapability(capabilities, IOSMobileCapabilityType.LAUNCH_TIMEOUT, iosAppConfig.ios_launchTimeout());
        setCapability(capabilities, IOSMobileCapabilityType.LOCATION_SERVICES_ENABLED, iosAppConfig.ios_locationServicesEnabled());
        setCapability(capabilities, IOSMobileCapabilityType.LOCATION_SERVICES_AUTHORIZED, iosAppConfig.ios_locationServicesAuthorized());
        setCapability(capabilities, IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, iosAppConfig.ios_autoAcceptAlerts());
        setCapability(capabilities, IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, iosAppConfig.ios_autoDismissAlerts());
        setCapability(capabilities, IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB, iosAppConfig.ios_nativeInstrumentsLib());
        setCapability(capabilities, IOSMobileCapabilityType.NATIVE_WEB_TAP, iosAppConfig.ios_nativeWebTap());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_INITIAL_URL, iosAppConfig.ios_safariInitialUrl());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_ALLOW_POPUPS, iosAppConfig.ios_safariAllowPopups());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_IGNORE_FRAUD_WARNING, iosAppConfig.ios_safariIgnoreFraudWarning());
        setCapability(capabilities, IOSMobileCapabilityType.SAFARI_OPEN_LINKS_IN_BACKGROUND, iosAppConfig.ios_safariOpenLinksInBackground());
        setCapability(capabilities, IOSMobileCapabilityType.KEEP_KEY_CHAINS, iosAppConfig.ios_keepKeyChains());
        setCapability(capabilities, IOSMobileCapabilityType.LOCALIZABLE_STRINGS_DIR, iosAppConfig.ios_localizableStringsDir());
        setCapability(capabilities, IOSMobileCapabilityType.PROCESS_ARGUMENTS, iosAppConfig.ios_processArguments());
        setCapability(capabilities, IOSMobileCapabilityType.SHOW_IOS_LOG, iosAppConfig.ios_showIOSLog());
        setCapability(capabilities, IOSMobileCapabilityType.SEND_KEY_STRATEGY, iosAppConfig.ios_sendKeyStrategy());
        setCapability(capabilities, IOSMobileCapabilityType.SCREENSHOT_WAIT_TIMEOUT, iosAppConfig.ios_screenshotWaitTimeout());
        setCapability(capabilities, IOSMobileCapabilityType.WAIT_FOR_APP_SCRIPT, iosAppConfig.ios_waitForAppScript());
        setCapability(capabilities, IOSMobileCapabilityType.WEBVIEW_CONNECT_RETRIES, iosAppConfig.ios_webviewConnectRetries());
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
