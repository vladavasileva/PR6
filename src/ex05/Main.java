package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.Menu;
import ex04.ViewConsoleCommand;

/**
 * Calculating and displaying
 * results; contains an implementation
 * static method main()
 *
 * @author Vlada
 * @version 5.0
 * @see Main#main
 */
public class Main {
    /**
     * An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d};
     * initialized with Factory Method
     */
    private View view = new ViewableResult().getView();
    /**
     * class object {@linkplain Menu};
     * macro (шаблон Command)
     */
    private Menu menu = new Menu();

    /**
     * Handling user commands
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Executed when the program starts
     *
     * @param args program launch options
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
