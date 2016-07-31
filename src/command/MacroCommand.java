package command;

/**
 * Created by God on 2016/5/1.
 */
public interface MacroCommand extends Command {
    void add(Command command);

    void remove(Command command);
}
