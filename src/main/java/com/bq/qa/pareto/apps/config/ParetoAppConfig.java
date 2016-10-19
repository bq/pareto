package com.bq.qa.pareto.apps.config;

import org.aeonbits.owner.Config;

import java.util.ArrayList;


//Appium Server Capabilities
//https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface ParetoAppConfig extends Config {

    //BINARY
    @Config.DefaultValue("/var/tmp/pareto/bin/")
    @Config.Key("binary.path")
    String binary_path();

    //DEVICES
    @Config.Key("devices.udid")
    ArrayList<String> devices_udid();

    //APPIUM
    @DefaultValue("Appium")
    @Key("appium.automationName")
    String appium_automationName();


    @Key("appium.browserName")
    String appium_browserName();

    @DefaultValue("60")
    @Key("appium.newCommandTimeout")
    String appium_newCommandTimeout();

    @DefaultValue("true")
    @Key("appium.autoLaunch")
    Boolean appium_autoLaunch();

    @Key("appium.language")
    String appium_language();

    @Key("appium.locale")
    String appium_locale();

    @DefaultValue("PORTRAIT")
    @Key("appium.orientation")
    String appium_orientation();

    @DefaultValue("false")
    @Key("appium.autoWebview")
    Boolean appium_autoWebview();

    @DefaultValue("false")
    @Key("appium.noReset")
    Boolean appium_noReset();

    @DefaultValue("false")
    @Key("appium.fullReset")
    Boolean appium_fullReset();

    //PARETO CONFIG
    @DefaultValue("/usr/local/bin/appium")
    @Key("appium.bin")
    String appium_bin();

    @DefaultValue("127.0.0.1")
    @Key("appium.ip")
    String appium_ip();

    @DefaultValue("")
    @Key("appium.options")
    String appium_options();


    @DefaultValue("info")
    @Key("appium.logLevel")
    String appium_log_level();

    //DRIVER
    @DefaultValue("20")
    @Key("driver.timeout")
    Integer driver_timeout();

    //LOGGER
    @DefaultValue("DEBUG")
    @Key("logger.level")
    String logger_level();
}
