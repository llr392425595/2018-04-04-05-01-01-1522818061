package tw.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.model.GuessResult;
import tw.views.GameView;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

  private Game mockGame;
  private GameView mockGameView;
  private GameController mockGameController;
  private InputCommand mockCommand;

  private Answer correctAnswer = Answer.createAnswer("1 2 3 4");
  private Answer errorAnswer = Answer.createAnswer("1 2 5 6");
  @Before
  public void setUp() {
    mockGame = mock(Game.class);
    mockGameView = mock(GameView.class);
    mockCommand = mock(InputCommand.class);

    mockGameController = new GameController(mockGame, mockGameView);
  }

  @Test
  public void should_begin_guess_game_when_call_begin_game() throws Exception {
    mockGameController.beginGame();

    verify(mockGameView).showBegin();
  }


  @Test
  public void test_play() throws IOException {
    //given
    when(mockCommand.input()).thenReturn(correctAnswer);
    when(mockGame.guessHistory()).thenReturn(new ArrayList<>());
    when(mockGame.checkStatus()).thenReturn("");
    when(mockGame.checkCoutinue()).thenReturn(true, false);
    when(mockGame.guess(errorAnswer)).thenReturn(new GuessResult("", errorAnswer));


    //when
    mockGameController.play(mockCommand);

    //then
    verify(mockGameView).showGuessResult(any());
    verify(mockGameView).showGuessHistory(anyList());
    verify(mockGameView).showGameStatus(anyString());
  }

}