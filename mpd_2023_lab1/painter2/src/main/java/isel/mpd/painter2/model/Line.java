package isel.mpd.painter2.model;

import java.awt.*;

public class Line implements IShape {
    private Color color;
    private Point start, end;
    private int w, h;

    public Line(Point start, Point end, Color color) {
        this.color = color;
        this.start = start;
        this.end = end;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Point getRef() {
        return this.start;
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
        start.setLocation(dx, dy);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(start.x, start.y, end.x - start.x, end.y - start.y);
        return rectangle.getBounds();
    }
}
