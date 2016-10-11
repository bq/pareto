package com.bq.qa.pareto.apps.driver.actions;

import cucumber.api.Scenario;
import org.openqa.selenium.WebElement;

public interface MobileActions {

     void pressAndSwipe(Double xStart, Double yStart, Double xEnd, Double yEnd);
     void longPress(int x, int y);
     void longPress(Double x, Double y);
     void longPress(WebElement element);

     void swipe(double startx, double starty, double endx, double endy, int duration);
     void swipeRightToLeft(int times, int wait);
     void swipeLeftToRight(int times, int wait);
     void swipeLeftToTop(int times, int wait);
     void swipeLeftToDown(int times, int wait);

     void saveScreenShotOnError(Scenario scenario);
     void getScreenshot(String destFile);

     void scrollDown(int times);
     void scrollUp(int times);
     void tapInCenter();
     void tapInLeft();
     void tapInRight();
     void tapInTop();
     void tapInDown();
     void tap(int x, int y);


}
