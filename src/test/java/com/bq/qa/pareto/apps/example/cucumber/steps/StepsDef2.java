package com.bq.qa.pareto.apps.example.cucumber.steps;

import com.bq.qa.pareto.apps.example.pages.AnimationsPage;
import cucumber.api.java.en.Then;

import javax.inject.Inject;


public class StepsDef2 {

    private AnimationsPage animationsPage;


    @Inject
    public StepsDef2(AnimationsPage animationsPage){
        this.animationsPage = animationsPage;
    }

    @Then("^Bounce ball$")
    public void launch_app(){
        animationsPage.accessToBouncingBalls();
        animationsPage.bounceBall();
    }
}
