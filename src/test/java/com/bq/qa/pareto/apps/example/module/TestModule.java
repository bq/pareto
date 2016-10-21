package com.bq.qa.pareto.apps.example.module;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.server.AppiumServer;
import com.bq.qa.pareto.apps.server.ServerFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;


public class TestModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    public AppiumServer providesAndroidAppiumServer(ParetoApp paretoApp){
        return paretoApp.getAppiumServer(ParetoApp.getAndroidConfig().devices_udid().get(0), ServerFactory.ANDROID);
    }

    @Provides
    @Singleton
    public AndroidDriver providesAndroidDriver(AppiumServer appiumServer, ParetoApp paretoApp){
        return paretoApp.getAndroidDriver(appiumServer.getURL());
    }


}
