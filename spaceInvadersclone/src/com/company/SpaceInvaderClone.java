package com.company;

import com.company.game.GameBoard;

import javax.swing.*;
import java.awt.*;

public class SpaceInvaderClone extends JFrame implements CommonConstants
{
    public SpaceInvaderClone(){
        initUI();
    }

    private void initUI()
    {
        add(new GameBoard());
        setTitle("Space Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SpaceInvaderClone ex = new SpaceInvaderClone();
            ex.setVisible(true);
        });
    }
}

