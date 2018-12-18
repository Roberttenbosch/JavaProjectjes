package com.company.game.sprite;

import com.company.CommonConstants;

import javax.swing.*;
import java.awt.*;

public class BaseSprite implements CommonConstants
{

    private boolean visible;
    private Image image;
    protected int x;
    protected int y;
    protected boolean dying;
    protected int dx;

    public BaseSprite() {

        visible = true;
    }

    protected void loadImage(String image_file_location) {

        ImageIcon ii = new ImageIcon(image_file_location);
        image = ii.getImage();
    }

    protected void init(String sprite_img_file){
        loadImage(IMG_PATH+sprite_img_file);
    }

    public void die() {

        visible = false;
    }

    public boolean isVisible() {

        return visible;
    }

    protected void setVisible(boolean visible) {

        this.visible = visible;
    }

    public void setImage(Image image) {

        this.image = image;
    }

    public Image getImage() {

        return image;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }

    public void setDying(boolean dying) {

        this.dying = dying;
    }

    public boolean isDying() {

        return this.dying;
    }
}
