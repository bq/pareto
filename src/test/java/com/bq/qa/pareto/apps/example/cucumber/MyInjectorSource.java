package com.bq.qa.pareto.apps.example.cucumber;

import com.bq.qa.pareto.apps.example.module.TestModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;


public class MyInjectorSource implements InjectorSource {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new TestModule());
    }
}
