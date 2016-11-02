package com.bq.qa.pareto.apps;

import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import com.bq.qa.pareto.apps.config.IOSAppConfig;
import com.bq.qa.pareto.apps.config.ParetoAppConfig;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.driver.IOSDriver;
import com.bq.qa.pareto.apps.server.AppiumManager;
import com.bq.qa.pareto.apps.server.AppiumServer;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class ParetoApp<D extends AppiumDriver,T extends ParetoAppConfig> {
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    private static ParetoApp paretoApp;
    private final Logger paretoAppLogger=ParetoAppLogger.getLogger();
    private AppiumManager appiumManager;

    private D driver;
    private T config;

    private ParetoApp(Class<? extends T> klass) {
        appiumManager = new AppiumManager();
        config = ConfigFactory.create(klass);
    }

    public static ParetoApp getInstance(Class<? extends ParetoAppConfig> klass){
        if(paretoApp==null)
            paretoApp = new ParetoApp<>(klass);
        return paretoApp;
    }

    public T getConfig(){
        return config;
    }

    public D createDriver(String url,String so){
        driver =null;
        try {
            if(so.equals(ANDROID)){
                driver = (D) new AndroidDriver(new URL(url), (AndroidAppConfig) config);
            }
            else{
                driver = (D) new IOSDriver(new URL(url), (IOSAppConfig) config);
            }
        } catch (MalformedURLException e) {
            paretoAppLogger.error(e.getMessage());
        }
        return driver;
    }

    public D getDriver(){
        return driver;
    }

    public AppiumServer createAppiumServer(String UDID, String so) {
        return appiumManager.startAppiumServer(UDID, so,config);
    }
}
