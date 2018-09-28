package designPattern.templateMethod;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class LiDayRouter extends DayRouter {

    @Override
    public String wakeUp() {
        return "李先生起床";
    }

    @Override
    public String eatBreakfast() {
        return "李先生吃早饭";
    }

    @Override
    public String eatBranch() {
        return "李先生吃午饭";
    }

    @Override
    public String eatDininer() {
        return "李先生吃晚饭";
    }
}
