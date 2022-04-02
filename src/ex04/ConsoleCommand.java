package ex04;
/** Interface
 * console command;
 * шаблон Command
 * @author Vlada
 * @version 1.0
 */
public interface ConsoleCommand extends Command {

    /** command hotkey;
     * pattern Command
     * @return hot key symbol
     */
    public char getKey();
}
