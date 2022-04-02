package ex04;
import ex02.View;
/** console command;
 * Generate;
 * pattern Command
 * @author Vlada
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {

    /** An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d}
     */
    private View view;

    /** Initializes a field {@linkplain GenerateConsoleCommand#view}
     * @param view an object that implements an interface {@linkplain View}
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'g';
    }
    @Override
    public String toString() {
        return "'g'enerate";
    }
    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}
