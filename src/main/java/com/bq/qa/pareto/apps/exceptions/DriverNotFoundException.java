package com.bq.qa.pareto.apps.exceptions;

/**
 * <p/>
 * Exception thrown when the mobile operating system is not supported
 * <p/>
 */
public class DriverNotFoundException extends Exception {
    public DriverNotFoundException(String message) {
        super(message);
    }
}
