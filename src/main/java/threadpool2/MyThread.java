package threadpool2;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class MyThread implements Runnable {
    Map<Integer, BigInteger> map;
    List<Integer> numbers;
    int start;
    int finish;
    BigInteger factorial;

    public MyThread(Map<Integer, BigInteger> map, List<Integer> numbers, int start, int finish) {
        this.map = map;
        this.numbers = numbers;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        int iPrev = 1;
        factorial = BigInteger.valueOf(1);
        for (int i = start; i < finish; i++) {
            for (int j = iPrev + 1; j <= numbers.get(i); j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }
            iPrev = numbers.get(i);
            map.put(numbers.get(i), factorial);
        }
    }
}
