package isel.mpd.painter2.model;

import java.awt.*;

public class Triangle implements IShape {

    private Color color;
    private Point point1, point2, point3;

    public Triangle(Point point1, Point point2, Point point3, Color color) {
        this.color = color;
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Point getRef() {
        return this.point1;
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
        point1.setLocation(dx, dy);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle();
        return rectangle.getBounds();
    }
}
