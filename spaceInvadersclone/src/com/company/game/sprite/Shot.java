package com.company.game.sprite;

import com.company.CommonConstants;

public class Shot extends BaseSprite implements CommonConstants
{
    private final String shot_sprite_img_file = "shot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public Shot(){}

    public Shot(int x, int y){
        initShot(x, y);
    }

    private void initShot(int x, int y)
    {
        super.init(shot_sprite_img_file);
        setX(x + H_SPACE);
        setY(y + V_SPACE);
    }
}
