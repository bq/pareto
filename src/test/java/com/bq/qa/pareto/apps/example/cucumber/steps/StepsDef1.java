package com.bq.qa.pareto.apps.example.cucumber.steps;

import com.bq.qa.pareto.apps.example.di.Injector;
import com.bq.qa.pareto.apps.example.pages.HomePage;
import cucumber.api.java.en.Given;


public class StepsDef1 {

    private HomePage homePage;

    public StepsDef1(){
        this.homePage = new HomePage(Injector.paretoApp());
    }

    @Given("^Access to Animation Menu$")
    public void launch_app(){
        homePage.accessToAnimation();
    }

}
