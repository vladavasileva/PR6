package ex04;
import ex01.Item2d;
import ex02.View;
import ex02.ViewResult;
/** Console command
 * Change item;
 * pattern Command
 * @author Vlada
 * @version 1.0
 */
public class ChangeConsoleCommand
        extends ChangeItemCommand
        implements ConsoleCommand {

    /** An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d}
     */
    private View view;

    /** Returns a field {@linkplain ChangeConsoleCommand#view}
     * @return meaning {@linkplain ChangeConsoleCommand#view}
     */
    public View getView() {
        return view;
    }
    /** Sets the field  {@linkplain ChangeConsoleCommand#view}
     * @param view value for {@linkplain ChangeConsoleCommand#view}
     * @return new value {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
    }
    /** Initializes a field {@linkplain ChangeConsoleCommand#view}
     * @param view an object that implements an interface {@linkplain View}
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (Item2d item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}
