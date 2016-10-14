package com.bq.qa.pareto.apps.driver;

import com.bq.qa.pareto.apps.driver.actions.MobileActions;
import com.bq.qa.pareto.apps.driver.actions.MobileActionsImpl;
import com.bq.qa.pareto.apps.driver.connection.IOSNetwork;
import com.bq.qa.pareto.apps.driver.connection.Network;
import com.bq.qa.pareto.apps.driver.context.Context;
import cucumber.api.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import java.net.URL;

/**
 * <p/>
 * This class defines an implementation of a particular app driver for iOS operating system
 * <p/>
 */
public class IOSDriver extends io.appium.java_client.ios.IOSDriver implements MobileActions {

    private MobileActions mobileActions;
    private IOSNetwork iosNetwork;
    private Context context;

    /**
     * Constructor
     *
     * @param remoteAddress       remote address
     * @param desiredCapabilities desired capabilities
     */
    public IOSDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        this.mobileActions = new MobileActionsImpl(this);
        this.iosNetwork= new IOSNetwork(this);
        this.context = new Context(this);

    }

    @Override
    public void pressAndSwipe(Double xStart, Double yStart, Double xEnd, Double yEnd) {
        mobileActions.pressAndSwipe(xStart,yStart,xEnd,yEnd);
    }

    @Override
    public void longPress(int x, int y) {
        mobileActions.longPress(x, y);
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
    public void swipe(double startx, double starty, double endx, double endy, int duration) {
        mobileActions.swipe(startx, starty, endx, endy, duration);
    }

    @Override
    public void swipeRightToLeft(int times, int wait) {
        mobileActions.swipeRightToLeft(times, wait);
    }

    @Override
    public void swipeLeftToRight(int times, int wait) {
        mobileActions.swipeLeftToRight(times, wait);
    }

    @Override
    public void swipeLeftToTop(int times, int wait) {
        mobileActions.swipeLeftToTop(times, wait);
    }

    @Override
    public void swipeLeftToDown(int times, int wait) {
        mobileActions.swipeLeftToDown(times, wait);
    }

    @Override
    public void saveScreenShotOnError(Scenario scenario) {
        mobileActions.saveScreenShotOnError(scenario);
    }

    @Override
    public void getScreenshot(String destFile) {
        mobileActions.getScreenshot(destFile);
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

    @Override
    public void tap(int x, int y) {
        mobileActions.tap(x, y);
    }

    public Network network() {
        return iosNetwork;
    }

    public void moveSlider(WebElement element, double pos) {
        element.sendKeys(String.valueOf(pos));
    }


}
