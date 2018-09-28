package designPattern.templateMethod;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class ZhangDayRouter extends DayRouter {
    @Override
    public String wakeUp() {
        return "张先生起床";
    }

    @Override
    public String eatBreakfast() {
        return "张先生吃早饭";
    }

    @Override
    public String eatBranch() {
        return "张先生吃午饭";
    }

    @Override
    public String eatDininer() {
        return "张先生吃晚饭";
    }
}
