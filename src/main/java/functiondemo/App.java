package functiondemo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author jianweilin
 * @date 2018/8/15
 */
public class App {

    public static void main(String[] args) {
        Function<Employee,String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };

        List<Employee> employees = Arrays.asList(new Employee("Janes",12),
                new Employee("Tom",21),new Employee("Lisa",22));

        List<String> name = convertEmpList(employees,funcEmpToString);
        System.out.println(String.format("name = %s", JSON.toJSONString(name)));
    }

    public static List<String> convertEmpList(List<Employee> employees, Function<Employee, String> funcEmpToString){
        List<String> list = new ArrayList<>();
        for (Employee e: employees){
            list.add(funcEmpToString.apply(e));
        }
        return list;
    }

}
