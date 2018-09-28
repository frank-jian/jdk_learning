package arithmatic;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 插入排序O(n^2)
 * @author jianweilin
 * @date 2018/6/10
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 1; i< n; i++) {
            for(int j = i; j > 0 && Selection.less(a[j],a[j-1]); j--){
                Selection.exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = Arrays.asList(1,9,4,5,6,2,3,7,8).toArray(new Integer[]{});
        sort(nums);
        System.out.println("nums => " + JSON.toJSONString(nums));
    }
}
