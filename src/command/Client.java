package command;

/**
 * Created by God on 2016/5/1.
 */
public class Client {
    public static void main(String[] args) {
        Reciver reciver = new Reciver();
        Command command = new PlayCommand(reciver);

        Command stopCommand = new StopCommand(reciver);

        Invoker invoker = new Invoker();
        invoker.setPlay(command);
        invoker.setStop(stopCommand);

        invoker.play();
        invoker.stop();

        MacroAudioCommand macroAudioCommand = new MacroAudioCommand();

        macroAudioCommand.add(command);
        macroAudioCommand.add(stopCommand);

        macroAudioCommand.excute();

    }
}
