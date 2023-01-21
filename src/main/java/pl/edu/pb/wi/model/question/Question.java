package pl.edu.pb.wi.model.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.edu.pb.wi.model.Prototype;

@Getter
@NoArgsConstructor
public abstract class Question implements Prototype {
    protected QuestionType questionType;
    protected String content;
    protected Boolean pointAwarded;

    public String getContent() {
        return content;
    }

    public Question(String content,
                    QuestionType questionType) {
        this.content = content;
        this.questionType=questionType;
        this.pointAwarded=false;
    }

    public abstract boolean checkAnswer(Object givenAnswer);

    @Override
    public Prototype clone(){
        return null;
    }
}
