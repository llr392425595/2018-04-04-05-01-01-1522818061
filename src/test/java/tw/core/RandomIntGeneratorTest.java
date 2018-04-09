package tw.core;


import static junit.framework.TestCase.assertTrue;

import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

  @Test(expected = IllegalArgumentException.class)
  public void should_throw_IllegalArgumentException_when_digitmax_more_than_numbersOfNeed() {
    RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
    randomIntGenerator.generateNums(3, 4);
  }

  @Test
  public void should_get_a_numStr_which_length_is_7() {
    RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
    String numStr = randomIntGenerator.generateNums(9, 4);

    assertTrue(numStr.length() == 7);
  }
}