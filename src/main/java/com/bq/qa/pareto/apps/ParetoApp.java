package com.bq.qa.pareto.apps;

import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import com.bq.qa.pareto.apps.config.IOSAppConfig;
import com.bq.qa.pareto.apps.config.ParetoAppConfig;
import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.driver.IOSDriver;
import com.bq.qa.pareto.apps.server.AppiumManager;
import com.bq.qa.pareto.apps.server.AppiumServer;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class ParetoApp<D extends AppiumDriver> {
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    private static ParetoApp paretoApp;

    private AppiumManager appiumManager;
    private static ParetoAppConfig paretoAppConfig = ConfigFactory.create(ParetoAppConfig.class);
    private static AndroidAppConfig androidAppConfig = ConfigFactory.create(AndroidAppConfig.class);
    private static IOSAppConfig iosAppConfig= ConfigFactory.create(IOSAppConfig.class);

    private D driver;

    private ParetoApp() {
        appiumManager = new AppiumManager();
        paretoAppConfig = ConfigFactory.create(ParetoAppConfig.class);
        androidAppConfig = ConfigFactory.create(AndroidAppConfig.class);
        iosAppConfig = ConfigFactory.create(IOSAppConfig.class);
    }

    public static ParetoApp getInstance(){
        if(paretoApp==null)
            paretoApp = new ParetoApp<>();
        return paretoApp;
    }

    public static ParetoAppConfig getConfig() {
        return paretoAppConfig;
    }

    public D createDriver(String url,String so){
        driver =null;
        try {
            if(so.equals(ANDROID)){
                driver = (D) new AndroidDriver(new URL(url));
            }
            else{
                driver = (D) new IOSDriver(new URL(url));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public D getDriver(){
        return driver;
    }

    public static AndroidAppConfig getAndroidConfig() {
        return androidAppConfig;
    }

    public static IOSAppConfig getIOSConfig() {
        return iosAppConfig;
    }

    public AppiumServer createAppiumServer(String UDID, String so) {
        return appiumManager.startAppiumServer(UDID, so);
    }
}
