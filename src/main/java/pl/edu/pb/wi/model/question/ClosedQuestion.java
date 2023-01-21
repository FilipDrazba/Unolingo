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
        return correctAnswer.equals(givenAnswer);
    }

    @Override
    public Integer getPoint() {
        return null;
    }

    @Override
    public Prototype clone() {
        return null;
    }

    public ClosedQuestion(String content, Integer correctAnswer, List<String> answers) {
        super("Przetłumacz \""+content+"\" na język angielski:", QuestionType.CLOSED);
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }
}
