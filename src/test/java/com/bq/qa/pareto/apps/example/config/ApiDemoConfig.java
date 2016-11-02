package com.bq.qa.pareto.apps.example.config;


import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:default.properties",
        "classpath:ProjectConfig.properties"})
public interface ApiDemoConfig extends AndroidAppConfig{
}
