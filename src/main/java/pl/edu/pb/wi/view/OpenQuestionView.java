package pl.edu.pb.wi.view;

import pl.edu.pb.wi.model.question.OpenQuestion;
import pl.edu.pb.wi.model.question.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class OpenQuestionView extends JPanel {
    public OpenQuestionView(List<Question> openQuestions) {
        super();

        setLayout(new GridLayout(5, 1, 10, 10));
        JLabel questionContent = new JLabel(openQuestions.iterator().next().getContent());
        questionContent.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        add(questionContent);
        JTextField jTextField =new JTextField();
        add(jTextField);
        Button button=new Button("Ok");
        add(button);

        setVisible(true);

    }
}
