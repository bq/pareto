package com.bq.qa.pareto.web.example.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.example.pages.GitHubHomePage;
import com.bq.qa.pareto.web.example.pages.GitHubResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class Steps1Def {

    public GitHubHomePage gitHubHomePage;
    public GitHubResultsPage gitHubResultsPage;
    public WebDriver webDriver;

    public Steps1Def(){
        ParetoWeb paretoWeb = ParetoWeb.<ChromeDriver>getInstance();
        this.gitHubHomePage= new GitHubHomePage(paretoWeb);
        this.gitHubResultsPage=new GitHubResultsPage(paretoWeb);
        this.webDriver=paretoWeb.getDriver();
    }

    @Given("^Go to GitHub$")
    public void go_to_github(){
        webDriver.get(ParetoWeb.getConfig().driver_endpoint());
    }

    @When("^Search (.*)$")
    public void search_word(String word){
        gitHubHomePage.search(word);
    }

    @And("^Access to first result$")
    public void access_to_first_result(){
        gitHubResultsPage.accesToResult(0);
    }
}
