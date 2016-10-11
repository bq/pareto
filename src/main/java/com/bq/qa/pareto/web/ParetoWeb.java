package com.bq.qa.pareto.web;

import com.bq.qa.pareto.web.config.ParetoWebConfig;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.driver.DriverFactory;
import com.bq.qa.pareto.web.driver.FirefoxDriver;
import com.bq.qa.pareto.web.driver.SafariDriver;
import com.bq.qa.pareto.web.server.SeleniumServerManager;
import org.aeonbits.owner.ConfigFactory;

public class ParetoWeb {

    private SeleniumServerManager seleniumServerManager;
    private DriverFactory driverFactory;

    private static final ParetoWebConfig CFG = ConfigFactory.create(ParetoWebConfig.class);

    public static ParetoWebConfig getConfig(){
        return CFG;
    }

    public ParetoWeb(){
        driverFactory= new DriverFactory();
    }



    public SeleniumServerManager getServer(){
        seleniumServerManager = new SeleniumServerManager(getConfig().selenium_port());
        return seleniumServerManager;
    }

    public SeleniumServerManager getServer(int port){
        seleniumServerManager = new SeleniumServerManager(port);
        return seleniumServerManager;
    }



    public ChromeDriver getChromeDriver(){
        return (ChromeDriver) driverFactory.createDriver(DriverFactory.BROWSER.CHROME,getConfig().selenium_endpoint());
    }

    public FirefoxDriver getFirefoxDriver(){
        return (FirefoxDriver) driverFactory.createDriver(DriverFactory.BROWSER.FIREFOX,getConfig().selenium_endpoint());
    }

    public SafariDriver getSafariDriver(){
        return (SafariDriver) driverFactory.createDriver(DriverFactory.BROWSER.SAFARI,getConfig().selenium_endpoint());
    }


    public ChromeDriver getChromeDriver(String url){
        return (ChromeDriver) driverFactory.createDriver(DriverFactory.BROWSER.CHROME,url);
    }

    public FirefoxDriver getFirefoxDriver(String url){
        return (FirefoxDriver) driverFactory.createDriver(DriverFactory.BROWSER.FIREFOX,url);
    }

    public SafariDriver getSafariDriver(String url){
        return (SafariDriver) driverFactory.createDriver(DriverFactory.BROWSER.SAFARI,url);
    }



}
