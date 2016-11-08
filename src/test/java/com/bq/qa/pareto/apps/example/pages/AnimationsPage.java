package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.example.config.ApiDemoConfig;
import com.bq.qa.pareto.apps.util.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AnimationsPage extends Page<AndroidDriver> {

    public static final String TMP = "/tmp/screenshot.png";
    private AndroidDriver androidDriver;

    @AndroidFindBy(id="android:id/text1")
    List<WebElement> menuListAnimations;

    public AnimationsPage(ParetoApp<AndroidDriver,ApiDemoConfig> paretoApp) {
        super(paretoApp.getDriver());
        decorate(this);

    }

    public void accessToBouncingBalls(){
        menuListAnimations.get(0).click();
    }

    public void bounceBall(){
        driver.tapOnCenter();
        driver.getScreenshot(TMP);
    }

}
