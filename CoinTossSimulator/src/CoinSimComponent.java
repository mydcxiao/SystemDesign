import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
 This component draws three bars
 */
public class CoinSimComponent extends JComponent
{

    // added instance variable for instrumentation
    private int callCount;
    private static final int BAR_WIDTH = 50;
    private static final int VERTICAL_BUFFER = 20;
    private static final Color TWO_HEAD_COLOR = Color.RED;
    private static final Color HEAD_TAIL_COLOR = Color.GREEN;
    private static final Color TWO_TAIL_COLOR = Color.BLUE;
    private int numOfTrials;
    private int numTwoHeads;
    private int numHeadTails;
    private int numTwoTails;

    // added constructor for instrumentation
    // Note: for old version without instance variables an empty default
    // constructor didn't need to be defined explicitly (see:
    // https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
    // for rules about this)
    public CoinSimComponent(CoinTossSimulator cointoss) {
        callCount = 0;
        numOfTrials = cointoss.getNumTrials();
        numTwoHeads = cointoss.getTwoHeads();
        numHeadTails = cointoss.getHeadTails();
        numTwoTails = cointoss.getTwoTails();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;


        // the following two lines are for instrumentation
        callCount++;
        System.out.println("Called paintComponent(" + callCount + ")");

        // get the spacing of each bar
        int spacing = getWidth() / 4;
        // determine the scale, and limit the height of the highest bar possible
        double scale = (double)(getHeight() - 2 * VERTICAL_BUFFER) / numOfTrials;
        // get the bottom of all bars
        int bottom = getHeight() - VERTICAL_BUFFER;
        // get the left of the first bar, which is for two heads
        int leftTwoHeads = spacing - BAR_WIDTH / 2;
        // get the left of the second bar, which is for one head one tail
        int leftHeadTails = 2 * spacing - BAR_WIDTH / 2;
        // get the left of the third bar, which is for two tails
        int leftTwoTails = 3 * spacing - BAR_WIDTH / 2;
        // determine the labels for each bar
        String labelTwoHeads = "Two Heads: " + numTwoHeads + " (" + 100 * numTwoHeads / numOfTrials + "%" + ")";
        String labelHeadTails = "A Head and a tail: " + numHeadTails + " (" + 100* numHeadTails / numOfTrials + "%" + ")";
        String labelTwoTails = "Two Tails: " + numTwoTails + " (" + 100* numTwoTails / numOfTrials + "%" + ")";

        //Create three bars using these parameters and draw them
        Bar barTwoHeads = new Bar(bottom, leftTwoHeads, BAR_WIDTH, numTwoHeads, scale, TWO_HEAD_COLOR, labelTwoHeads);

        Bar barHeadTails = new Bar(bottom, leftHeadTails, BAR_WIDTH, numHeadTails, scale, HEAD_TAIL_COLOR, labelHeadTails);

        Bar barTwoTails = new Bar(bottom, leftTwoTails, BAR_WIDTH, numTwoTails, scale, TWO_TAIL_COLOR, labelTwoTails);

        barTwoHeads.draw(g2);
        barHeadTails.draw(g2);
        barTwoTails.draw(g2);
    }
}


