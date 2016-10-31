package com.bq.qa.pareto.apps;

import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.server.AppiumServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ParetoAppTest {

        public static final String UDID_ANDROID = "default";

        private static ParetoApp<AndroidDriver> paretoApp;
        private AndroidDriver androidDriver;

        private static AppiumServer appiumServerAndroid;


        @BeforeClass
        public static void  setUp() throws Exception {
            paretoApp = new ParetoApp();
            appiumServerAndroid= paretoApp.createAppiumServer(UDID_ANDROID, ParetoApp.ANDROID);
        }

        @Test
        public void testAndroidApp(){
            androidDriver = paretoApp.createDriver(appiumServerAndroid.getURL(),ParetoApp.ANDROID);
            androidDriver.scrollUp(2);
            androidDriver.quit();
        }

        @AfterClass
        public static void tearDown() throws Exception {
            appiumServerAndroid.stop();
        }
}