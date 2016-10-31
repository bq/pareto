package com.bq.qa.pareto.apps.example.cucumber;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.di.Injector;
import com.bq.qa.pareto.apps.server.AppiumServer;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import static com.bq.qa.pareto.apps.ParetoAppTest.UDID_ANDROID;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "pretty",
                "html:target/test/cucumber",
                "json:target/test/target_json/cucumber.json",
                "junit:target/test/taget_junit/cucumber.xml"})
public class CucumberExample {

    ParetoApp paretoApp;
    AppiumServer appiumServer;
    AndroidDriver androidDriver;


    @Before
    public  void beforeScenario() throws Exception {
        paretoApp = Injector.paretoApp();

        appiumServer= paretoApp.createAppiumServer(UDID_ANDROID, ParetoApp.ANDROID);
        androidDriver = (AndroidDriver) paretoApp.createDriver(appiumServer.getURL(),ParetoApp.ANDROID);

        androidDriver.resetApp();
    }

    @After
    public  void afterScenario() throws Exception {
        androidDriver.close();
        appiumServer.stop();
    }
}
