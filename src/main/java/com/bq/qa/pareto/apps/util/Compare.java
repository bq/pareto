package com.bq.qa.pareto.apps.util;

import org.im4java.core.CommandException;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.ImageCommand;

import java.io.IOException;
import java.util.ArrayList;

public class Compare {

    public enum Metric {AE, PAE, PSNR, MAE, MSE, RMSE, MEPP, FUZZ, NCC}

    public enum Color {SEAGREEN1, BLUE, YELLOW, GREY, ROYALBLUE1}

    private Metric metric;
    private Color color;
    private int fuzz;
    private IMOperation operation;
    private ArrayList<String> arguments = new ArrayList<>();
    private ImageCommand command;

    /**
     * @param metric Can be one of: AE, PAE, PSNR, MAE, MSE, RMSE, MEPP, FUZZ, NCC
     * @param color  Can be one of: SEANGREEN1, BLUE, YELLOW, GREY, ROYALBLUE1
     */

    public Compare(Metric metric, Color color) {
        this.metric = metric;
        this.color = color;

        arguments.add("-metric");
        arguments.add(metric.toString());

        arguments.add("-highlight-color");
        arguments.add(color.toString());
    }

    /**
     * @param metric Can be one of: AE, PAE, PSNR, MAE, MSE, RMSE, MEPP, FUZZ, NCC
     */
    public Compare(Metric metric) {
        this.metric = metric;

        arguments.add("-metric");
        arguments.add(metric.toString());

    }

    /**
     * @param metric Can be one of: AE, PAE, PSNR, MAE, MSE, RMSE, MEPP, FUZZ, NCC
     * @param fuzz   distance - colors within this distance are considered equal
     */
    public Compare(Metric metric, int fuzz) {
        this.metric = metric;
        this.fuzz = fuzz;
        arguments.add("-metric");
        arguments.add(metric.toString());
        arguments.add("-fuzz");
        arguments.add(fuzz + "%");
    }

    private void createOperation() {
        operation = new IMOperation();
        operation.addRawArgs(arguments);
        operation.addImage();
        operation.addImage();
        operation.addImage();

        command = new ImageCommand();
        command.setCommand("compare");

    }

    /**
     * @param actual   Image No.1 to compare
     * @param expected Image No.2 to compare
     * @param output   composite image
     * @return distortion value
     */
    public double comparison(String actual, String expected, String output) {
        String out, value, result;
        try {
            createOperation();
            command.run(operation, actual, expected, output);
        } catch (IOException e) {

        } catch (InterruptedException e) {

        } catch (CommandException e) {

        } catch (IM4JavaException e) {

        }

        if (metric == Metric.RMSE) {
            out = command.getErrorText().get(0);
            value = out.split("\\(")[1];
            result = value.substring(0, value.length() - 1);
        } else {
            result = command.getErrorText().get(0);
        }

        return Double.valueOf(result);
    }

    public void differenceImages(String actual, String expected, String output) {
        comparison(actual, expected, output);
    }

    public boolean compareImage(String actual, String expected) {
        String output = "null: -";
        double result = comparison(actual, expected, output);
        return (result == 0.0);
    }

    public boolean compareImage(String actual, String expected, double value) {
        String output = "null: -";
        double result = comparison(actual, expected, output);
        return (result == value);
    }

}
