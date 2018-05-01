package tw.core.generator;

import com.google.inject.Inject;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class AnswerGenerator {

    private static final int DIGIT_MAX = 9;
    private static final int NUMBERS_OF_NEED = 4;
    private final RandomIntGenerator randomIntGenerator;

    @Inject
    AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate() throws OutOfRangeAnswerException {
        String RandomNumStr = this.randomIntGenerator.generateNums(DIGIT_MAX, NUMBERS_OF_NEED);
        Answer answer = Answer.createAnswer(RandomNumStr);
        answer.validate();
        return answer;
    }
}
