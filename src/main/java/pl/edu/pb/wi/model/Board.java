package pl.edu.pb.wi.model;

import java.util.ArrayList;

public class Board {
    private ArrayList<DifficultyLevel> difficultyLevels;

    public Board(Integer amountOfDifficultyLevels) {
        difficultyLevels = new ArrayList<>();
        for (int i = 1; i <= amountOfDifficultyLevels; i++) {
            difficultyLevels.add(new DifficultyLevel());
        }
    }
}
