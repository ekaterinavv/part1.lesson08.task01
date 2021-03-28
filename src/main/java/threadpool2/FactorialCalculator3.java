package threadpool2;

import dto.ResultDTO;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FactorialCalculator3 {
    public static ResultDTO start(List<Integer> numbers, int numberThreads) throws InterruptedException {
        Instant start = Instant.now();
        Collections.sort(numbers);
        Map<Integer, BigInteger> map = new ConcurrentHashMap<>();
        List<Thread> threads = new ArrayList<>();
        int range = (numbers.size()) / numberThreads;
        for (int i = 0; i < numberThreads; i++) {
            int finishIndex = (i == (numberThreads - 1)) ? numbers.size() : range * (i + 1);
            Thread thread = new Thread(new MyThread(map, numbers, range * i, finishIndex));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(map);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        return new ResultDTO(map, elapsed);
    }
}
