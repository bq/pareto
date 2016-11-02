package com.bq.qa.pareto.apps.util;

import com.bq.qa.pareto.apps.config.ParetoAppConfig;
import org.apache.http.HttpEntity;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FileHandler {

    private static final Logger paretoLogger = ParetoAppLogger.getLogger();

    /**
     * Gets the log file path
     *
     * @return log file path
     */
    public static String getLogPath() {
        String logsFolder = "/var/tmp/pareto/logs/";
        String logsFileName = "logAppium.txt";
        long date = new Date().getTime();

        File logsDirectory = new File(logsFolder);
        File logFile = new File(logsFolder + date+"_"+logsFileName);

        if (!logsDirectory.exists()) logsDirectory.mkdirs();

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        paretoLogger.debug("Getting the logs directory path");

        return logFile.getAbsolutePath();
    }

    /**
     * Cleans the log file content
     */
    public static void removeLogFileContent() {
        paretoLogger.debug("Cleaning the logs directory");
        removeFileContent(new File(getLogPath()));
    }

    /**
     * Removes the file content
     *
     * @param file file where to perform the operation
     */
    private static void removeFileContent(File file) {
        if (file.exists()) {
            try {
                new RandomAccessFile(file, "rw").setLength(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks if the file exits
     *
     * @param path path to the file
     * @return true if the file exits. Otherwise, false
     */
    public static boolean checkIfFileExits(String path) {
        return new File(path).exists();
    }

    /**
     * Reads an input stream and saves its content in a file
     *
     * @param inputStream input stream to be read
     * @param destination output file path
     */
    public static void inputStreamToFile(InputStream inputStream, String destination) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(destination));
            int inByte;
            while ((inByte = inputStream.read()) != -1) fos.write(inByte);
            inputStream.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the http entity content in a file
     *
     * @param httpEntity  http entity to be read
     * @param destination output file path
     */
    public static void httpEntityToFile(HttpEntity httpEntity, String destination) {
        InputStream inputStream;
        try {
            inputStream = httpEntity.getContent();
            FileOutputStream fos = new FileOutputStream(new File(destination));
            int inByte;
            while ((inByte = inputStream.read()) != -1) fos.write(inByte);
            inputStream.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the file name from an url o a local path
     *
     * @param url url or local path of the file
     * @return file name
     */
    public static String getFileName(String url) {
        List<String> urlSplitted = Arrays.asList(url.split("/"));
        return urlSplitted.get(urlSplitted.size() - 1);
    }

    /**
     * Cleans all files in a directory
     *
     * @param directory path to the directory that will be cleaned
     */
    public static void cleanDirectory(String directory) {
        paretoLogger.debug("Cleaning the logs directory");
        for (File file : (new File(directory)).listFiles()) file.delete();
    }

    //TODO AÑADIR DESCRIPCIÓN
    public static void createFileVoidFile(String filePath) {
        PrintWriter writer;

        try {
            writer = new PrintWriter(filePath, "UTF-8");
            writer.println("BINARY");
            writer.close();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes the file, given the path to its directory
     *
     * @param filePath path to the file
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }

    /**
     * Creates the directory where to save the binary
     */
    public static void createBinaryDirectory(ParetoAppConfig paretoAppConfig) {
        File binaryDirectory = new File(paretoAppConfig.binary_path());
        if (!binaryDirectory.exists()) binaryDirectory.mkdirs();
    }
}
