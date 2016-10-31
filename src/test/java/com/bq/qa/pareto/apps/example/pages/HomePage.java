package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage {


    private AndroidDriver androidDriver;

    @AndroidFindBy(id="android:id/text1")
    List<MobileElement> menuList;

    public HomePage(ParetoApp<AndroidDriver> paretoApp) {
        androidDriver = paretoApp.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, paretoApp.getAndroidConfig().driver_timeout(), TimeUnit.SECONDS),this);
    }


    public void accessToAnimation(){
        menuList.get(1).click();
    }
}
