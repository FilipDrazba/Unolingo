package pl.edu.pb.wi.model.creator;

import pl.edu.pb.wi.base.MyIteratorImpl;
import pl.edu.pb.wi.model.MyIterator;
import pl.edu.pb.wi.model.question.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class Creator {
    protected MyIterator iterator;

    protected Creator(String key) {
        this.iterator = new MyIteratorImpl(key);
    }

    protected void setKey(String key) {
        this.iterator = new MyIteratorImpl(key);
    }

    public abstract Question createQuestion();

    public List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            questions.add(createQuestion());
        return questions;
    }
}
