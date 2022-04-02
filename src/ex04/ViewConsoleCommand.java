package ex04;
import ex02.View;
/** Console command
 * View;
 * pattern Command
 * @author Vlada
 * @version 1.0
 */
public class ViewConsoleCommand implements ConsoleCommand {

    /** An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d}
     */
    private View view;

    /** Initializes a field {@linkplain SaveConsoleCommand#view}
     * @param view an object that implements an interface {@linkplain View}
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }
    @Override
    public String toString() {
        return "'v'iew";
    }
    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}