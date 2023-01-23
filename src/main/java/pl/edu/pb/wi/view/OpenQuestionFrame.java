package pl.edu.pb.wi.view;


import pl.edu.pb.wi.model.question.OpenQuestion;
import pl.edu.pb.wi.model.question.Question;
import pl.edu.pb.wi.shared.Static;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class OpenQuestionFrame extends JFrame {
    public OpenQuestionFrame(List<Question> openQuestions, double amountOfPoints) {
        super();
        setLocation(Static.FRAME_WIDTH, 495);
        OpenQuestion thisQuestion = (OpenQuestion) openQuestions.iterator().next();

        setLayout(new GridLayout( 3, 1, 10, 10));
        JLabel points = new JLabel("Ilość punktów: " + amountOfPoints + "/5");
        points.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        add(points);

        JPanel jPanel=new JPanel();

        JLabel questionContent1 = new JLabel(thisQuestion.getContent());
        questionContent1.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        jPanel.add(questionContent1);

        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        jTextField.setPreferredSize(new Dimension(300, FONT_SIZE));
        jPanel.add(jTextField);

        JLabel questionContent2 = new JLabel(thisQuestion.getContent2());
        questionContent2.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        jPanel.add(questionContent2);

        add(jPanel);

        JButton button = new JButton("Next");
        button.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        button.addActionListener(e -> {
            try {
                if (jTextField.getText().equals(""))
                    throw new IllegalArgumentException();
                if (!thisQuestion.checkAnswer(jTextField.getText())
                        && !thisQuestion.isCloned()) {
                    openQuestions.add((Question) thisQuestion.clone());
                }
                openQuestions.remove(thisQuestion);
                if (!openQuestions.isEmpty()) {
                    new OpenQuestionFrame(openQuestions,
                            thisQuestion.checkAnswer(jTextField.getText())
                                    ? amountOfPoints + thisQuestion.getPoint()
                                    : amountOfPoints);
                }
                dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Please provide an answer first.");
            }
        });
        add(button);
        pack();
        setVisible(true);

    }
}

