package model.sprite;

import javax.swing.*;
import java.awt.*;

public class BaseSprite
{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public BaseSprite(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
