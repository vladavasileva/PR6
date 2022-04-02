package ex04;
import ex02.View;
/** Console command
 * Restore;
 * pattern Command
 * @author Vlada
 * @version 1.0
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    /** An object that implements an interface{@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d}
     */
    private View view;

    /** Initializes a field {@linkplain RestoreConsoleCommand#view}
     * @param view an object that implements an interface {@linkplain View}
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'r';
    }
    @Override
    public String toString() {
        return "'r'estore";
    }
    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}