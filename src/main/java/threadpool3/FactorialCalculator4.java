package threadpool3;

import dto.ResultDTO;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class FactorialCalculator4 {
    public static ResultDTO start(List<Integer> numbers, int numberThreads) throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        ExecutorService service = Executors.newFixedThreadPool(numberThreads);
        List<Future<Object>> futures = new ArrayList<>();
        for (Integer number : numbers) {
            MyThread task = new MyThread(number);
            futures.add(service.submit(task));
        }
        //111futures = service.invokeAll(tasks);
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
        Map<Integer, BigInteger> map = new HashMap<>();
        for (Future future : futures) {
            Map<Integer, BigInteger> result = (HashMap<Integer, BigInteger>) future.get();
            map.putAll(result);
        }
        System.out.println(map);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        return new ResultDTO(map, elapsed);
    }
}
