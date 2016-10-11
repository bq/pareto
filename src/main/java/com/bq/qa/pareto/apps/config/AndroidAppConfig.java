package com.bq.qa.pareto.apps.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties",
        "classpath:AndroidAppConfig.properties" })
public interface AndroidAppConfig extends ParetoAppConfig{

    ////////////
    //ANDROID//
    ///////////
    @Config.DefaultValue("false")
    @Config.Key("android.startEmulator")
    Boolean android_startEmulator();

    @Config.Key("android.emulatorname")
    String android_emulatorname();

    @Config.DefaultValue("5680")
    @Config.Key("android.emulatorport")
    String android_emulatorport();

    ////////////////
    @Config.Key("android.appActivity")
    String android_appActivity();

    @Config.Key("android.appPackage")
    String android_appPackage();

    @Config.Key("android.appWaitActivity")
    String android_appWaitActivity();

    @Config.Key("android.appWaitPackage")
    String android_appWaitPackage();

    @Config.DefaultValue("5")
    @Config.Key("android.deviceReadyTimeout")
    String android_deviceReadyTimeout();

    @Config.Key("android.androidCoverage")
    String android_androidCoverage();

    @Config.DefaultValue("false")
    @Config.Key("android.enablePerformanceLogging")
    Boolean android_enablePerformanceLogging();

    @Config.DefaultValue("30")
    @Config.Key("android.androidDeviceReadyTimeout")
    String android_androidDeviceReadyTimeout();

    @Config.Key("android.androidDeviceSocket")
    String android_androidDeviceSocket();

    @Config.Key("android.avd")
    String android_avd();

    @Config.DefaultValue("120000")
    @Config.Key("android.avdLaunchTimeout")
    String android_avdLaunchTimeout();

    @Config.DefaultValue("120000")
    @Config.Key("android.avdReadyTimeout")
    String android_avdReadyTimeout();

    @Config.Key("android.avdArgs")
    String android_avdArgs();

    @Config.DefaultValue("false")
    @Config.Key("android.useKeystore")
    Boolean android_useKeystore();

    @Config.Key("android.keystorePath")
    String android_keystorePath();

    @Config.Key("android.keystorePassword")
    String android_keystorePassword();

    @Config.Key("android.keyAlias")
    String android_keyAlias();

    @Config.Key("android.keyPassword")
    String android_keyPassword();

    @Config.Key("android.chromedriverExecutable")
    String android_chromedriverExecutable();


    @Config.DefaultValue("2000")
    @Config.Key("android.autoWebviewTimeout")
    String android_autoWebviewTimeout();

    @Config.DefaultValue("android.intent.action.MAIN")
    @Config.Key("android.intentAction")
    String android_intentAction();

    @Config.DefaultValue("android.intent.category.LAUNCHER")
    @Config.Key("android.intentCategory")
    String android_intentCategory();

    @Config.Key("android.intentFlags")
    String android_intentFlags();

    @Config.Key("android.optionalIntentArguments")
    String android_optionalIntentArguments();

    @Config.Key("android.dontStopAppOnReset")
    String android_dontStopAppOnReset();

    @Config.DefaultValue("false")
    @Config.Key("android.unicodeKeyboard")
    Boolean android_unicodeKeyboard();

    @Config.DefaultValue("false")
    @Config.Key("android.resetKeyboard")
    Boolean android_resetKeyboard();

    @Config.DefaultValue("false")
    @Config.Key("android.noSign")
    Boolean android_noSign();

    @Config.DefaultValue("false")
    @Config.Key("android.ignoreUnimportantViews")
    Boolean android_ignoreUnimportantViews();

    @Config.DefaultValue("false")
    @Config.Key("android.disableAndroidWatchers")
    Boolean android_disableAndroidWatchers();

    @Config.DefaultValue("{}")
    @Config.Key("android.chromeOptions")
    String android_chromeOptions();

    @Config.DefaultValue("android")
    @Key("appium.platformName")
    String appium_platformName();

    @DefaultValue("5.0")
    @Key("appium.platformVersion")
    String appium_platformVersion();

    @DefaultValue("E5")
    @Key("appium.deviceName")
    String appium_deviceName();
}
