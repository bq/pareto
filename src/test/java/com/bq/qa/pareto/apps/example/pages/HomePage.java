package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.config.ApiDemoConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage {
    private AndroidDriver androidDriver;


    @WithTimeout(time = 22,unit = TimeUnit.SECONDS)
    @AndroidFindBy(id="android:id/text1")
    List<MobileElement> menuList;

    public HomePage(ParetoApp<AndroidDriver,ApiDemoConfig> paretoApp) {
        androidDriver = paretoApp.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, paretoApp.getConfig().driver_timeout(), TimeUnit.SECONDS),this);
    }

    public void accessToAnimation(){
        menuList.get(1).click();
    }

}
