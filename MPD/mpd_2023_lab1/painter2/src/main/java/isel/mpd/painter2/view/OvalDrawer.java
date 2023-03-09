package isel.mpd.painter2.view;

import java.awt.*;

public class OvalDrawer implements ConfigDrawer {

    private PainterFrame frame;
    private int w, h;

    public OvalDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        w = frame.getCurr().x - frame.getStart().x + 1;
        h = frame.getCurr().y - frame.getStart().y + 1;
        g.drawOval(frame.getStart().x, frame.getStart().y, w, h);
    }

    @Override
    public void paint(PaintPanel canvas) {
        canvas.addOval(frame.getStart(), w, h, frame.getColor());
    }
}
