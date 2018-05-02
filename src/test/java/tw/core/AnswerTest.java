package tw.core;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
  private Answer correctAnswer;
  private Answer excessOfQuantityAnswer;
  private Answer containLettersAnswer;
  private Answer repeatingElementsAnswer;

  @Before
  public void setUp() throws Exception {
    correctAnswer = Answer.createAnswer("1 2 3 4");
    excessOfQuantityAnswer = Answer.createAnswer("1 2 3 4 5");
    containLettersAnswer = Answer.createAnswer("1 2 3 a");
    repeatingElementsAnswer = Answer.createAnswer("1 2 3 3 4");
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void createAnswerTest() {
    Assert.assertEquals(correctAnswer.toString(),"1 2 3 4");
    Assert.assertEquals(excessOfQuantityAnswer.toString(),"1 2 3 4 5");
    Assert.assertEquals(containLettersAnswer.toString(),"1 2 3 a");
    Assert.assertEquals(repeatingElementsAnswer.toString(),"1 2 3 3 4");
  }

  @Test
  public void validate_correctAnswer_should_not_throw_exception() throws OutOfRangeAnswerException {
    correctAnswer.validate();
  }

  @Test
  public void validate_excessOfQuantityAnswer_should_throw_OutOfRangeAnswerException() throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");
    excessOfQuantityAnswer.validate();
  }

  @Test
  public void validate_containLettersAnswer_should_throw_OutOfRangeAnswerException() throws OutOfRangeAnswerException {
    thrown.expect(NumberFormatException.class);
    containLettersAnswer.validate();
  }

  @Test
  public void validate_repeatingElementsAnswer_should_throw_OutOfRangeAnswerException() throws OutOfRangeAnswerException {
    thrown.expect(OutOfRangeAnswerException.class);
    thrown.expectMessage("Answer format is incorrect");
    repeatingElementsAnswer.validate();
  }

  private void validateInputAnswerStr(String inputAnswerStr,String expectValue) {
    Answer inputAnswer = Answer.createAnswer(inputAnswerStr);
    Record result = correctAnswer.check(inputAnswer);
    String res = result.toString();
    assertThat(res, is(expectValue));
  }

  @Test
  public void should_return_0A0B_when_no_number_is_correct() {
    //when
    String inputAnswerStr = "5 6 7 8";
    String expectValue = "0A0B";

    //then
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_4A0B_when_all_numbers_are_correct() {
    //when
    String inputAnswerStr = "1 2 3 4";
    String expectValue = "4A0B";

    //then
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_0A4B_when_all_numbers_are_include_() {
    //when
    String inputAnswerStr = "5 6 7 8";
    String expectValue = "0A0B";

    //then
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_1A1B_when_1_number_correct_and_1_number_include() {
    //when
    String inputAnswerStr = "1 3 5 6";
    String expectValue = "1A1B";

    //then
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }
}