package com.bq.qa.pareto.apps.example.cucumber.steps;

import com.bq.qa.pareto.apps.example.pages.HomePage;
import cucumber.api.java.en.Given;

import javax.inject.Inject;


public class StepsDef1 {
    private HomePage homePage;


    @Inject
    public StepsDef1(HomePage homePage){
        this.homePage = homePage;
    }

    @Given("^Access to Animation Menu$")
    public void launch_app(){
        homePage.accessToAnimation();
    }

}
