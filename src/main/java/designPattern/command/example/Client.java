package designPattern.command.example;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class Client {
    public static void main(String[] args) {
        // Receiver
        Lights lights = new Lights();

        // ConcretCommand
        LightsOnCommand command = new LightsOnCommand(lights);

        // invoker;
        RemoteController remoteController = new RemoteController(command);
        remoteController.runCommand();

        remoteController.changeCommand(new LightsOffCommand(lights));
        remoteController.runCommand();

    }
}
