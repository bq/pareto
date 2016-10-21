package com.bq.qa.pareto.apps;

import com.bq.qa.pareto.apps.driver.AndroidDriver;
import com.bq.qa.pareto.apps.server.AppiumServer;
import com.bq.qa.pareto.apps.server.ServerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ParetoAppTest {

        public static final String UDID_ANDROID = "default";

        private static ParetoApp paretoApp;
        private AndroidDriver androidDriver;

        private static AppiumServer appiumServerAndroid;


        @BeforeClass
        public static void  setUp() throws Exception {
            paretoApp = new ParetoApp();
            appiumServerAndroid= paretoApp.getAppiumServer(UDID_ANDROID, ServerFactory.ANDROID);
        }

        @Test
        public void testAndroidApp(){
            androidDriver = paretoApp.getAndroidDriver(appiumServerAndroid.getURL());
            androidDriver.scrollUp(2);
            androidDriver.quit();
        }

        @AfterClass
        public static void tearDown() throws Exception {
            appiumServerAndroid.stop();
        }
}