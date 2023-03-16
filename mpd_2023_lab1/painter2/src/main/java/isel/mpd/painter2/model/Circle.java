package isel.mpd.painter2.model;

import java.awt.*;

public class Circle implements IShape {
    private Color color;
    private Point point;
    private int r;

    public Circle(Point point, int radius, Color color) {
        this.color = color;
        this.point = point;
        this.r = radius;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Point getRef() {
        return this.point;
    }

    @Override
    public boolean intersects(IShape other) {
        return this.getBounds().intersects(other.getBounds());
    }

    @Override
    public boolean contains(Point point) {
        return this.contains(point);
    }

    @Override
    public boolean contains(IShape other) {
        return this.getBounds().contains(other.getBounds());
    }

    @Override
    public void translate(int dx, int dy) {
        point.setLocation(dx, dy);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle();
        return rectangle.getBounds();
    }
}
