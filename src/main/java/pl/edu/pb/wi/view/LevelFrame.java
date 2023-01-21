package pl.edu.pb.wi.view;

import pl.edu.pb.wi.model.Level;
import pl.edu.pb.wi.model.question.Question;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LevelFrame extends MyJFrame {

    static JFrame f;

    // text areas
    static JTextArea t1, t2;

    public LevelFrame(Level level) {
        super();

        f = new JFrame(level.getName());
        List<String> questionNames = new ArrayList<>();
        for (int i = 1; i <= level.getQuestions().size(); i++) {
            questionNames.add("Question " + i);
        }

        JList<String> questionListRepresentation = new JList<>(questionNames.toArray(new String[0]));
        List<Question> questions = level.getQuestions();
        JPanel questionView;

        questionView = switch (questions.get(0).getQuestionType()) {
            case OPEN -> new OpenQuestionPanel(questions);
            case CLOSED -> new ClosedQuestionPanel(questions);
        };


        // create a splitpane
        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, questionListRepresentation, questionView);

        // add panel
        f.add(sl);

        // set the size of frame
        f.setSize(300, 300);
        f.pack();
        f.show();

    }

}
