package com.bq.qa.pareto.apps.driver;


import com.bq.qa.pareto.apps.config.AndroidAppConfig;
import com.bq.qa.pareto.apps.driver.actions.MobileActions;
import com.bq.qa.pareto.apps.driver.actions.MobileActionsImpl;
import com.bq.qa.pareto.apps.driver.capabilities.AndroidCapabilities;
import com.bq.qa.pareto.apps.driver.connection.AndroidNetwork;
import com.bq.qa.pareto.apps.driver.connection.Network;
import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import cucumber.api.Scenario;
import io.appium.java_client.TouchAction;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * <p/>
 * This class defines an implementation of a particular app driver for Android's operating system
 * <p/>
 *
 */
public class AndroidDriver extends io.appium.java_client.android.AndroidDriver implements MobileActions{

    private MobileActions mobileActions;
    private AndroidNetwork androidNetwork;
    private Logger paretoLogger;
    private AndroidAppConfig androidAppConfig;

    /**
     * Constructor
     *
     * @param remoteAddress       emote address
     */
    public AndroidDriver(URL remoteAddress, AndroidAppConfig androidAppConfig) {
        super(remoteAddress, new AndroidCapabilities(androidAppConfig).getDesiredCapabilities());
        this.androidAppConfig = androidAppConfig;
        this.mobileActions = new MobileActionsImpl(this);
        this.androidNetwork = new AndroidNetwork(this);
        this.paretoLogger = ParetoAppLogger.getLogger();

        manage().timeouts().implicitlyWait(androidAppConfig.driver_timeout(), TimeUnit.SECONDS);
    }

    @Override
    public void pressAndSwipe(Double xStart, Double yStart, Double xEnd, Double yEnd) {
        mobileActions.pressAndSwipe(xStart,yStart,xEnd,yEnd);
    }

    @Override
    public void swipe(double startx, double starty, double endx, double endy, int duration) {
        mobileActions.swipe(startx,starty,endx,endy,duration);
    }

    @Override
    public void getScreenshot(String destFile) {
        mobileActions.getScreenshot(destFile);
    }

    @Override
    public void tap(int x, int y) {
        mobileActions.tap(x,y);
    }

    @Override
    public void longPress(int x, int y) {
        mobileActions.longPress(x,y);
    }

    @Override
    public void longPress(Double x, Double y) {
        mobileActions.longPress(x, y);
    }

    @Override
    public void longPress(WebElement element) {
        mobileActions.longPress(element);
    }

    @Override
    public void swipeRightToLeft(int times, int wait) {
        mobileActions.swipeRightToLeft(times,wait);
    }

    @Override
    public void swipeLeftToRight(int times, int wait) {
        mobileActions.swipeLeftToRight(times,wait);
    }

    @Override
    public void swipeLeftToTop(int times, int wait) {
        mobileActions.swipeLeftToTop(times,wait);
    }

    @Override
    public void swipeLeftToDown(int times, int wait) {
        mobileActions.swipeLeftToDown(times,wait);
    }

    @Override
    public void saveScreenShotOnError(Scenario scenario) {
        mobileActions.saveScreenShotOnError(scenario);
    }

    @Override
    public void scrollDown(int times) {
        mobileActions.scrollDown(times);
    }

    @Override
    public void scrollUp(int times) {
        mobileActions.scrollUp(times);
    }

    @Override
    public void tapOnCenter() {
        mobileActions.tapOnCenter();
    }

    @Override
    public void tapOnLeft() {
        mobileActions.tapOnLeft();
    }

    @Override
    public void tapOnRight() {
        mobileActions.tapOnRight();
    }

    @Override
    public void tapOnTop() {
        mobileActions.tapOnTop();
    }

    @Override
    public void tapOnBottom() {
        mobileActions.tapOnBottom();
    }

    public void swipe(int startX, int startY, int endX, int endY, double duration) {
        swipe(startX, startY, endX, endY, (int) duration * 1000);
    }

    public void dragAndDrop(WebElement init_element, WebElement end_element) {
        new TouchAction(this).press(init_element).waitAction(3000).moveTo(end_element).release().perform();
    }

    public void moveSlider(WebElement element, double pos) {
        int posInt = (int) (pos*100);
        Point location = element.getLocation();
        Dimension dimension= element.getSize();

        int locX = location.getX();
        int locY = location.getY();

        int point= (dimension.getWidth()*posInt)/100;
        point= point+locX;

        tap(point,locY);
    }

    public Network network() {
        return androidNetwork;
    }


}
