package collection;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianweilin
 * @date 2018/3/15
 */
public class Demo01 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(null));
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        System.out.println(set.size());
        System.out.println(JSON.toJSONString(set));
    }
}
