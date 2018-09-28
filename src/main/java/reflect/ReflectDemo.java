package reflect;

import atom.AtomicDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jianweilin
 * @date 2018/5/22
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        Proxy target = new Proxy();
//        Method method = Proxy.class.getDeclaredMethod("run");
//        method.invoke(target);
        new ReflectDemo().test_001();
    }

    /**
     * 反射(仅仅通过包名，调用方法；)
     */
    public void test_001() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("atom.AtomicDemo");
        Constructor c = clazz.getConstructor();
        AtomicDemo p = (AtomicDemo) c.newInstance();
        Method method = p.getClass().getDeclaredMethod("add");
        method.invoke(p);
    }

    static class Proxy {
        public void run(){
            System.out.println("reflect run!");
        }
    }

}
