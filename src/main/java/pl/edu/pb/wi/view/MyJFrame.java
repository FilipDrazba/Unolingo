package pl.edu.pb.wi.view;

import javax.swing.*;

import static pl.edu.pb.wi.shared.Static.FRAME_HIGH;
import static pl.edu.pb.wi.shared.Static.FRAME_WIDTH;

public class MyJFrame extends JFrame {
    public static int counter = 0;

    MyJFrame() {
        super("Unolingo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HIGH);
        setLocation(counter * FRAME_WIDTH, 0);
        counter++;
    }
}
