package tw.commands;

import tw.core.Answer;
import tw.validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GuessInputCommand implements InputCommand {

    private static final String START_CONMMAND = "------Please input your answer as x x x x , x <10 ------";
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public GuessInputCommand() { }

    @Override
    public Answer input() throws IOException {
        System.out.println(START_CONMMAND);
        String input = bufferedReader.readLine();
        return new InputValidator().validate(input) ? Answer.createAnswer(input) : input();
    }
}
