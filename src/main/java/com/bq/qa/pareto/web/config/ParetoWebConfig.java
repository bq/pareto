package com.bq.qa.pareto.web.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties",
        "classpath:ParetoWebConfig.properties" })

public interface ParetoWebConfig extends Config{
    //SELENIUM
    @Config.DefaultValue("http://localhost:4444/wd/hub")
    @Config.Key("selenium.endpoint")
    String selenium_endpoint();

    @Config.DefaultValue("4444")
    @Config.Key("selenium.port")
    int selenium_port();

    //CHROMEDRIVER
    @DefaultValue("2.25")
    @Config.Key("chromedriver.version")
    String chromedriver_version();

    //LOGGER
    @DefaultValue("DEBUG")
    @Key("logger.level")
    String logger_level();

    //DRIVER
    @DefaultValue("5")
    @Key("driver.timeout")
    int driver_timeout();

    //DRIVER
    @Config.DefaultValue("http://www.github.com")
    @Key("driver.endpoint")
    String driver_endpoint();



}
