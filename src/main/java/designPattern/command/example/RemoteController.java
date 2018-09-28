package designPattern.command.example;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class RemoteController {
    private Command command;

    public RemoteController(Command command) {
        this.command = command;
    }

    public void changeCommand(Command command){
        this.command = command;
    }

    public void runCommand(){
        command.execute();
    }
}
