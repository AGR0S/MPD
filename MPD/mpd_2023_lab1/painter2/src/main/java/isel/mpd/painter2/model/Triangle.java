package isel.mpd.painter2.model;

import java.awt.*;

public class Triangle implements IShape {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Point getRef() {
        return null;
    }

    @Override
    public boolean intersects(IShape other) {
        return false;
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }

    @Override
    public boolean contains(IShape other) {
        return false;
    }

    @Override
    public void translate(int dx, int dy) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
