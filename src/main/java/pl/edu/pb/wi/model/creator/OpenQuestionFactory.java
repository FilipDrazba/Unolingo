package pl.edu.pb.wi.model.creator;

import pl.edu.pb.wi.model.question.OpenQuestion;
import pl.edu.pb.wi.model.question.Question;

import java.util.StringTokenizer;

public class OpenQuestionFactory extends Creator {

    private static final OpenQuestionFactory INSTANCE = new OpenQuestionFactory("2.1");

    public OpenQuestionFactory(String key) {
        super(key);
    }

    public static Creator getInstance(String key) {
        INSTANCE.setKey(key);
        return INSTANCE;
    }

    @Override
    public Question createQuestion() {
        String recordFromFile = iterator.getNext();
        StringTokenizer stringTokenizer = new StringTokenizer(recordFromFile, ";");

        String content = stringTokenizer.nextToken();
        String correctAnswer = stringTokenizer.nextToken();

        return new OpenQuestion(content, correctAnswer);
    }
}
