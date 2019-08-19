package Visuals;

import Logic.Engine;

import javax.swing.*;
import java.awt.*;

public class Screen implements Runnable {

    private JFrame frame;
    private Engine engine;

    public Screen(Engine engine){
        this.engine = engine;
    }

    @Override
    public void run() {

        frame = new JFrame("bad chess");
        frame.setPreferredSize(new Dimension(1000, 832));
        frame.setResizable(false);

        createComponents(frame.getContentPane());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents(Container c) {

        frame.setLayout(new BorderLayout());
        Board board = new Board(engine);
        frame.add(board);
        frame.addMouseListener(new MouseCheck(engine, board));
        frame.addMouseMotionListener(new MouseCheck(engine, board));

    }
}
