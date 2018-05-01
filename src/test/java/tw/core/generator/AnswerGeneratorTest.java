package tw.core.generator;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

  private RandomIntGenerator mockedRandomIntGenerator;


  @Before
  public void setUp() {
    mockedRandomIntGenerator = mock(RandomIntGenerator.class);
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void should_throw_outOfRangeAnswerException_when_digit_more_than_9()
      throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");

    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 11");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();
  }

  @Test
  public void should_throw_outOfRangeAnswerException_when_digit_number_more_than_4()
      throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");
    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4 5");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();
  }

  @Test
  public void should_throw_outOfRangeAnswerException_when_digit_number_less_than_4()
      throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");
    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();
  }

  @Test
  public void should_throw_outOfRangeAnswerException_when_have_same_digit()
      throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");
    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 2 3 4");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();
  }

  @Test
  public void should_return_a_numList()
      throws OutOfRangeAnswerException {

    when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");

    AnswerGenerator answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
    Answer answer = answerGenerator.generate();

    Assert.assertEquals("1 2 3 4", answer.toString());
  }
}

