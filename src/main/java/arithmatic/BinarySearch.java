package arithmatic;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 二分法
 * @author jianweilin
 * @date 2018/6/10
 */
public class BinarySearch {
    public static int rank(int key,Integer[] a){
        int lo = 0;
        int hi = a.length -1 ;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2; // 这里有个坑，如果采用「(lo + hi) / 2 会有溢出的情况 」就是会溢出；
            if(a[mid] > key){
                hi = mid;
            }else if(a[mid] < key){
                lo = mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] nums = Arrays.asList(2,4,5,7,1,3,8,10,9).toArray(new Integer[]{});
        Arrays.sort(nums);
        System.out.println("sort nums => " + JSON.toJSONString(nums));

        System.out.println("8 binary search in index " + rank(8,nums));

    }
}
