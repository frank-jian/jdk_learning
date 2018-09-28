package reflect.tutorial;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jianweilin
 * @date 2018/9/28
 */
public class ClassDemo {

    
    public static void test_001(){
        List<String> list = new ArrayList<>();
        Class clazz = list.getClass();
        int count = clazz.getMethods().length;
        System.out.printf("count = %d name = %s \n",count, clazz.getName());
    }

    public static void test_002(){
        Class clazz = Array.class;
        System.out.printf("name = %s \n", clazz.getName());
    }

    public static void test_003(){
        try {
            Class clazz = Class.forName("java.lang.reflect.Array");
            System.out.printf("name = %s \n", clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据类名实例化的方式一
     */
    public static void test_004(){
        Class clazz = Array.class;
        try {
            clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据类名实例化的方式二
     */
    public static void test_005(){
        Class clazz = Array.class;
        try {
            clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
