import cycle.FactorialCalculator1;
import dto.ResultDTO;
import threadpool1.FactorialCalculator2;
import threadpool2.FactorialCalculator3;
import threadpool3.FactorialCalculator4;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = 4000;
        int numberThreads = 4;
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(n);
        numbers.add(0);
        for (int i = 0; i <= n; i++) {
            numbers.add(random.nextInt(1000) + 19000);
        }
        numbers.add(0);
        ResultDTO resultDTO1 = FactorialCalculator1.start(numbers, numberThreads);
        ResultDTO resultDTO2 = FactorialCalculator2.start(numbers, numberThreads);
        ResultDTO resultDTO3 = FactorialCalculator3.start(numbers, numberThreads);
        ResultDTO resultDTO4 = FactorialCalculator4.start(numbers, numberThreads);
        System.out.println("Without threads in: time = " + resultDTO1.getElapsed() + ", ms");
        System.out.println("With ConcurrentSkipListMap(floor): time = " + resultDTO2.getElapsed() + " , ms");
        System.out.println("With ConcurrentHashMap: time = " + resultDTO3.getElapsed() + " , ms");
        System.out.println("Сalculating each number in thread : time = " + resultDTO4.getElapsed() + " , ms");
        System.out.println("Equals result1 with result2 = " + resultDTO1.getMap().equals(resultDTO2.getMap()));
        System.out.println("Equals result1 with result3 = " + resultDTO1.getMap().equals(resultDTO3.getMap()));
        System.out.println("Equals result2 with result4 = " + resultDTO2.getMap().equals(resultDTO4.getMap()));
    }
}