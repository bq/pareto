package com.bq.qa.pareto.web.driver;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public abstract class BrowserDriver extends RemoteWebDriver {

    public BrowserDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress,desiredCapabilities);
    }

    /**
     * Gets a screenshot when a scenario fail
     *
     * @param scenario scenario executed
     */
    public void saveScreenShotOnError(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Drags the M element and drops until N element
     *
     * @param item        web element to drag from
     * @param destination web element where drop the item to
     */
    public void dragAndDrop(By item, By destination) {
        WebElement from_elem = findElement(item);
        WebElement to_elem = findElement(destination);

        Actions a = new Actions((WebDriver) this);
        a.dragAndDrop(from_elem, to_elem);
        a.perform();
    }


    /**
     * Drags the M element and drops until N element
     *
     * @param item     web element to drag from
     * @param x_offset offset on X axis
     * @param y_offset offset on Y axis
     */
    public void dragAndDrop(By item, int x_offset, int y_offset) {
        WebElement from_elem = findElement(item);

        Actions a = new Actions((WebDriver) this);
        a.dragAndDropBy(from_elem, x_offset, y_offset);
        a.build().perform();
    }

    /**
     * Moves the cursor to the E element
     *
     * @param by Web element to move the cursor to. May be defined by ID,
     *           CLASS, TEXT, CSS or XPATH
     */
    public void movementTo(By by) {
        Actions a = new Actions((WebDriver) this);
        a.moveToElement(findElement(by));
        a.perform();
    }
}


