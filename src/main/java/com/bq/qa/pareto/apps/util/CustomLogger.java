package com.bq.qa.pareto.apps.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.nio.charset.Charset;

public class CustomLogger {

    public static final String PATTERN = "%d{dd MMM yyyy HH:mm:ss,SSS} [pareto - %thread] %-5level %class{0}.%method{0} - %msg%n";
    private static Logger paretoLogger;

    public static Logger getParetoLogger(String filename,Level level) {
        if (paretoLogger == null) paretoLogger = createLogger("/var/tmp/pareto/logs/"+filename,level);
        return paretoLogger;
    }

    public static Logger createLogger(String filename, Level level){
        LoggerContext context= (LoggerContext) LogManager.getContext();
        Configuration config= context.getConfiguration();

        PatternLayout layout= PatternLayout.createLayout(PATTERN, config, null, Charset.defaultCharset(),false,false,null,null);

        Appender fileAppender=FileAppender.createAppender(filename,null,null,"fileApender",null,null,null,null,layout,null,null,null,config);
        fileAppender.start();

        Appender consoleAppender= ConsoleAppender.createAppender(layout,null,null,"console",null,null);
        consoleAppender.start();

        AppenderRef ref= AppenderRef.createAppenderRef("CONSOLE_APPENDER",null,null);
        AppenderRef[] refs = new AppenderRef[] {ref};
        LoggerConfig loggerConfig= LoggerConfig.createLogger("false", level,"CONSOLE_LOGGER","true",refs,null,null,null);


        loggerConfig.addAppender(fileAppender,null,null);
        loggerConfig.addAppender(consoleAppender,null,null);

        config.addAppender(fileAppender);
        config.addAppender(consoleAppender);

        config.addLogger("com", loggerConfig);
        context.updateLoggers(config);

        Logger logger=LogManager.getContext().getLogger("com");

        return logger;
    }



}
