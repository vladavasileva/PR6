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
public class MinMaxCommand implements Command /*, Runnable */ {
    /**
     * Stores the result of processing the collection
     */
    private int resultMin = -1;
    /**
     * Stores the result of processing the collection
     */
    private int resultMax = -1;
    /**
     * Result ready flag
     */
    private int progress = 0;
    /**
     * Serves a collection of objects {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Returns a field {@linkplain MinMaxCommand#viewResult}
     *
     * @return value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Sets the field {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult value for {@linkplain MinMaxCommand#viewResult}
     * @return new value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Initializes a field {@linkplain MinMaxCommand#viewResult}
     *
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Returns the result
     *
     * @return field {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }

    /**
     * Returns the result
     *
     * @return field {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }

    /**
     * Checks if the result is ready
     *
     * @return false - if the result is found, otherwise- true
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Used by thread handler {@linkplain CommandQueue};
     * pattern Worker Thread
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getOnesNumber() < 0) {
                if ((resultMax == -1) ||
                        (viewResult.getItems().get(resultMax).getOnesNumber() <
                                item.getOnesNumber())) {
                    resultMax = idx;
                }
            } else {
                if ((resultMin == -1) ||
                        (viewResult.getItems().get(resultMin).getOnesNumber() >
                                item.getOnesNumber())) {
                    resultMin = idx;
                }
            }
            idx++;
            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMin > -1) {
            System.out.print("Min positive #" + resultMin + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMin).getOnesNumber()));
        } else {
            System.out.print("Min positive not found.");
        }
        if (resultMax > -1) {
            System.out.println(" Max negative #" + resultMax + " found: " +
                    String.format("%d",
                            viewResult.getItems().get(resultMax).getOnesNumber()));
        } else {
            System.out.println(" Max negative item not found.");
        }
        progress = 100;
    }
/**
 @Override public void run() {
 execute();
 }
 /**/
}
