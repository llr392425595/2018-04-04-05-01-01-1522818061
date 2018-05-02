package tw.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
  private InputValidator inputValidator;

  @Before
  public final void before() {
    inputValidator = new InputValidator();
  }

  @Test
  public void should_get_true_when_given_correct_numStr() {
    boolean result = inputValidator.validate("1 2 3 4");
    assertTrue(result);
  }

  @Test
  public void should_get_true_when_given_same_digit() {
    boolean result = inputValidator.validate("1 2 3 2");
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_num_is_not_single_digit() {
    boolean result = inputValidator.validate("1 11 3 4");
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_digits_count_is_less_than_4() {
    boolean result = inputValidator.validate("1 2 3 ");
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_given_digits_count_is_more_than_4() {
    boolean result = inputValidator.validate("1 2 3 4 5");
    assertFalse(result);
  }

  @Test
  public void should_get_false_when_have_repeate_digit() {
    boolean result = inputValidator.validate("1 2 3 4 4");
    assertFalse(result);
  }

}
