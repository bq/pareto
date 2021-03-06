package com.bq.qa.pareto.apps.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Page<D extends AppiumDriver> {
    protected D driver;

    public Page(D appiumDriver){
        this.driver=appiumDriver;
    }

    public void decorate(Object page){
        PageFactory.initElements(new AppiumFieldDecorator(driver),page);
    }
}
