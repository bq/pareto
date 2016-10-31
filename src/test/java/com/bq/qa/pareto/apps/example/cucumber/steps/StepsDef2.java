package com.bq.qa.pareto.apps.example.cucumber.steps;

import com.bq.qa.pareto.apps.example.di.Injector;
import com.bq.qa.pareto.apps.example.pages.AnimationsPage;
import cucumber.api.java.en.Then;


public class StepsDef2 {


    private final AnimationsPage animationsPage;


    public StepsDef2() {
        this.animationsPage = new AnimationsPage(Injector.paretoApp());
    }

    @Then("^Bounce ball$")
    public void launch_app() {
        animationsPage.accessToBouncingBalls();
        animationsPage.bounceBall();
    }
}
