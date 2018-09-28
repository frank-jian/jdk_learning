package designPattern.command.example;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class LightsOffCommand implements Command {
    private Lights lights;

    public LightsOffCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.lightsOff();
    }
}
