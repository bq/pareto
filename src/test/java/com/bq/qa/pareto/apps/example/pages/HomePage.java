package com.bq.qa.pareto.apps.example.pages;

import com.bq.qa.pareto.apps.ParetoApp;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.google.inject.Inject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage {


    @AndroidFindBy(id="android:id/text1")
    List<MobileElement> menuList;

    @Inject
    @Singleton
    public HomePage(AndroidDriver androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, ParetoApp.getAndroidConfig().driver_timeout(), TimeUnit.SECONDS),this);
    }

    public void accessToAnimation(){
        menuList.get(1).click();
    }
}
