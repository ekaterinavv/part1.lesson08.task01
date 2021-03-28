package cycle;

import dto.ResultDTO;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorialCalculator1 {
    public static ResultDTO start(List<Integer> numbers, int numberThreads) {
        Instant start = Instant.now();
        Map<Integer, BigInteger> map = new HashMap<>();
        for (Integer number : numbers) {
            BigInteger factorial = BigInteger.valueOf(1);
            for (int j = 1; j <= number; j++) {
                factorial = factorial.multiply(BigInteger.valueOf(j));
            }
            map.put(number, factorial);
        }
        System.out.println(map);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        return new ResultDTO(map, elapsed);
    }

}
