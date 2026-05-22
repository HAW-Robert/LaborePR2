package labs.lab2.functions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A simple class to plot a set of functions. Not much
 * functionality
 */
public class FunctionViewer extends JFrame implements ActionListener {

    // some fields for the GUI
    private JPanel panel;
    private Function[] functions;
    private JList<Function> functionList;
    private JCheckBox drawDerivativeBox;
    private JCheckBox drawAntiderivativeBox;


    /**
     * Constructs a window that plot the given set of functions.
     * @param functs the set of functions to plot
     */
    public FunctionViewer(Function[] functs) {
        super("FunctionViewer");

        this.functions = functs;

        // general settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cnt = getContentPane();
        cnt.setLayout(new BorderLayout());

        // creating a JList for the functions to plot
        functionList = new JList<Function>(functions);
        functionList.setVisibleRowCount(10); // 10 elements visible
        functionList.setSelectionBackground(Color.BLUE); // colors
        functionList.setSelectionForeground(Color.WHITE);

        // we want to be informed if something happens here
        functionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                panel.repaint(); // in all cases redraw the functions
            }
        });

        // add the list to the JFrame WITH A SCROLLBAR
        cnt.add(new JScrollPane(functionList), BorderLayout.NORTH); // now "10" make sense

        // the panel that shows the function graph
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g); // never forget

                // get the current size of the panel
                Dimension d = getSize();
                int min = Math.min(d.width, d.height);
                int hOffset = (d.width - min) / 2;

                // draw background
                g.setColor(new Color(248, 248, 248));
                g.fillRect(hOffset, 0, min, min);

                // draw the axes
                g.setColor(Color.BLACK);
                g.drawLine(hOffset, min / 2, hOffset + min, min / 2);
                g.drawLine(hOffset + min / 2, 0, hOffset + min / 2, min);

                // draw the grid
                for (int i = 1; i < 10; i++) {
                    g.drawLine(hOffset + min / 2 + i * min / 20, min / 2 - 2, hOffset + min / 2 + i * min / 20,
                            min / 2 + 2);
                    g.drawLine(hOffset + min / 2 - i * min / 20, min / 2 - 2, hOffset + min / 2 - i * min / 20,
                            min / 2 + 2);
                    g.drawLine(hOffset + min / 2 - 2, min / 2 + i * min / 20, hOffset + min / 2 + 2,
                            min / 2 + i * min / 20);
                    g.drawLine(hOffset + min / 2 - 2, min / 2 - i * min / 20, hOffset + min / 2 + 2,
                            min / 2 - i * min / 20);
                }

                // now draw all functions which are selected currently
                for (Function f : functionList.getSelectedValuesList()) {
                    // draw the function in black
                    g.setColor(Color.BLACK);
                    drawFunction(g, min, hOffset, f);

                    // draw the 1st derivative (in red) if user wants it to see
                    if (drawDerivativeBox.isSelected()) {
                        g.setColor(Color.RED);
                        drawFunction(g, min, hOffset, f.derivative());
                    }

                    // draw the antiderivative (in blue) if available and user wants it to see 
                    if (drawAntiderivativeBox.isSelected() &&
                            f instanceof Antiderivative) {
                        Antiderivative antiF = (Antiderivative) f;
                        if (antiF.hasAntiderivative()) {
                            g.setColor(Color.BLUE);
                            drawFunction(g, min, hOffset, antiF.antiderivative());
                        }
                    }
                }

            }

        };
        cnt.add(panel, BorderLayout.CENTER);

        // boxes for (anti-)derivative
        drawDerivativeBox = new JCheckBox("mit Ableitung");
        drawDerivativeBox.addActionListener(this);
        drawAntiderivativeBox = new JCheckBox("mit Stammfunktion");
        drawAntiderivativeBox.addActionListener(this);

        // put the boxes below the graphs
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(10));
        southPanel.add(drawDerivativeBox);
        southPanel.add(drawAntiderivativeBox);
        add(southPanel, BorderLayout.SOUTH);

        // showtime!
        setSize(500, 500);
        setVisible(true);
    }


    /**
     * Draws a function onto the panel.
     * @param g the Graphics object that does the drawing
     * @param min the size of the panel (min x min)
     * @param hOffset the horizontal offset of the panel
     * @param f the function that shall be plotted
     */
    private void drawFunction(Graphics g, int min, int hOffset, Function f) {
        int x; // the x position in the panel!
        int y; // the y position in the panel!
        int oldx = 0; // previous x in the panel
        int oldy = 0; // previous y in the panel
        // now draw the function
        for (x = 0; x < min; x++) {
            // compute current *Carthesian* value
            // we plot from -10 to 10
            double curX = -10.0 + (20.0 * x) / min;
            if (f.isDefinedFor(curX)) {
                // compute the f(curX)
                double curY = f.evaluate(curX);
                // now transform this into a panel position
                y = min / 2 - (int) (curY * (min / 2) / 10.0);
                if (x > 0 && f.isDefinedFor(oldx)) {
                    g.drawLine(hOffset + oldx, oldy, hOffset + x, y);
                }
                // remember last point
                oldx = x;
                oldy = y;
            }
        }
    }

    public static void main(String[] args) {
        new FunctionViewer(Function.showTheseFunctions());
    }

    // if a checkbox is clicked
    @Override
    public void actionPerformed(ActionEvent event) {
        // in all cases just repaint()
        panel.repaint();
    }

}
