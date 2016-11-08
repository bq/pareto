package com.bq.qa.pareto.web.util;

import com.bq.qa.pareto.web.driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Page<D extends BrowserDriver> {

    protected WebDriver webDriver;

    public Page(){}

    public Page(D webDriver){
        this.webDriver=webDriver;
    }

    public void decorate(Object page){
        PageFactory.initElements(webDriver,page);

    }
}
