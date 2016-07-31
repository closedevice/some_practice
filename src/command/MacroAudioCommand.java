package command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by God on 2016/5/1.
 */
public class MacroAudioCommand implements MacroCommand {
    List<Command> commandList;

    public MacroAudioCommand() {
        commandList = new ArrayList<>();
    }

    @Override
    public void add(Command command) {
        commandList.add(command);
    }

    @Override
    public void remove(Command command) {

        commandList.remove(command);
    }

    @Override
    public void excute() {
        for (Command command : commandList) {
            command.excute();
        }
    }
}
