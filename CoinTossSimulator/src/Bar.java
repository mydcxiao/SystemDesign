import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 */
public class Bar {
    /**
     Creates a labeled bar.  You give the height of the bar in application
     units (e.g., population of a particular state), and then a scale for how
     tall to display it on the screen (parameter scale).

     @param bottom  location of the bottom of the bar
     @param left  location of the left side of the bar
     @param width  width of the bar (in pixels)
     @param applicationHeight  height of the bar in application units
     @param scale  how many pixels per application unit
     @param color  the color of the bar
     @param label  the label under the bar
     */
    private int bottom;
    private int left;
    private int width;
    private int applicationHeight;
    private double scale;
    private Color color;
    private String label;

    //Constructor—initialize the parameters with input
    public Bar(int bottom, int left, int width, int applicationHeight,
               double scale, Color color, String label) {
        this.bottom = bottom;
        this.left = left;
        this.width = width;
        this.applicationHeight = applicationHeight;
        this.scale = scale;
        this.color = color;
        this.label = label;
    }

    /**
     Draw the labeled bar.
     @param g2  the graphics context
     */
    public void draw(Graphics2D g2) {

        // Draw a bar in the appropriate location and fill it with a specified color
        Rectangle rect = new Rectangle(left, bottom - (int)(applicationHeight * scale), width, (int)(applicationHeight * scale));
        g2.draw(rect);
        g2.setColor(color);
        g2.fill(rect);

        // Draw the label of the bar, locate the label in the center bottom of the bar
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(label, context);
        int widthOfLabel = (int) labelBounds.getWidth();
        int heightOfLabel = (int) labelBounds.getHeight();
        g2.drawString(label, left + width/2 - widthOfLabel/2, bottom + heightOfLabel);


    }
}

