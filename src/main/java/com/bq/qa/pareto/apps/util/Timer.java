package com.bq.qa.pareto.apps.util;

import org.apache.logging.log4j.Logger;

public class Timer {

    private static final Logger paretoLogger = ParetoAppLogger.getLogger();

    /**
     * Waits for a specific number of seconds
     *
     * @param seconds number of seconds to wait for
     */
    public static void waitSeconds(int seconds) {
       paretoLogger.debug("Waiting for " + seconds + " milliseconds");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for a specific number of milliseconds
     *
     * @param millis number of milliseconds to wait for
     */
    public static void waitMillis(int millis) {
        paretoLogger.debug("Waiting for " + millis + " milliseconds");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
