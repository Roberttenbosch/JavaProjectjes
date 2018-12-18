package model.sprite;

public class Missile extends BaseSprite
{
    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 4;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }

    private void initMissile() {

        loadImage("src/resources/images/missile.png");
        getImageDimensions();
    }

    public void move() {

        x += MISSILE_SPEED;

        if (x > BOARD_WIDTH) {
            visible = false;
        }
    }
}
