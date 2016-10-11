package com.bq.qa.pareto.web.driver;

import org.openqa.selenium.Capabilities;

import java.net.URL;

public class ChromeDriver extends BrowserDriver{

    /**
     * Constructor
     *
     * @param remoteAddress       remote address
     * @param desiredCapabilities desired capabilities
     */
    public ChromeDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
    }


}