package com.bq.qa.pareto.web.example.pages;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.BrowserDriver;
import com.bq.qa.pareto.web.util.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Copyright 2016 (C) BQ
 */
public class GitHubResultsPage extends Page<BrowserDriver> {

    @FindBy(xpath ="//*[@class='repo-list js-repo-list']//a")
    List<WebElement> repoList;

    public GitHubResultsPage(ParetoWeb paretoWeb) {
        super(paretoWeb.getDriver());
        decorate(this);
    }

    public void accesToResult(int index){
        repoList.get(index).click();
    }
}
