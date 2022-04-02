package ex03;
import ex02.View;
/** Calculating and displaying results<br>
 * Contains the implementation of the static method main()
 * @author Vlada
 * @version 3.0
 * @see Main#main
 */
public class Main extends ex02.Main {
    /** Initializes a field {@linkplain ex02.Main#view view} */
    public Main(View view) {
        super(view);
    }
    /** Executed when the program starts;
     * calls a method {@linkplain ex02.Main#menu menu()}
     * @param args - program launch options
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}