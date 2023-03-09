package isel.mpd.painter0.view;

import javax.swing.JComponent;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Point;


public class PaintPanel extends JComponent {

    // image presented on PaintPanel renderization (on paintComponent)
    private BufferedImage picture;
    private BasicStroke lineWith = new BasicStroke(4);

    private static BufferedImage createImageWithBackground(int w, int h, Color backColor) {
        BufferedImage pic  = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = (Graphics2D) pic.getGraphics();
        g.setColor(backColor);
        g.fillRect(0,0, w,h);
        // set  anti-aliasing!
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.dispose();
        return pic;
    }

    PaintPanel(int w, int h, Color backColor) {
        setPreferredSize(new Dimension(w,h));
        picture = createImageWithBackground(w, h, backColor);
    }

    // PaintPanel renderization
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(picture, 0, 0, null);
    }

    public void addRect(Point start, int w, int h, Color color) {
        Graphics g = picture.getGraphics();
        g.setColor(color);
        g.fillRect(start.x, start.y, w+1, h+1);
        g.dispose();
        repaint();
    }

    public void addLine(Point start, Point end, Color color) {
        Graphics2D g = (Graphics2D) picture.getGraphics();

        g.setColor(color);
        Stroke s = g.getStroke();
        g.setStroke(lineWith);
        g.drawLine(start.x, start.y, end.x, end.y);
        g.setStroke(s);
        g.dispose();
        repaint();
    }

    public void addOval(Point start, int w, int h, Color color) {
        Graphics2D g = (Graphics2D) picture.getGraphics();
        g.setColor(color);

        g.fillOval(start.x, start.y, w+1, h+1);
        g.dispose();
        repaint();
    }

    public void addTriangle(Point p1, Point p2, Point p3, Color color) {
        Graphics g = picture.getGraphics();
        g.setColor(color);
        int[] xPoints = { p1.x, p2.x, p3.x};

        int[] yPoints = { p1.y, p2.y, p3.y};
        g.fillPolygon(xPoints, yPoints, 3);
        g.dispose();
        repaint();
    }
}
