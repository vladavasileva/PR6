package ex05;

import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;

import java.util.concurrent.TimeUnit;

/**
 * The task used
 * stream handler;
 * pattern Worker Thread
 *
 * @author Vlada
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class AvgCommand implements Command /*, Runnable */ {
    /**
     * Stores the result of processing the collection
     */
    private double result = 0.0;
    /**
     * Result ready flag
     */
    private int progress = 0;
    /**
     * Serves a collection of objects {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Returns a field {@linkplain MaxCommand#viewResult}
     *
     * @return value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Sets the field {@linkplain MaxCommand#viewResult}
     *
     * @param viewResult value for {@linkplain MaxCommand#viewResult}
     * @return new value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Initializes a field {@linkplain MaxCommand#viewResult}
     *
     * @param viewResult class object{@linkplain ViewResult}
     */
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Returns the result
     *
     * @return field {@linkplain MaxCommand#result}
     */
    public double getResult() {
        return result;
    }

    /**
     * Checks if the result is ready
     *
     * @return false - if the result is found, otherwise - true
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Used by thread handler{@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Average executed...");
        result = 0.0;
        int idx = 1, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            result += item.getOnesNumber();
            progress = idx * 100 / size;
            if (idx++ % (size / 2) == 0) {
                System.out.println("Average " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        result /= size;
        System.out.println("Average done. Result = " + String.format("%.2f", result));
        progress = 100;
    }
/**
 @Override public void run() {
 execute();
 }
 /**/
}
