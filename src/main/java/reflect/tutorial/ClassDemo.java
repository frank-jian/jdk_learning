package reflect.tutorial;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jianweilin
 * @date 2018/9/28
 */
public class ClassDemo {

    @Test
    @Description("根据实例获取类名")
    public void test_001(){
        List<String> list = new ArrayList<>();
        Class clazz = list.getClass();
        int count = clazz.getMethods().length;
        System.out.printf("count = %d name = %s \n",count, clazz.getName());
    }


    @Test
    @Description("通过类的方式得到Class对象")
    public void test_002(){
        Class clazz = Array.class;
        System.out.printf("name = %s \n", clazz.getName());
    }

    @Test
    @Description("通过包的全路径获取Class对象")
    public void test_003(){
        try {
            Class clazz = Class.forName("java.lang.reflect.Array");
            System.out.printf("name = %s \n", clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Description("")
    public void test_004(){

    }
}
