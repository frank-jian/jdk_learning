package functiondemo;

import java.util.function.*;

/**
 * @author jianweilin
 * @date 2018/8/13
 */
public class FunctionDemo {
    /**
     * BiConsumer<T,U>
     * T、U 均为入参，无返回值
     */
    public static void biConsumer() {
        BiConsumer<String, String> consumer = (x, y) -> {
            System.out.println(String.format("x = %s,y=%s", x, y));
        };
        consumer.accept("test01", "test02");
    }

    /**
     * BiFunction<T,U,R>
     * T,U 为入参，R为返回值
     */
    public static void biFunction() {
        BiFunction<String, String, String> bi = (x, y) -> {
            return x + y;
        };

        System.out.println(bi.apply("jian", ".com"));
    }

    /**
     * BiPredicate<T,U>
     * T，U 为入参，Boolean会返回值
     */
    public static void biPredicate() {
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        BiPredicate<Integer, Integer> eq = (x, y) -> x - 2 > y;

        System.out.println(bi.test(2, 3));
        System.out.println(bi.and(eq).test(2, 3));
    }

    /**
     * BinaryOperator<T>
     * 两个入参，得到一个返回值
     */
    public static void binaryOperator() {
        BinaryOperator<Integer> operator = (n1, n2) -> n1 + n2;
        System.out.println(operator.apply(3,4));
    }

    /**
     * 返回一个boolean类型
     */
    public static void booleanSupplier(){
        BooleanSupplier bs = () -> true;
        System.out.println(bs.getAsBoolean());
    }

    /**
     * 一个函数接受一个入参，无返回值
     */
    public static void consumer(){
        Consumer<String> c = (x) -> System.out.println(x.toUpperCase());
        c.accept("hello world!");
    }

    /**
     * Function<T,R>
     * 接受一个参数，并得到一个返回结果
     */
    public static void function(){
        Function<Integer,String> converter = (i) -> Integer.toString(i);
        System.out.println(converter.apply(3).length());
        System.out.println(converter.apply(30).length());
    }

    public static void main(String[] args) {
        function();
    }
}
