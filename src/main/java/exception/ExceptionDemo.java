package exception;

import java.io.IOException;

/**
 * @author jianweilin
 * @date 2018/4/2
 */
public class ExceptionDemo {
    /**
     * 运行时异常为
     */
    public void test_001(){
        throw new NullPointerException();
    }

    /**
     * 非运行时异常为受检异常，必须要处理的；
     */
    public void test_002(){
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
