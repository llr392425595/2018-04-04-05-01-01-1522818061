package tw.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
  @Test
  public void should_get_true_when_given_correct_numStr() {
    InputValidator inputValidator = new InputValidator();

    String numStr = "1 2 3 4";
    boolean result = inputValidator.validate(numStr);
    assertTrue(result);
  }

  @Test
  public void should_get_true_when_given_same_digit() {
    InputValidator inputValidator = new InputValidator();

    String numStr = "1 2 3 2";
    boolean result = inputValidator.validate(numStr);
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_num_is_not_single_digit() {
    InputValidator inputValidator = new InputValidator();

    String numStr = "1 11 3 4";
    boolean result = inputValidator.validate(numStr);
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_digits_count_is_less_than_4() {
    InputValidator inputValidator = new InputValidator();

    String numStr = "1 2 3 ";
    boolean result = inputValidator.validate(numStr);
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_digits_count_is_more_than_4() {
    InputValidator inputValidator = new InputValidator();

    String numStr = "1 2 3 4 5";
    boolean result = inputValidator.validate(numStr);
    assertFalse(result);
  }

}
