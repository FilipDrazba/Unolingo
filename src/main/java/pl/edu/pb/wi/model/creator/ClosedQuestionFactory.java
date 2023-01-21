package pl.edu.pb.wi.model.creator;

import pl.edu.pb.wi.model.question.ClosedQuestion;
import pl.edu.pb.wi.model.question.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ClosedQuestionFactory extends Creator {

    private static final ClosedQuestionFactory INSTANCE = new ClosedQuestionFactory("1.1");

    private ClosedQuestionFactory(String key) {
        super(key);
    }

    public static ClosedQuestionFactory getInstance(String key) {
        INSTANCE.setKey(key);
        return INSTANCE;
    }

    @Override
    public Question createQuestion() {
        String record = iterator.getNext();
        StringTokenizer stringTokenizer = new StringTokenizer(record, ";");
        String content = stringTokenizer.nextToken();
        Integer numberOfCorrectAnswer = Integer.parseInt(stringTokenizer.nextToken());
        List<String> answers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            answers.add(stringTokenizer.nextToken());
        }

        return new ClosedQuestion(content, numberOfCorrectAnswer, answers);
    }
}
