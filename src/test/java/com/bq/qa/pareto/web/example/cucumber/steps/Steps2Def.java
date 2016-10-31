package com.bq.qa.pareto.web.example.cucumber.steps;

import com.bq.qa.pareto.web.ParetoWeb;
import com.bq.qa.pareto.web.driver.ChromeDriver;
import com.bq.qa.pareto.web.example.pages.GitHubCommitsPage;
import com.bq.qa.pareto.web.example.pages.GitHubRepoPage;
import cucumber.api.java.en.And;

public class Steps2Def {

    public GitHubRepoPage gitHubRepoPage;
    public GitHubCommitsPage gitHubCommitsPage;

    public Steps2Def(){
        ParetoWeb paretoWeb = ParetoWeb.<ChromeDriver>getInstance();
        this.gitHubRepoPage=new GitHubRepoPage(paretoWeb);
        this.gitHubCommitsPage=new GitHubCommitsPage(paretoWeb);
    }

    @And("^Access to commit section$")
    public void access_to_first_commit(){
        gitHubRepoPage.toCommitsSection();
    }

    @And("^Go to last commit$")
    public void go_to_last_commit(){
        gitHubCommitsPage.goToLastCommit();
    }

}
