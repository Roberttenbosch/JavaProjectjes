package model.sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends BaseSprite
{
    private int dx;
    private int dy;
    private int fire = 20;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);
        initSpaceShip();
    }

    private void initSpaceShip() {
        missiles = new ArrayList<>();
       loadImage("src/resources/images/craft.png");

    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
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

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    private void fire(){
        missiles.add(new Missile(x + width, y + height / 2));
    }
    public void fakeKeyPress(){
        dx = 2;
        if(getX() > 400){
            setX(0);
        }


        if(fire == 20){
            fire();
        }
        fire--;
        if(fire == 0){
            fire = 20;
        }

    }
}
