package threadpool1;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyThread implements Runnable {
    ConcurrentSkipListMap<Integer, BigInteger> map;
    Integer n;
    BigInteger factorial = BigInteger.valueOf(1);

    public MyThread(ConcurrentSkipListMap<Integer, BigInteger> map, Integer n) {
        this.map = map;
        this.n = n;
    }

    @Override
    public void run() {
        Integer start = map.floorKey(n);
        if (start == null) {
            start = 0;
        } else {
            factorial = map.get(start);
        }
        for (int i = start + 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        map.put(n, factorial);
    }
}
