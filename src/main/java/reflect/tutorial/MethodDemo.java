package reflect.tutorial;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jianweilin
 * @date 2018/9/28
 */
public class MethodDemo {

   public static void test_001(){
       Class clazz = ArrayList.class;
       Method[] methods = clazz.getDeclaredMethods();
       System.out.printf("methods counts = %d \n",methods.length);
       Arrays.asList(methods).forEach(method -> {
           System.out.printf("getDeclaredMethods methods name = %s modifier = %s \n",method.getName(), Modifier.toString(method.getModifiers()));
           method.getParameterTypes();
       });
   }

    public static void main(String[] args) {
        test_001();
    }
}
