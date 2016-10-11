package com.bq.qa.pareto.apps.util;


import com.bq.qa.pareto.apps.ParetoApp;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class ParetoAppLogger {

    public  static Logger getLogger(){
        String filename="paretoApp";
        Level level;

        switch (ParetoApp.getConfig().logger_level()){
            case "DEBUG": level= Level.DEBUG;break;
            case "ERROR": level= Level.ERROR;break;
            case "ALL": level= Level.ALL;break;
            case "INFO": level= Level.INFO;break;
            case "WARN": level= Level.WARN;break;
            default:level=Level.DEBUG;break;
        }
         return CustomLogger.getParetoLogger(filename,level);
    }
}
