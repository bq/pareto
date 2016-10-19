package com.bq.qa.pareto.apps.driver.actions;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MobileActionsImpl implements MobileActions {

    private AppiumDriver appiumDriver;

    public MobileActionsImpl(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
    }

    private <T extends WebElement> void performTouch(T element, Consumer<T> consumer) {
        consumer.accept(element);
    }

    /**
     * Press and swipe from a specific screen position to another
     *
     * @param xStart start x relative coordinate
     * @param yStart start y relative coordinate
     * @param xEnd   end y relative coordinate
     * @param yEnd   end y relative coordinate
     * @return position
     */

    public void pressAndSwipe(Double xStart, Double yStart, Double xEnd, Double yEnd) {

        Dimension dim = appiumDriver.manage().window().getSize();
        int ixStart = (int) (dim.width * xStart);
        int iyStart = (int) (dim.height * yStart);

        int ixEnd = (int) (dim.width * xEnd);
        int iyEnd = (int) (dim.height * yEnd);

        int difX = ixEnd - ixStart;
        int difY = iyEnd - iyStart;

        performTouch(null, (elem) -> appiumDriver.performTouchAction(new TouchAction(appiumDriver).press(ixStart, iyStart).moveTo(difX, difY).release().perform()));
    }

    /**
     * Swipe from a specific screen position to another
     *
     * @param startx start x coordinate
     * @param starty start y coordinate
     * @param endx   end x coordinate
     * @param endy   end y coordinate
     */
    public void swipe(double startx, double starty, double endx, double endy, int duration) {

        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;

        appiumDriver.swipe((int) (startx * screenWidth), (int) (starty * screenHeight),
                (int) (endx * screenWidth), (int) (endy * screenHeight),
                duration * 1000);
    }

    /**
     * Take a screenshot and it is stored in a file
     *
     * @param destFile file where the screenshot will be stored
     */
    public void getScreenshot(String destFile) {
        File srcFiler = appiumDriver.getScreenshotAs(OutputType.FILE);

        try {
            File file = new File(destFile);
            FileUtils.copyFile(srcFiler, file);
            srcFiler.delete();//Avoid memory leak
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Swipe on the screen from right to left
     *
     * @param times number of times to perform the swipe gesture
     * @param wait  time to wait between swipes
     */
    public void swipeRightToLeft(int times, int wait) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.9, 0.5, 0.1, 0.5, wait));
    }

    /**
     * Swipe on the screen from left to right
     *
     * @param times number of times to perform the swipe gesture
     * @param wait  time to wait between swipes
     */
    public void swipeLeftToRight(int times, int wait) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.1, 0.5, 0.9, 0.5, wait));
    }

    /**
     * Swipe on the screen from left to top
     *
     * @param times number of times to perform the swipe gesture
     * @param wait  time to wait between swipes
     */
    public void swipeLeftToTop(int times, int wait) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.5, 0.5, 0.1, 0.1, wait));
    }

    /**
     * Swipe on the screen from left to down
     *
     * @param times number of times to perform the swipe gesture
     * @param wait  time to wait between swipes
     */
    public void swipeLeftToDown(int times, int wait) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.5, 0.5, 0.5, 0.9, wait));
    }

    /**
     * Get a screenshot when a scenario fail
     *
     * @param scenario scenario executed
     */
    public void saveScreenShotOnError(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = appiumDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Scroll down a number of times specified as argument
     *
     * @param times number of times to scroll down
     */
    public void scrollDown(int times) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.5, 0.8, 0.5, 0.4, 1));
    }

    /**
     * Scroll up a number of times specifies as argument
     *
     * @param times number of times to scroll up
     */
    public void scrollUp(int times) {
        IntStream.rangeClosed(1, times).forEach(i -> swipe(0.5, 0.3, 0.5, 0.9, 1));
    }

    /**
     * Tap on the center of the screen
     */
    public void tapOnCenter() {
        int screenWidth = (appiumDriver.manage().window().getSize().width);
        int screenHeight = (appiumDriver.manage().window().getSize().height);
        tap(screenWidth / 2, screenHeight / 2);
    }

    /**
     * Tap on the left side of the screen
     */
    public void tapOnLeft() {
        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;
        tap(screenWidth / 6, screenHeight / 2);

    }

    /**
     * Tap on the right side of the screen
     */
    public void tapOnRight() {
        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;
        tap((screenWidth / 6) * 5, screenHeight / 2);

    }

    /**
     * Tap on the top side of the screen
     */
    public void tapOnTop() {
        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;
        tap(screenWidth / 2, (screenHeight / 6) * 5);

    }

    /**
     * Tap on the bottom side of the screen
     */
    public void tapOnBottom() {
        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;
        tap(screenWidth / 2, screenHeight / 6);
    }

    /**
     * Tap on a specific position of the screen for a long while (some seconds)
     *
     * @param x x coordinate of the screen position
     * @param y y coordinate of the screen position
     */
    public void tap(int x, int y) {
        performTouch(null, (elem) -> appiumDriver.performTouchAction(new TouchAction(appiumDriver).tap(x, y)));
    }


    @Override
    public void longPress(int x, int y) {
        performTouch(null, (elem) -> appiumDriver.performTouchAction(new TouchAction(appiumDriver).longPress(x, y)));
    }

    @Override
    public void longPress(Double x, Double y) {
        Dimension dim = appiumDriver.manage().window().getSize();
        int ix = (int) (dim.width * x);
        int iy = (int) (dim.height * y);

        performTouch(null, (elem) -> appiumDriver.performTouchAction(new TouchAction(appiumDriver).longPress(ix, iy)));
    }

    @Override
    public void longPress(WebElement element) {
        performTouch(element, (elem) -> appiumDriver.performTouchAction(
                new TouchAction(appiumDriver).longPress(elem, 5, 1)));
    }
}
