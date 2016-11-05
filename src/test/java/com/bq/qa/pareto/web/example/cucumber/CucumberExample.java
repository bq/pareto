package com.bq.qa.pareto.web.example.cucumber;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.example.config.GithubConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features={"src/test/java/com/bq/qa/pareto/web/example/cucumber/features"})
public class CucumberExample {
    ParetoWeb<ChromeDriver,GithubConfig> paretoWeb;
    private ChromeDriver webDriver;


    @Before
    public  void beforeScenario() throws Exception {
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfig>getInstance(GithubConfig.class);

        paretoWeb.createLocalServer();
        paretoWeb.getLocalServer().startSeleniumServer();

        webDriver = paretoWeb.createDriver(ParetoWeb.BROWSER.CHROME);
        webDriver.manage().window().maximize();
    }

    @After
    public  void afterScenario() throws Exception {
        webDriver.quit();
        paretoWeb.getLocalServer().stopSeleniumServer();
    }
}
