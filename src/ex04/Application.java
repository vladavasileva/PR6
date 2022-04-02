package ex04;
import ex02.View;
import ex03.ViewableTable;
/** Forms and displays
 * menu; implements the pattern
 * Singleton
 * @author xone
 * @version 1.0
 */
public class Application {
    /** Reference to an instance of the Application class; Singleton pattern
     * @see Application
     */
    private static Application instance = new Application();
    /** Private constructor; Singleton pattern
     * @see Application
     */
    private Application() {}
    /** Returns a reference to an instance of the Application class;
     * шаблон Singleton
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }
    /** An object that implements an interface {@linkplain View};
     * maintains a collection of objects {@linkplain ex01.Item2d};
     * initialized with Factory Method
     */
    private View view = new ViewableTable().getView();
    /** class object {@linkplain Menu};
     * macro (pattern Command)
     */
    private Menu menu = new Menu();
    /** Handling user commands
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}