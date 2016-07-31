package command;

/**
 * Created by God on 2016/5/1.
 */
public class StopCommand implements Command {
    Reciver reciver;

    public StopCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void excute() {

        reciver.stop();

    }
}
