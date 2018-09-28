package functiondemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jianweilin
 * @date 2018/8/15
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer age;
}
