package threadpool3;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyThread implements Callable {
    Integer n;
    BigInteger factorial;

    public MyThread(int n) {
        this.n = n;
        factorial = new BigInteger("1");
    }

    @Override
    public Object call() {
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        Map result = new HashMap<Integer, BigInteger>();
        result.put(n, factorial);
        return result;
    }

    public Integer getN() {
        return n;
    }
}