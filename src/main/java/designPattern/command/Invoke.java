package designPattern.command;

/**
 * 调用具体的命令
 * @author jianweilin
 * @date 2018/6/10
 */
public class Invoke {
    private ConcreteCommand concreteCommand;

    public Invoke(ConcreteCommand concreteCommand) {
        this.concreteCommand = concreteCommand;
    }

    public void runCommand() {
        concreteCommand.execute();
    }
}
