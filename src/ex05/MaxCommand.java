package ex05;

import ex02.ViewResult;
import ex04.Command;

import java.util.concurrent.TimeUnit;

/**
 * The task used by
 * stream handler;
 * pattern Worker Thread
 *
 * @author Vlada
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class MaxCommand implements Command /*, Runnable */ {
    /**
     * Stores the result of processing the collection
     */
    public int result = -1;
    /**
     * Result ready flag
     */
    private int progress = 0;
    /**
     * Serves a collection of objects {@linkplain ex01.Item2d}
     */
    public ViewResult viewResult;

    /**
     * Returns a field {@linkplain MaxCommand#viewResult}
     *
     * @return value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Sets a field {@linkplain MaxCommand#viewResult}
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
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Returns result
     *
     * @return field {@linkplain MaxCommand#result}
     */
    public int getResult() {
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
     * pettern Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        result = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(result).getOnesNumber() <
                    viewResult.getItems().get(idx).getOnesNumber()) {
                result = idx;
            }
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(700 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println("Max done. Item #" + result +
                " found: " + viewResult.getItems().get(result));
        progress = 100;
    }
/**
 @Override public void run() {
 execute();
 }
 /**/
}