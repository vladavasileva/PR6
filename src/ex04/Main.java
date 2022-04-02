package ex04;
/** Calculation and display
 * results; contains implementation
 * static method main()
 * @author Vlada
 * @version 4.0
 * @see Main#main
 */
public class Main {
    /** Executed when the program starts;
     * calls method  {@linkplain Application#run()}
     * @param args program launch options
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}