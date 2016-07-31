package command;

/**
 * Created by God on 2016/5/1.
 */
public class Invoker {

    private PlayCommand playCommand;
    private StopCommand stopCommand;

    public void setPlay(Command command) {
        playCommand = (PlayCommand) command;

    }

    public void setStop(Command command) {

        stopCommand = (StopCommand) command;
    }

    public void play() {
        playCommand.excute();

    }

    public void stop() {
        stopCommand.excute();

    }
}
