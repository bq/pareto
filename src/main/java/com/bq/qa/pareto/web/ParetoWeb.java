package com.bq.qa.pareto.web;

import com.bq.qa.pareto.web.capabilities.ChromeCapabilities;
import com.bq.qa.pareto.web.config.ParetoWebConfig;
import com.bq.qa.pareto.web.driver.BrowserDriver;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.driver.FirefoxDriver;
import com.bq.qa.pareto.web.driver.SafariDriver;
import com.bq.qa.pareto.web.server.SeleniumServerManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ParetoWeb<D extends BrowserDriver> {

    private static ParetoWeb paretoWeb;
    private SeleniumServerManager seleniumServerManager;

    public enum BROWSER {CHROME, FIREFOX, SAFARI}

    private static final ParetoWebConfig CFG = ConfigFactory.create(ParetoWebConfig.class);

    public static ParetoWebConfig getConfig() {
        return CFG;
    }

    public D driver;


    public static ParetoWeb getInstance(){
        if(paretoWeb==null)
            paretoWeb = new ParetoWeb<>();
        return paretoWeb;
    }


    public SeleniumServerManager getLocalServer(){
        return seleniumServerManager;
    }

    public SeleniumServerManager createLocalServer() {
        seleniumServerManager = new SeleniumServerManager(getConfig().selenium_port());
        return seleniumServerManager;
    }

    public SeleniumServerManager createLocalServer(int port) {
        seleniumServerManager = new SeleniumServerManager(port);
        return seleniumServerManager;
    }

    public D getDriver(){
        return driver;
    }

    public D createDriver(BROWSER browser) {
        String remoteAddress = getConfig().selenium_endpoint();
        driver =createDriver(browser,remoteAddress);
        return driver;
    }

    public D createDriver(BROWSER browser,String url) {
        try {
            URL remoteAddress = new URL(url);
            switch (browser) {
                case CHROME:
                    driver = (D) new ChromeDriver(remoteAddress, new ChromeCapabilities().getDesiredCapabilities());
                    break;
                case FIREFOX:
                    driver = (D) new FirefoxDriver(remoteAddress, DesiredCapabilities.firefox());
                    break;
                case SAFARI:
                    driver = (D) new SafariDriver(remoteAddress, DesiredCapabilities.safari());
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
