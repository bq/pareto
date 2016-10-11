package com.bq.qa.pareto.web.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Page {

    protected WebDriver webDriver;

    public Page(){}

    public Page(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void decorate(Object page){
        PageFactory.initElements(webDriver,page);

    }
}
