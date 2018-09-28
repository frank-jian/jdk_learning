package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianweilin
 * @date 2018/3/21
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<HashObject,Integer> map = new HashMap<>();
        map.put(new HashObject(1),1);
        map.put(new HashObject(2),1);
        map.put(new HashObject(3),1);
        map.put(new HashObject(4),1);
        map.put(new HashObject(5),1);
        map.put(new HashObject(6),1);
        map.put(new HashObject(7),1);
        map.put(new HashObject(8),1);
        map.put(new HashObject(9),1);
        map.put(new HashObject(10),1);
        map.put(new HashObject(11),1);
        map.put(new HashObject(12),1);
        map.put(new HashObject(13),1);
//        map.put(new HashObject(1),1);
//        map.put(new HashObject(1),1);
//        map.put(new HashObject(1),1);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class HashObject implements Comparable<HashObject> {
        private Integer val;

        public HashObject(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        @Override
        public int compareTo(HashObject o) {
            if(null == o){
                return -1;
            }
            return Integer.compare(this.getVal(),o.getVal());
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
