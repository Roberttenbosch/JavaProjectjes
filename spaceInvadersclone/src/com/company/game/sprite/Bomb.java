package com.company.game.sprite;

public class Bomb extends BaseSprite
{
    private final String bomb_sprite_img_file = "bomb.png";
    private boolean destroyed;

    public Bomb(int x, int y) {

        initBomb(x, y);
    }

    private void initBomb(int x, int y)
    {
        super.init(bomb_sprite_img_file);
        this.x = x;
        this.y = y;
        setDestroyed(true);

    }

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {

        return destroyed;
    }
}
