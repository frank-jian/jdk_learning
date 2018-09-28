package functiondemo;

/**
 * @author jianweilin
 * @date 2018/8/15
 */
@FunctionalInterface
public interface DefinedFunction<T> {
    T consume(String url);
}

