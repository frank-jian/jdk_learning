package arithmatic;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * N * (N -1)/2 -- 时间复杂度
 * 选择排序；找到最小的数与第一位交换位置；
 * @author jianweilin
 * @date 2018/6/10
 */
public class Selection {
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(less(a[j],a[min])) {
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }

    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] nums = Arrays.asList(1,9,4,5,6,2,3,7,8).toArray(new Integer[]{});
        sort(nums);
        System.out.println("nums => " + JSON.toJSONString(nums));
    }

}
