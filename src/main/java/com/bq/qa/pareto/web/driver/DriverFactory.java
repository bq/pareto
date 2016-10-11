package com.bq.qa.pareto.web.driver;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.util.ParetoWebLogger;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private final Logger paretoLogger = ParetoWebLogger.getLogger();
    public enum BROWSER{CHROME,FIREFOX,SAFARI}

    /**
     * Constructor
     */
    public DriverFactory() {
    }

    /**
     * Creates an app driver whose typology is received as argument
     *
     * @param browser browser driver type
     * @return app driver
     */
    public BrowserDriver createDriver(BROWSER browser,String endpoint) {
        BrowserDriver driver = null;

        switch (browser) {
            case CHROME:
                driver = buildChromeDriver(validateURL(endpoint));
                break;
            case FIREFOX:
                driver = buildFirefoxDriver(validateURL(endpoint));
                break;
            case SAFARI:
                driver = buildSafariDriver(validateURL(endpoint));
                break;
        }
        driver.manage().timeouts().implicitlyWait(ParetoWeb.getConfig().driver_timeout(), TimeUnit.SECONDS);
        paretoLogger.debug("The driver has been created successfully.");
        return driver;
    }

    /**
     * Builds a Firefox browser driver
     *
     * @return instance of the browser driver
     */
    private FirefoxDriver buildFirefoxDriver(URL endpoint) {
        DesiredCapabilities desiredCapabilities = getFirefoxCapabilities();
        return new FirefoxDriver(endpoint, desiredCapabilities);
    }

    /**
     * Builds a Chrome browser driver
     *
     * @return instance of the browser driver
     */
    private ChromeDriver buildChromeDriver(URL endpoint) {

        DesiredCapabilities desiredCapabilities = getChromeCapabilities();

        ChromeDriver chromeDriver = new ChromeDriver(endpoint, desiredCapabilities);
        return chromeDriver;
    }


    /**
     * Builds a Safari browser driver
     *
     * @return instance of the browser driver
     */
    private SafariDriver buildSafariDriver(URL endpoint) {

        DesiredCapabilities desiredCapabilities = getSafariCapabilities();
        SafariDriver safariDriver = new SafariDriver(endpoint, desiredCapabilities);
        return safariDriver;
    }


    /**
     * Gets the Chrome browser capabilities
     *
     * @return instance of desired capabilities
     */
    private DesiredCapabilities getChromeCapabilities() {
        paretoLogger.debug("Getting a chrome capabilites");
        ChromeDriverManager.getInstance().setup(ParetoWeb.getConfig().chromedriver_version());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return capabilities;
    }

    /**
     * Gets the Firefox browser capabilities
     *
     * @return instance of desired capabilities
     */
    private DesiredCapabilities getFirefoxCapabilities() {
        paretoLogger.debug("Getting a firefox capabilites");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        return capabilities;
    }

    /**
     * Gets the Safari browser capabilities
     *
     * @return instance of desired capabilities
     */
    private DesiredCapabilities getSafariCapabilities() {
        paretoLogger.debug("Getting a safari capabilites");
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        return capabilities;
    }

    /**
     * Checks the validity of an URL
     *
     * @param endpoint end point
     * @return the URL if it is a valid URL. Otherwise, throws an exception
     */
    private URL validateURL(String endpoint) {
        try {
            return new URL(endpoint);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
