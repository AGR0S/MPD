package isel.mpd.painter2.view;

import java.awt.*;

public class TriangleDrawer implements ConfigDrawer {

    private PainterFrame frame;

    private int[] xPoints, yPoints;

    public TriangleDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        int d = frame.getStart().x - Math.abs(frame.getCurr().x - frame.getStart().x);
        xPoints = new int[] {
                d,
                frame.getStart().x,
                frame.getCurr().x
                };
        yPoints = new int[] {
                frame.getCurr().y,
                frame.getStart().y,
                frame.getCurr().y
               };

        g.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void paint(PaintPanel canvas) {
        Point p1 = new Point(0, 0);
        p1.x = xPoints [0];
        p1.y = yPoints [0];
        canvas.addTriangle(p1, frame.getStart(), frame.getEnd(), frame.getColor());
    }
}
