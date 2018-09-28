package designPattern.command.example;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class LightsOnCommand implements Command{
    private Lights lights;

    public LightsOnCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.lightsOn();
    }
}
