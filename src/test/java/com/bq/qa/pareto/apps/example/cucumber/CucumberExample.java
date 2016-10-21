package com.bq.qa.pareto.apps.example.cucumber;

import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.server.AppiumServer;
import com.google.inject.Inject;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "pretty",
                "html:target/test/cucumber",
                "json:target/test/target_json/cucumber.json",
                "junit:target/test/taget_junit/cucumber.xml"})
public class CucumberExample {

    @Inject
    AppiumServer appiumServer;

    @Inject
    AndroidDriver androidDriver;

    @Before
    public  void beforeScenario() throws Exception {
        androidDriver.resetApp();
    }

    @After
    public  void afterScenario() throws Exception {
        appiumServer.stop();
    }
}
