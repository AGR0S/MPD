package isel.mpd.painter2.view;

import java.awt.*;

public class LineDrawer implements ConfigDrawer {

    private PainterFrame frame;

    public LineDrawer(PainterFrame frame) {
        this.frame = frame;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawLine(frame.getStart().x, frame.getStart().y, frame.getCurr().x, frame.getCurr().y);
    }

    @Override
    public void paint(PaintPanel canvas) {
        canvas.addLine(frame.getStart(), frame.getEnd(), frame.getColor());
    }
}
