package pl.edu.pb.wi.model;

import lombok.Getter;
import pl.edu.pb.wi.model.creator.Creator;
import pl.edu.pb.wi.model.question.Question;

import java.util.List;

@Getter
public class Level {
    String name;
    List<Question> questions;

    public Level(String name,
                 Creator creator) {
        this.name = name;
        this.questions = creator.createQuestions();
    }
}
