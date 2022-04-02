package ex04;
import java.io.IOException;
import ex02.View;
/** Console command
 * Save;
 * pattern Command
 * @author Vlada
 * @version 1.0
 */
public class SaveConsoleCommand implements ConsoleCommand {

    /** An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d}
     */
    public View view;

    /** Initializes a field {@linkplain SaveConsoleCommand#view}
     * @param view an object that implements an interface {@linkplain View}
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 's';
    }
    @Override
    public String toString() {
        return "'s'ave";
    }
    @Override
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}
