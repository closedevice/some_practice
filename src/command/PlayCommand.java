package command;

/**
 * Created by God on 2016/5/1.
 */
public class PlayCommand implements Command {
    Reciver reciver;

    public PlayCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void excute() {
        reciver.play();

    }
}
