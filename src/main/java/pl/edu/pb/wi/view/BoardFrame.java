package pl.edu.pb.wi.view;

import pl.edu.pb.wi.model.Level;
import pl.edu.pb.wi.model.creator.ClosedQuestionFactory;
import pl.edu.pb.wi.model.creator.OpenQuestionFactory;

import javax.swing.*;
import java.awt.*;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class BoardFrame extends MyJFrame {

    public BoardFrame(Integer amountOfDifficultyLevels,
                      Integer amountOfLevelsInEachDifficultyLevel) {
        super();
        setLayout(new GridLayout(amountOfDifficultyLevels * 2,
                amountOfLevelsInEachDifficultyLevel, 10, 10));
        for (int i = 1; i <= amountOfDifficultyLevels; i++) {
            JLabel diff = new JLabel("Diff %d:".formatted(i));
            diff.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
            add(diff);
            for (int j = 0; j < amountOfLevelsInEachDifficultyLevel - 1; j++)
                add(new JLabel(""));
            for (int j = 1; j <= amountOfLevelsInEachDifficultyLevel; j++) {
                JButton button = new JButton("%d.%d".formatted(i, j));
                button.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
                add(button);

                button.addActionListener(e -> {
                    String key = button.getText();
                    Level level;
                    switch (key.substring(0, 1)) {
                        case "1":
                            level = new Level(key, ClosedQuestionFactory.getInstance(key));
                            new ClosedQuestionFrame(level.getQuestions(), 0);
                            break;

                        case "2":
                            level = new Level(key, OpenQuestionFactory.getInstance(key));
                            new OpenQuestionFrame(level.getQuestions(),0);
                            break;
                    }
                });
            }
        }

        setVisible(true);
    }
}
