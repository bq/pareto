package com.bq.qa.pareto.web.capabilities;

import com.bq.qa.pareto.web.ParetoWeb;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Copyright 2016 (C) BQ
 */
public class ChromeCapabilities {


    private final DesiredCapabilities desiredCapabilities;

    /**
     * Gets the Chrome browser capabilities
     *
     * @return instance of desired capabilities
     */
    public ChromeCapabilities() {
        ChromeDriverManager.getInstance().setup(ParetoWeb.getConfig().chromedriver_version());
        desiredCapabilities = DesiredCapabilities.chrome();
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }
}
