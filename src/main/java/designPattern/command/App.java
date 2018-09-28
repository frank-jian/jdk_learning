package designPattern.command;

/**
 * 思考应用场景;
 * @author jianweilin
 * @date 2018/6/10
 */
public class App {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        ConcreteCommand concreteCommand = new ConcreteCommand(receiver);

        Invoke invoke = new Invoke(concreteCommand);
        invoke.runCommand();
    }
}
