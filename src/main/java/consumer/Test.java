package consumer;

import com.alibaba.fastjson.JSON;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(IntStream.range(0,10).asLongStream().boxed().collect(Collectors.toList())));

        int i = 5;
        System.out.println(i++ == 6);

        int j = 5;
        System.out.println(++j == 6);
    }
}
