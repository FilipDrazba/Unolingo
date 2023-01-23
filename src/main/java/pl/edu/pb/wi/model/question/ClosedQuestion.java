package pl.edu.pb.wi.model.question;

import lombok.Getter;
import pl.edu.pb.wi.model.Prototype;

import java.util.List;

@Getter
public class ClosedQuestion extends Question {
    private List<String> answers;
    private Integer correctAnswer;

    @Override
    public boolean checkAnswer(Object givenAnswer) {
        if (correctAnswer.equals(givenAnswer)) {
            pointAwarded = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getPoint() {
        if (pointAwarded) {
            if (cloned)
                return 0.5;
            else
                return 1d;
        } else
            return 0d;
    }

    @Override
    public Prototype clone() {
        ClosedQuestion clone = new ClosedQuestion(content, correctAnswer, answers);//shallow copy
        clone.cloned = true;
        return clone;
    }

    public ClosedQuestion(String content, Integer correctAnswer, List<String> answers) {
        super(content, QuestionType.CLOSED);
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }
}
