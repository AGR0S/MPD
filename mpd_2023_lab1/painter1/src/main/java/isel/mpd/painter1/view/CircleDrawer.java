package isel.mpd.painter1.view;

import java.awt.*;

public class CircleDrawer implements ConfigDrawer {

    private PainterFrame frame;
    private int d;

    public CircleDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        d = frame.getCurr().x - frame.getStart().x + 1;
        g.drawOval(frame.getStart().x, frame.getStart().y, d, d);
    }

    @Override
    public void paint(PaintPanel canvas) {
        canvas.addOval(frame.getStart(), d, d, frame.getColor());
    }
}