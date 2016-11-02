package com.bq.qa.pareto.web.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class ParetoWebLogger {

    public  static Logger getLogger(){
        String filename="paretoWeb";
        Level level;

        switch ("DEBUG"){
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
