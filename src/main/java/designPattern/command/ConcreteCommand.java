package designPattern.command;

/**
 * 命令的具体实现接口，假的，通常调用接收者来实现响应的功能
 * @author jianweilin
 * @date 2018/6/10
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
