package com.bq.qa.pareto.web.example.pages;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.BrowserDriver;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Copyright 2016 (C) BQ
 */
public class GitHubHomePage extends Page<BrowserDriver> {

    @FindBy(name="q")
    WebElement searchEditText;

    public GitHubHomePage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void search(String text){
        searchEditText.sendKeys(text+"\n");
    }

}
