package com.bq.qa.pareto.apps.example.cucumber.steps;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.config.ApiDemoConfig;
import com.bq.qa.pareto.apps.example.pages.HomePage;
import cucumber.api.java.en.Given;


public class StepsDef1 {

    private HomePage homePage;

    public StepsDef1(){
        this.homePage = new HomePage(ParetoApp.<AndroidDriver>getInstance(ApiDemoConfig.class));
    }

    @Given("^Access to Animation Menu$")
    public void launch_app(){
        homePage.accessToAnimation();
    }

}
