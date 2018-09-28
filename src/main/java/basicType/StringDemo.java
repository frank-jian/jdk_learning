package basicType;

/**
 * @author jianweilin
 * @date 2018/4/1
 */
public class StringDemo {
    public static void stringTest(){
        String str1 = "a" + "b" + 1;
        String str2 = "ab1";
        System.out.println(str1 == str2);
    }

    public static void stringTest2(){
        String str1 = new String("ab1");
        String str2 = "ab1";
        System.out.println(str1 == str2);
    }

    public static void main(String[] args) {
        stringTest();
    }
}
