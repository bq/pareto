package com.bq.qa.pareto.web.capabilities;

import com.bq.qa.pareto.web.config.ParetoWebConfig;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Copyright 2016 (C) BQ
 */
public class ChromeCapabilities {


    private final DesiredCapabilities desiredCapabilities;
    private ParetoWebConfig paretoWebConfig;

    /**
     * Gets the Chrome browser capabilities
     *
     * @return instance of desired capabilities
     */
    public ChromeCapabilities(ParetoWebConfig paretoWebConfig) {
        this.paretoWebConfig = paretoWebConfig;
        ChromeDriverManager.getInstance().setup(paretoWebConfig.chromedriver_version());
        desiredCapabilities = DesiredCapabilities.chrome();
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }
}
