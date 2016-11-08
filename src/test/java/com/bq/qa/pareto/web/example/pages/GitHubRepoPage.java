package com.bq.qa.pareto.web.example.pages;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.BrowserDriver;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Copyright 2016 (C) BQ
 */
public class GitHubRepoPage extends Page<BrowserDriver> {

    @FindBy(className = "commits")
    WebElement commitsButton;

    public GitHubRepoPage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void toCommitsSection(){
        commitsButton.click();
    }

}
