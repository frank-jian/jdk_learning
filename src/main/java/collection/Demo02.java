package collection;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author jianweilin
 * @date 2018/3/17
 */
public class Demo02 {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4};
        Integer[] newNums = Arrays.copyOf(nums,10);
        System.out.println(nums.length);
        System.out.println(newNums.length);
        System.out.println(JSON.toJSONString(newNums));

        System.out.println(Integer.MAX_VALUE + 2);
    }
}
