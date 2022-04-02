package ex05;
import ex04.Command;
/** Presents
 * methods for the premises
 * and retrieving tasks
 * stream handler;
 * pattern Worker Thread
 * @author Vlada
 * @version 1.0
 * @see Command
 */
public interface Queue {
    /** Adds a new task to the queue;
     * pattern Worker Thread
     * @param cmd task
     */
    void put(Command cmd);
    /** Removes a task from the queue;
     * pattern Worker Thread
     * @return task to be deleted
     */
    Command take();
}
