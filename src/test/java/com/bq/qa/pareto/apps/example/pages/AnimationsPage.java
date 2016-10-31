package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AnimationsPage {

    public static final String TMP = "/tmp/screenshot.png";
    private AndroidDriver androidDriver;


    @AndroidFindBy(id="android:id/text1")
    List<WebElement> menuListAnimations;

    public AnimationsPage(ParetoApp<AndroidDriver> paretoApp) {
        androidDriver = paretoApp.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, paretoApp.getAndroidConfig().driver_timeout(), TimeUnit.SECONDS),this);
    }

    public void accessToBouncingBalls(){
        menuListAnimations.get(0).click();
    }

    public void bounceBall(){
        androidDriver.tapOnCenter();
        androidDriver.getScreenshot(TMP);
    }

}
