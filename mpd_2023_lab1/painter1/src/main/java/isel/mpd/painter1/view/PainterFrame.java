package isel.mpd.painter1.view;

import isel.mpd.painter1.app.App;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JColorChooser;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainterFrame extends JFrame {
    public static int CANVAS_SIZE_X = 1024;
    public static int CANVAS_SIZE_Y = 600;

    // command names
    public static final String SHAPE_CMD_RECT = "Rect";
    public static final String SHAPE_CMD_LINE = "Line";
    public static final String SHAPE_CMD_TRIANGLE = "Triangle";
    public static final String SHAPE_CMD_OVAL = "Oval";
    public static final String SHAPE_CMD_CIRCLE = "Circle";

    // state variables
    private Color currColor = Color.BLACK;

    // components
    private JTextArea mouseHistory;
    private PaintPanel canvas;
    private Point curr, start, end;

    private ConfigDrawer currDrawer;

    public  PainterFrame(App app){
        initComponents();
        buildMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
    }

    private  class PaintMouselistener extends  MouseAdapter {
        public void mousePressed(MouseEvent me) {
            // TODO
            start = me.getPoint();
            curr = start;
            canvas.setEdit(currDrawer);
        }

        public void mouseDragged(MouseEvent me) {
            // TODO
            curr = me.getPoint();
            canvas.repaint();
        }

        public void mouseReleased(MouseEvent me) {
            // TODO
            end = me.getPoint();
            canvas.resetEdit();
            currDrawer.paint(canvas);
        }
    }

    private void initComponents() {
        BorderLayout layout = new BorderLayout();
        Container container = getContentPane();
        container.setLayout(layout);
        canvas = new PaintPanel(CANVAS_SIZE_X, CANVAS_SIZE_Y, Color.WHITE);
        PaintMouselistener mlistener = new PaintMouselistener();
        canvas.addMouseMotionListener(mlistener);
        canvas.addMouseListener(mlistener);
        mouseHistory = new JTextArea(6, 80);
        mouseHistory.setBackground(new Color(240,240,240));
        mouseHistory.setEditable(false); // set textArea non-editable
        var scroll = new JScrollPane(mouseHistory);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        container.add(canvas, BorderLayout.CENTER);
        container.add(scroll, BorderLayout.SOUTH);
    }

    private ConfigDrawer setDrawer (String name) {
        if (name == SHAPE_CMD_RECT) {
            return new RectDrawer(this);
        }
        if (name == SHAPE_CMD_TRIANGLE) {
            return new TriangleDrawer(this);
        }
        if (name == SHAPE_CMD_LINE) {
            return new LineDrawer(this);
        }
        if (name == SHAPE_CMD_OVAL) {
            return new OvalDrawer(this);
        }
        if (name == SHAPE_CMD_CIRCLE) {
            return new CircleDrawer(this);
        }
        return null;
    }

    private JMenuItem buildItem(String name, ActionListener action) {
        var item = new JMenuItem(name);
        item.addActionListener(action);
        return item;
    }

    private void addItem(String name, JMenu menu) {
        menu.add(buildItem(name, e -> {
            mouseHistory.append("add " + name + "\n");
            currDrawer = setDrawer(name);
        }));
    }

    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu creationSel = new JMenu("Add Shape");
        JMenu clear = new JMenu("Clear");

        // TO COMPLETE
        addItem(SHAPE_CMD_RECT, creationSel);
        addItem(SHAPE_CMD_TRIANGLE, creationSel);
        addItem(SHAPE_CMD_LINE, creationSel);
        addItem(SHAPE_CMD_OVAL, creationSel);
        addItem(SHAPE_CMD_CIRCLE, creationSel);

        JMenu configSel = new JMenu("Config");
        JMenuItem color = new JMenuItem("Color");
        color.addActionListener(evt -> {
            currColor = JColorChooser.showDialog(null,"Choose Color", currColor);
        });
        configSel.add(color);
        menuBar.add(creationSel);
        menuBar.add(configSel);
        menuBar.add(clear);
        setJMenuBar(menuBar);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Point getCurr() {
        return curr;
    }

    public Color getColor() {
        return currColor;
    }

}
