package pl.edu.pb.wi.model.question;

import pl.edu.pb.wi.model.Prototype;

public class OpenQuestion extends Question {
    private String correctAnswer;

    public OpenQuestion(String content, String correctAnswer) {
        super(content,QuestionType.OPEN);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(Object givenAnswer) {
        return false;
    }

    @Override
    public Integer getPoint() {
        return null;
    }

    @Override
    public Prototype clone() {
        return null;
    }
}
