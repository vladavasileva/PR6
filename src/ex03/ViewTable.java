package ex03;
import java.util.Arrays;
import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;
/** ConcreteProduct
 * (design pattern
 * Factory Method)<br>
 * Table output
 * @author Vlada
 * @version 1.0
 * @see ViewResult
 */

public class ViewTable extends ViewResult {
    /** Specifies the default table width */
    private static final int DEFAULT_WIDTH = 40;
    /** Current table width */
    private int width;

    /** Sets {@linkplain ViewTable#width width}
     * value {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /** Sets {@linkplain ViewTable#width} значением <b>width</b><br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     * @param width оwidth defines the width of the table
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /** Sets {@linkplain ViewTable#width} значением <b>width</b><br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult(int n) ViewResult(int
    n)}
     * @param width width defines the width of the table
     * @param n the number of elements in the collection; passed to the super constructor
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /** Sets the field {@linkplain ViewTable#width} значением <b>width</b>
     * @param width нew table width
     * @return set by parameter <b>width</b> table width
     */
    public int setWidth(int width) {
        return this.width = width;
    }

    /** Returns the field value {@linkplain ViewTable#width}
     * @return current table width
     */
    public int getWidth() {
        return width;
    }

    /** Outputs a vertical separator width{@linkplain ViewTable#width} symbols */
    private void outLine() {
        for(int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /** Calls {@linkplain ViewTable#outLine()}; terminates the output with a line separator */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /** /** Displays the table header width {@linkplain ViewTable#width} symbols */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "Number of '1's", "Arguments");
    }

    /** Displays the body of the table with a width  {@linkplain ViewTable#width} symbols */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$s%s", "%", (width-3)/2, "d | %", "s\n");
        for(Item2d item : getItems()) {
            System.out.printf(fmt.toString(), item.getOnesNumber(), Arrays.toString(item.getArguments()));
        }
    }

    /** Overload (combination, overloading) superclass method;
     * sets the field {@linkplain ViewTable#width} value <b>width</b><br>
     * Calls a method {@linkplain ViewResult#viewInit() viewInit()}
     * @param width  new table width
    9
     */
    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();
    }

    /** Superclass method overload;
     * sets the field {@linkplain ViewTable#width} value <b>width</b><br>
     *  For object {@linkplain ViewTable} calls a method {@linkplain ViewTable#init(double
            argumentsStep)}
     * @param width new table width
     * @param argumentsStep passed to the method <b>init(double)</b>
     */
    public final void init(int width, double argumentsStep) { // method overloading
        this.width = width;
        init(argumentsStep);
    }

    /** Redefinition (replacement, overriding) superclass method;
     * prints an informational message and calls the superclass method
     * {@linkplain ViewResult#init(double argumentsStep) init(double argumentsStep)}<br>
     * {@inheritDoc}
     */
    @Override
    public void init(double argumentsStep) { // method overriding
        System.out.print("Initialization... ");
        super.init(argumentsStep);
        System.out.println("done. ");
    }

    /**Table element output<br>{@inheritDoc} */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    /** Table element output <br>{@inheritDoc} */
    @Override
    public void viewBody() {
        outBody();
    }

    /** Table element output<br>{@inheritDoc} */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}