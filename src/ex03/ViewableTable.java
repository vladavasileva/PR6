package ex03;
import ex02.ViewableResult;
import ex02.View;
/** ConcreteCreator
 * (design pattern
 * Factory Method)<br>
 * Declares a method
 * "fabricating" objects
 * @author Vlada
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /** Creates a displayable {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}