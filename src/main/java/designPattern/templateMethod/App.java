package designPattern.templateMethod;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class App {
    private DayRouter dayRouter;

    public App(DayRouter dayRouter) {
        this.dayRouter = dayRouter;
    }

    public static void main(String[] args) {
        App app = new App(new ZhangDayRouter());
        app.dayRouter.schuduleDailyWorker();
        System.out.println("切换人选");
        app = new App(new LiDayRouter());
        app.dayRouter.schuduleDailyWorker();
    }
}
