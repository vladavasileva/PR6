package ex02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ex01.Item2d;

/** ConcreteProduct
 * (Design Pattern
 * Factory Method)<br>
 * Function calculation,
 * save and display
 * results
 * @author Vlada
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
    /**
     * The name of the file to use during serialization.
     */
    private static final String FNAME = "ex0.Data.bin";

    /** Specifies the number of values to calculate by default */
    private static final int DEFAULT_NUM = 10;

    /** Collection of arguments and results of calculations */
    private ArrayList<Item2d> items = new ArrayList();

    /** Calls {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * with parameter {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    /** Initializes the collection {@linkplain ViewResult#items}
     * @param n initial number of elements
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }

    /** Get value {@linkplain ViewResult#items}
     * @return the current value of the object reference  {@linkplain ArrayList}
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }

    /**
     * Calculates the value of a function.
     *
     * @param arguments - arguments of the computed function.
     * @return function evaluation result.
     */
    private byte calc(double []arguments) {
        int number = (int)((Math.sin(arguments[0]) + Math.sin(arguments[1]) + Math.sin(arguments[2]) + Math.sin(arguments[3])) / 4.0 * 1000);
        byte count = 0;

        if(number < 0) {
            number *= -1;
        }

        while (number > 0) {
            number &= (number - 1);
            count++;
        }

        return count;
    }

    /** Calculates the value of a function and saves
     * result in collection {@linkplain ViewResult#items}
     *
     * @param argumentsStep - argument increment
     */
    public void init(double argumentsStep) {
        double []arguments = new double[]{ 10, 100, 50, 500 };

        for(Item2d item: items) {
            item.setOnesNumberAndArguments(calc(arguments), arguments.clone());

            for(int i = 0; i < 4; i++) {
                arguments[i] += argumentsStep;
            }
        }
    }

    /** Calls <b>init(double argumentsStep)</b>  with random argument value<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init(Math.random() * 180.0);
    }

    /** Method Implementation {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /** Method Implementation {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }

    /** Method Implementation {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }

    /** Method Implementation {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for(Item2d item : items) {
            System.out.println(item);
        }
    }

    /** Method Implementation {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    /** Method Implementation {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
