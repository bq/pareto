package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.config.ApiDemoConfig;
import com.bq.qa.pareto.apps.util.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends Page{


    @WithTimeout(time = 22,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id="android:id/text1")
    List<MobileElement> menuList;

    public HomePage(ParetoApp<AndroidDriver,ApiDemoConfig> paretoApp) {
        super(paretoApp.getDriver());
        decorate(this);
    }

    public void accessToAnimation(){
        menuList.get(1).click();
    }

}
