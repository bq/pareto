package com.bq.qa.pareto.apps.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties",
        "classpath:IOSAppConfig.properties" })
public interface IOSAppConfig extends ParetoAppConfig{

    //BINARY
    @Config.DefaultValue("/var/tmp/pareto/bin/")
    @Config.Key("binary.path")
    String binary_path();

    //iOS
    @Config.Key("ios.calendarFormat")
    String ios_calendarFormat();

    @Config.Key("ios.bundleId")
    String ios_bundleId();

    @Config.Key("ios.launchTimeout")
    String ios_launchTimeout();

    @Config.Key("ios.locationServicesEnabled")
    Boolean ios_locationServicesEnabled();

    @Config.Key("ios.locationServicesAuthorized")
    Boolean ios_locationServicesAuthorized();

    @Config.DefaultValue("false")
    @Config.Key("ios.autoAcceptAlerts")
    Boolean ios_autoAcceptAlerts();

    @Config.DefaultValue("false")
    @Config.Key("ios.autoDismissAlerts")
    Boolean ios_autoDismissAlerts();

    @Config.Key("ios.nativeInstrumentsLib")
    Boolean ios_nativeInstrumentsLib();

    @Config.DefaultValue("false")
    @Config.Key("ios.nativeWebTap")
    Boolean ios_nativeWebTap();

    @Config.Key("ios.safariInitialUrl")
    String ios_safariInitialUrl();

    @Config.Key("ios.safariAllowPopups")
    Boolean ios_safariAllowPopups();

    @Config.Key("ios.safariIgnoreFraudWarning")
    Boolean ios_safariIgnoreFraudWarning();

    @Config.Key("ios.safariOpenLinksInBackground")
    Boolean ios_safariOpenLinksInBackground();

    @Config.Key("ios.keepKeyChains")
    Boolean ios_keepKeyChains();

    @Config.Key("ios.localizableStringsDir")
    String ios_localizableStringsDir();

    @Config.Key("ios.processArguments")
    String ios_processArguments();

    @Config.Key("ios.interKeyDelay")
    String ios_interKeyDelay();

    @Config.DefaultValue("false")
    @Config.Key("ios.showIOSLog")
    Boolean ios_showIOSLog();

    @Config.DefaultValue("setValue")
    @Config.Key("ios.sendKeyStrategy")
    String ios_sendKeyStrategy();

    @Config.DefaultValue("5")
    @Config.Key("ios.screenshotWaitTimeout")
    Integer ios_screenshotWaitTimeout();

    @Config.Key("ios.waitForAppScript")
    String ios_waitForAppScript();

    @Config.Key("ios.webviewConnectRetries")
    Integer ios_webviewConnectRetries();


    @Config.DefaultValue("false")
    @Config.Key("ios.emulator")
    Boolean ios_emulator();

    @Config.DefaultValue("ios")
    @Key("appium.platformName")
    String appium_platformName();

    @Key("appium.platformVersion")
    String appium_platformVersion();

    @Key("appium.deviceName")
    String appium_deviceName();


}
