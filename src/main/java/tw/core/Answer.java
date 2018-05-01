package tw.core;

import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Answer {

  private static final String SPACE = " ";
  private static final String ANSWER_INCORRECT = "Answer format is incorrect";
  private List<String> numList;

  public void setNumList(List<String> numList) {
    this.numList = numList;
  }

  public Answer(List<String> numList) {
    this.numList = numList;
  }

  public static Answer createAnswer(String inputStr) {
    List<String> inputList = Arrays.stream(inputStr.split(SPACE)).collect(Collectors.toList());
    return new Answer(inputList);
  }

  public void validate() throws OutOfRangeAnswerException {
    if (numList.size() > numList.stream()
        .map(Integer::parseInt)
        .distinct()
        .filter(num -> num < 10).count() || numList.size() != 4) {
      throw new OutOfRangeAnswerException(ANSWER_INCORRECT);
    }
  }

  public Record check(Answer inputAnswer) {
    Record record = new Record();
    this.numList.forEach(num -> {
      int index = inputAnswer.getIndexOfNum(num);
      if (index == -1) {
        return;
      }
      if (index == getIndexOfNum(num)) {
        record.increaseCurrentNum();
      } else {
        record.increaseIncludeOnlyNum();
      }
    });
    return record;
  }

  private int getIndexOfNum(String num) {
    return this.numList.indexOf(num);
  }

  @Override
  public String toString() {
    return String.join(SPACE, numList);
  }
}
