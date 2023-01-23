package pl.edu.pb.wi.model.question;

import pl.edu.pb.wi.model.Prototype;

public class OpenQuestion extends Question {
    private String content2;
    private String correctAnswer;

    public OpenQuestion(String content1, String content2, String correctAnswer) {
        super(content1, QuestionType.OPEN);
        this.content2 = content2;
        this.correctAnswer = correctAnswer;
    }

    public String getContent2() {
        return content2;
    }

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
            if (isCloned())
                return 0.5;
            else
                return 1d;
        } else
            return 0d;
    }

    @Override
    public Prototype clone() {
        return null;
    }
}
