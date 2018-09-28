package designPattern.templateMethod;

/**
 * 模板方法
 * @author jianweilin
 * @date 2018/6/9
 */
public abstract class DayRouter {
    protected abstract String wakeUp();
    protected abstract String eatBreakfast();
    protected abstract String eatBranch();
    protected abstract String eatDininer();

    public void schuduleDailyWorker(){
        System.out.println(wakeUp());
        System.out.println(eatBreakfast());;
        System.out.println(eatBranch());;
        System.out.println(eatDininer());;
    }
}
