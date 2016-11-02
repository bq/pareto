package com.bq.qa.pareto.apps.example.cucumber;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.config.ApiDemoConfig;
import com.bq.qa.pareto.apps.server.AppiumServer;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"})
public class CucumberExample {
    public static final String UDID_ANDROID = "default";
    ParetoApp<AndroidDriver,ApiDemoConfig> paretoApp;
    AppiumServer appiumServer;
    AndroidDriver androidDriver;


    @Before
    public  void beforeScenario() throws Exception {
        paretoApp = ParetoApp.<AndroidDriver>getInstance(ApiDemoConfig.class);
        appiumServer= paretoApp.createAppiumServer(UDID_ANDROID, ParetoApp.ANDROID);
        androidDriver = paretoApp.createDriver(appiumServer.getURL(),ParetoApp.ANDROID);
        androidDriver.resetApp();
    }

    @After
    public  void afterScenario() throws Exception {
        androidDriver.quit();
        appiumServer.stop();
    }
}
