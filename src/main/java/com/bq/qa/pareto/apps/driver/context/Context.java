package com.bq.qa.pareto.apps.driver.context;

import com.bq.qa.pareto.apps.util.ParetoAppLogger;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p/>
 * This class allows to obtain all contexts and set the current app context<br>
 * <p/>
 */
public class Context {

    private final static String WEBVIEW_PREFIX = "WEBVIEW";
    private final static String NATIVE_PREFIX = "NATIVE_APP";


    private Logger paretoLogger;
    private AppiumDriver driver;

    /**
     * Constructor
     *
     * @param driver
     */
    public Context(AppiumDriver driver) {
        this.paretoLogger = ParetoAppLogger.getLogger();
        this.driver = driver;
    }

    /**
     * Switches the focus of future commands for this driver, given a context
     *
     * @param name name of the context as returned by {@link #getContextHandles()}
     * @return driver focused on the given window.
     * @throws NoSuchContextException, in case the context cannot be found
     */
    public WebDriver setContext(String name) {
        paretoLogger.debug("Switching context to " + name);
        return driver.context(name);
    }

    /**
     * Gives a set of context handlers that can be used to iterate over all contexts of the
     * web driver instance
     *
     * @return set of context handlers
     */
    public Set<String> getContextHandles() {
        Set<String> availableContexts = driver.getContextHandles();
        paretoLogger.debug("Available Contexts " + availableContexts.stream().collect(Collectors.joining(", ")));
        return availableContexts;
    }

    /**
     * Gets an opaque handler to the context that uniquely identifies it within this driver
     * instance. This can be used to switch to this context later
     *
     * @return context handler
     */
    public String getContext() {
        paretoLogger.debug("Getting the context in use");
        return driver.getContext();
    }

    /**
     * Switches to native context
     */
    public void switchToNative() {
        paretoLogger.debug("Switching context to Native app");
        setContext(NATIVE_PREFIX);
    }


    /**
     * Searches the first web view context and switches to it. Keeps the native context if
     * there is not a web view context
     *
     * @return web view context found
     */
    public boolean switchToWebview() {
        paretoLogger.debug("Switching context to Web");

        Set<String> contexts = getContextHandles();
        Iterator<String> it = contexts.iterator();

        boolean found = false;
        String context = "";

        while (it.hasNext() && !found) {
            context = it.next();
            found = context.contains(WEBVIEW_PREFIX);
        }

        if (found) {
            setContext(context);
        }
        return found;
    }
}
