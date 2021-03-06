package tw.core;


import static junit.framework.TestCase.assertTrue;

import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

  private RandomIntGenerator randomIntGenerator;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    randomIntGenerator = new RandomIntGenerator();
  }

  @Test
  public void should_throw_IllegalArgumentException_when_digitmax_less_than_numbersOfNeed() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Can't ask for more numbers than are available");
    randomIntGenerator.generateNums(3, 4);
  }

  @Test
  public void should_get_a_numStr_which_length_is_7() {
    String numStr = randomIntGenerator.generateNums(9, 4);
    assertTrue(numStr.length() == 7);
  }
}