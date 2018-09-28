package reflect.tutorial;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author jianweilin
 * @date 2018/9/28
 */
public class InvokeMethodDemo {

    /**
     * 关于反射方法的使用
     */
    public static void test_001(){
        Class clazz = ArrayList.class;
        try {

            Method method = clazz.getMethod("add", Object.class);
            Constructor constructor = clazz.getConstructor();

            ArrayList list = (ArrayList) constructor.newInstance();

            method.invoke(list,"测试");
            System.out.println("add value = 测试");

            Method getMethod = clazz.getMethod("get",int.class);
            Object value = getMethod.invoke(list,0);
            System.out.println("value = " + value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射方法调用方式二
     */
    public static void test_002(){
        System.out.println(">>>>>> test_002 >>>>>>>");
        Class clazz = ArrayList.class;

        try {
            ArrayList instance = (ArrayList) clazz.newInstance();
            Method method = clazz.getMethod("add", Object.class);
            method.setAccessible(true);
            method.invoke(instance,"测试");
            System.out.println("add value = 测试");

            Method getMethod = clazz.getMethod("get",int.class);
            Object value = getMethod.invoke(instance,0);
            System.out.println("get value = " + value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    /**
     * 忽略访问权限，执行反射方法；
     */
    public static void test_003(){
        Class clazz = AccessDemo.class;
        try {
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(clazz.newInstance());

            Method publicMethod = clazz.getDeclaredMethod("publicMethod");
            publicMethod.setAccessible(false);
            publicMethod.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("1");
        test_003();
    }
}
