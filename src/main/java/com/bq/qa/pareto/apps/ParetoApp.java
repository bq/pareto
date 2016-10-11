package com.bq.qa.pareto.apps;

import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import com.bq.qa.pareto.apps.config.IOSAppConfig;
import com.bq.qa.pareto.apps.config.ParetoAppConfig;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.driver.DriverFactory;
import com.bq.qa.pareto.apps.driver.IOSDriver;
import com.bq.qa.pareto.apps.server.AppiumManager;
import com.bq.qa.pareto.apps.server.AppiumServer;
import org.aeonbits.owner.ConfigFactory;

public class ParetoApp {

    private AppiumManager appiumManager;
    private DriverFactory driverFactory;

    private static ParetoAppConfig CFG =ConfigFactory.create(ParetoAppConfig.class);

    private static AndroidAppConfig CFG_ANDROID = ConfigFactory.create(AndroidAppConfig.class);
    private static IOSAppConfig CFG_IOS = ConfigFactory.create(IOSAppConfig.class);

    public ParetoApp(){
        appiumManager = new AppiumManager();
        driverFactory = new DriverFactory();
    }

    public static ParetoAppConfig getConfig(){
      return CFG;
    }

    public static AndroidAppConfig getAndroidConfig(){return CFG_ANDROID;}

    public static IOSAppConfig getIOSConfig(){return CFG_IOS;}

    public AndroidDriver getAndroidDriver(String url){
        return driverFactory.createAndroidDriver(url);
    }

    public IOSDriver getiOSDriver(String url){
        return driverFactory.createiOSDriver(url);
    }

    public AppiumServer getAppiumServer(String UDID, String so){
        return  appiumManager.startAppiumServer(UDID,so);
    }
}
