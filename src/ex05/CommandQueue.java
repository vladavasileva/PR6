package ex05;

import ex04.Command;

import java.util.Vector;

/**
 * Creates a handler
 * thread running
 * objects with an interface
 * Command; pattern
 * Worker Thread
 *
 * @author Vlada
 * @version 1.0
 * @see Command
 */
public class CommandQueue implements Queue {
    /**
     * Task Queue
     */
    private Vector<Command> tasks;
    /**
     * Wait Flag
     */
    private boolean waiting;
    /**
     * Completion Flag
     */
    private boolean shutdown;

    /**
     * Sets the termination flag
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Initialization {@linkplain CommandQueue#tasks}
     * {@linkplain CommandQueue#waiting}
     * {@linkplain CommandQueue#waiting};
     * creates a thread for the class {@linkplain CommandQueue.Worker}
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command) tasks.remove(0);
    }

    /**
     * Serves the queue of
     * tasks; pattern
     * Worker Thread
     *
     * @author xone
     * @version 1.0
     * @see Runnable
     */
    private class Worker implements Runnable {
        /**
         * Retrieves from the queue
         * ready to go
         * tasks; pattern
         * Worker Thread
         */
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}