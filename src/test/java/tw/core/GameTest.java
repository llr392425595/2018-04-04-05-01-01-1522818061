package tw.core;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

  private Answer actualAnswer = Answer.createAnswer("1 2 3 4");
  private Game game;

  @Before
  public void setUp() throws OutOfRangeAnswerException {
    AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
    when(answerGenerator.generate()).thenReturn(actualAnswer);

    game = new Game(answerGenerator);
  }

  @Test
  public void result_should_add_to_guessResult() {
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("1 2 3 4"));

    List<GuessResult> guessResults = game.guessHistory();
    assertThat(game.guessHistory().size(),is(2));

    GuessResult result0 = guessResults.get(0);
    assertThat(result0.getResult(),is("0A3B"));
    assertThat(result0.getInputAnswer().toString(),is("2 3 4 5"));

    GuessResult result1 = guessResults.get(1);
    assertThat(result1.getResult(),is("4A0B"));
    assertThat(result1.getInputAnswer().toString(),is("1 2 3 4"));
  }

  @Test
  public void should_get_the_SUCCESS_status_when_input_is_correct() throws Exception {
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("1 2 3 4"));

    String statusOfGame = game.checkStatus();
    assertThat(statusOfGame, is("success"));
  }

  @Test
  public void should_get_the_FAIL_status_when_input_is_over_6() throws Exception {
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 2 3 4"));
    game.guess(Answer.createAnswer("1 4 5 6"));
    game.guess(Answer.createAnswer("2 3 4 6"));
    game.guess(Answer.createAnswer("2 4 5 6"));
    game.guess(Answer.createAnswer("4 5 6 7"));
    game.guess(Answer.createAnswer("4 5 6 8"));

    String statusOfGame = game.checkStatus();
    assertThat(statusOfGame, is("fail"));
  }

  @Test
  public void should_get_the_CONTINUE_status_when_input_is_not_correct_and_less_than_6() throws Exception {
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 2 3 4"));
    game.guess(Answer.createAnswer("1 4 5 6"));

    String statusOfGame = game.checkStatus();
    assertThat(statusOfGame, is("continue"));
  }

  @Test
  public void should_get_true_when_status_is_continue() throws Exception {
    game.guess(Answer.createAnswer("2 3 4 5"));

    assertThat(game.checkCoutinue(), is(true));
  }


  @Test
  public void should_get_false_when_status_is_success() throws Exception {
    game.guess(Answer.createAnswer("1 2 3 4"));

    assertThat(game.checkCoutinue(), is(false));
  }

  @Test
  public void should_get_false_when_status_is_fail() throws Exception {
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));
    game.guess(Answer.createAnswer("2 3 4 5"));

    assertThat(game.checkCoutinue(), is(false));
  }
}
