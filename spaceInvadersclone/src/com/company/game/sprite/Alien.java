package com.company.game.sprite;

public class Alien extends BaseSprite
{
    private Bomb bomb;
    private final String alien_sprite_img_file = "alien.png";

    public Alien(int x, int y) {

        initAlien(x, y);
    }

    private void initAlien(int x, int y) {

        super.init(alien_sprite_img_file);
        this.x = x;
        this.y = y;
        bomb = new Bomb(x, y);
    }

    public void act(int direction) {

        this.x += direction;
    }

    public Bomb getBomb() {

        return bomb;
    }
}
