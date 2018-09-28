package collection;


import java.util.Hashtable;

/**
 * @author jianweilin
 * @date 2018/3/29
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put(new HashObject(1),1);
        table.put(new HashObject(2),2);
        table.put(new HashObject(3),3);
    }
    static class HashObject implements Comparable<HashMapDemo.HashObject> {
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
        public int compareTo(HashMapDemo.HashObject o) {
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
