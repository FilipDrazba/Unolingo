package pl.edu.pb.wi.controller;

import pl.edu.pb.wi.model.Board;
import pl.edu.pb.wi.view.BoardFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(2);




//        EventQueue.invokeLater(() -> new BoardView(2, 2));
        EventQueue.invokeLater(() -> new BoardFrame(2, 2));
    }
}