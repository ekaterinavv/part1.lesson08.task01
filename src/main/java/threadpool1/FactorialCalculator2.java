package threadpool1;

import dto.ResultDTO;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator2 {
    public static ResultDTO start(List<Integer> numbers, int numberThreads) {
        Instant start = Instant.now();
        ExecutorService service = Executors.newFixedThreadPool(numberThreads);
        ConcurrentSkipListMap<Integer, BigInteger> map = new ConcurrentSkipListMap<>();
        for (Integer number : numbers) {
            service.execute(new MyThread(map, number));
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        return new ResultDTO(map, elapsed);
    }
}
