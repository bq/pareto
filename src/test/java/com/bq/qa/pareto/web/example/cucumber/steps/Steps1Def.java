package com.bq.qa.pareto.web.example.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.example.config.GithubConfig;
import com.bq.qa.pareto.web.example.pages.GitHubHomePage;
import com.bq.qa.pareto.web.example.pages.GitHubResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class Steps1Def {

    private final ParetoWeb paretoWeb;
    public GitHubHomePage gitHubHomePage;
    public GitHubResultsPage gitHubResultsPage;
    public WebDriver webDriver;

    public Steps1Def(){
        paretoWeb = ParetoWeb.<ChromeDriver,GithubConfig>getInstance(GithubConfig.class);
        this.gitHubHomePage= new GitHubHomePage(paretoWeb);
        this.gitHubResultsPage=new GitHubResultsPage(paretoWeb);
        this.webDriver=paretoWeb.getDriver();
    }

    @Given("^Go to GitHub$")
    public void go_to_github(){
        String url = paretoWeb.getConfig().driver_endpoint();
        webDriver.get(url);
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
