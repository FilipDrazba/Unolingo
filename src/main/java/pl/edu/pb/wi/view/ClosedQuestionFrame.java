package pl.edu.pb.wi.view;


import pl.edu.pb.wi.model.question.ClosedQuestion;
import pl.edu.pb.wi.model.question.Question;
import pl.edu.pb.wi.shared.Static;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class ClosedQuestionFrame extends JFrame {

    private final JLabel amountOfPointsLabel;
    private final JLabel contentLabel;
    private final ButtonGroup answerButtons = new ButtonGroup();

    public ClosedQuestionFrame(List<Question> closedQuestions, double amountOfPoints) {
        super();
        ClosedQuestion thisQuestion = (ClosedQuestion) closedQuestions.get(0);

        setLayout(new GridLayout(thisQuestion.getAnswers().size() + 3, 1, 10, 10));
        setLocation(Static.FRAME_WIDTH, 0);

        amountOfPointsLabel = new JLabel("Ilość punktów: " + amountOfPoints + "/5");
        amountOfPointsLabel.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        add(amountOfPointsLabel);

        contentLabel = new JLabel("Przetłumacz \"" + thisQuestion.getContent() + "\" na język angielski:");
        contentLabel.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        add(contentLabel);

        List<String> answers = thisQuestion.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            String text = "%s. %s".formatted((char) (65 + i), answers.get(i));
            JRadioButton button = new JRadioButton(text);
            button.setActionCommand("" + i);
            answerButtons.add(button);
            button.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
            add(button);
        }
        pack();
        setVisible(true);

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        nextButton.addActionListener(e -> {
            try {
                if (!thisQuestion.checkAnswer(Integer.parseInt(answerButtons.getSelection().getActionCommand()))
                        && !thisQuestion.isCloned()) {
                    closedQuestions.add((Question) thisQuestion.clone());
                }

                closedQuestions.remove(thisQuestion);
                if (!closedQuestions.isEmpty())
                    new ClosedQuestionFrame(closedQuestions,
                            thisQuestion.checkAnswer(Integer.parseInt(answerButtons.getSelection().getActionCommand()))
                                    ? amountOfPoints + thisQuestion.getPoint()
                                    : amountOfPoints);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please select an answer first.");
            }
        });
        add(nextButton);
    }
}

