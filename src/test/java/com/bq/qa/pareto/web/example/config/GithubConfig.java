package com.bq.qa.pareto.web.example.config;

import com.bq.qa.pareto.web.config.ParetoWebConfig;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties"})
public interface GithubConfig extends ParetoWebConfig{

}
