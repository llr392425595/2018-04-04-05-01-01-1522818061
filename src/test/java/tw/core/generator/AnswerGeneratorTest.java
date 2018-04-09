package tw.core.generator;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
  @Test(expected = OutOfRangeAnswerException.class)
  public void should_throw_outOfRangeAnswerException_when_digit_more_than_9()
      throws OutOfRangeAnswerException {
    RandomIntGenerator mockedRandomIntGenerator = mock(RandomIntGenerator.class);
    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 11");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();
  }

  @Test
  public void should_return_a_numList()
      throws OutOfRangeAnswerException {
    RandomIntGenerator mockedRandomIntGenerator = mock(RandomIntGenerator.class);
    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();

    assertTrue(answer.getIndexOfNum("2") == 1);
  }
}

