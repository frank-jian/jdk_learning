package reflect.tutorial;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author jianweilin
 * @date 2018/9/28
 */

public class FieldDemo {


    public static void test_001(){
        Class clazz = ArrayList.class;
        Field[] fields = clazz.getDeclaredFields();
        System.out.printf("fields counts = %d \n",fields.length);
        Arrays.asList(fields).forEach(field -> {
            System.out.printf("getDeclaredFields field name = %s \n",field.getName());
        });
    }



    public static void test_002(){
        Class clazz = ArrayList.class;
        Field[] fields = clazz.getFields();
        System.out.printf("field name = %s, fields counts = %d \n",clazz.getName(),fields.length);
        Arrays.asList(fields).forEach(field -> {
            System.out.printf("getFields name = %s \n",field.getName());
        });
    }

    public static void main(String[] args) {
        test_001();
        test_002();
    }

}
