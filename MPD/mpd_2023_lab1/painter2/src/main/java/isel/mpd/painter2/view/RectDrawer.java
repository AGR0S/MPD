package isel.mpd.painter2.view;

import java.awt.*;

public class RectDrawer implements ConfigDrawer {
    private PainterFrame frame;
    private int w, h;
    public RectDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        w = frame.getCurr().x - frame.getStart().x + 1;
        h = frame.getCurr().y - frame.getStart().y + 1;
        g.drawRect(frame.getStart().x, frame.getStart().y, w, h);
    }

    @Override
    public void paint(PaintPanel canvas) {
        canvas.addRect(frame.getStart(), w, h, frame.getColor());
    }
}
