package com.bq.qa.pareto.apps.example.di;

import com.bq.qa.pareto.apps.ParetoApp;


public class Injector {

    private static ParetoApp paretoApp;

//    public static AppiumServer androidAppiumServer(){
//        return paretoApp().createAppiumServer(ParetoApp.getAndroidConfig().devices_udid().get(0), ServerFactory.ANDROID);
//    }
//
//    public static AndroidDriver androidDriver(){
//        return paretoApp().createAndroidDriver(androidAppiumServer().getURL());
//    }

    public static ParetoApp paretoApp(){
        if(paretoApp==null)
            paretoApp = new ParetoApp();
        return paretoApp;
    }

//
//    public static HomePage homePage(AndroidDriver androidDriver) {
//        return new HomePage(androidDriver);
//    }
//
//    public static AnimationsPage animationsPage(AndroidDriver androidDriver){
//        return new AnimationsPage(androidDriver);
//    }

}
