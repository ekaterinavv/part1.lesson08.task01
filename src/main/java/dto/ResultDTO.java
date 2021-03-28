package dto;

import java.math.BigInteger;
import java.util.Map;

public class ResultDTO {
    long elapsed;
    Map<Integer, BigInteger> map;

    public ResultDTO(Map<Integer, BigInteger> map, long elapsed) {
        this.elapsed = elapsed;
        this.map = map;
    }

    public long getElapsed() {
        return elapsed;
    }

    public Map<Integer, BigInteger> getMap() {
        return map;
    }
}
