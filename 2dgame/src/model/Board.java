package model;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private Image space;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = space.getWidth(this);
        int h =  space.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/resources/space.jpg");
        space = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(space, 0, 0, null);
    }
}
