package com.company.game.sprite;

import java.awt.event.KeyEvent;

public class Player extends BaseSprite
{
    private final int START_Y = 280;
    private final int START_X = 270;

    private final String player_sprite_img_file = "player.png";
    private int width;
    public Player(){
        initPlayer();
    }

    private void initPlayer()
    {
        super.init(player_sprite_img_file);
        setX(START_X);
        setY(START_Y);
    }

    public void act() {

        x += dx;

        if (x <= 2) {
            x = 2;
        }

        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }
}
