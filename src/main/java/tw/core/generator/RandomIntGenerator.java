package tw.core.generator;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class RandomIntGenerator {

    private static final String EXCEPTION_MESSAGE = "Can't ask for more numbers than are available";
    private static final String SPACE = " ";

    public RandomIntGenerator() {}

    public String generateNums(Integer digitMax, Integer numbersOfNeed) {
        if (digitMax < numbersOfNeed) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        Set<String> generated = new LinkedHashSet<>();
        while (generated.size() < numbersOfNeed) {
            generated.add(((Integer) new Random().nextInt(digitMax)).toString());
        }
        return String.join(SPACE, generated);
    }
}
