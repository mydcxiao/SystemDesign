
import java.util.Random;

/**
 * class CoinTossSimulator
 *
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
public class CoinTossSimulator {

    private int numTrials;
    private int twoHeads;
    private int twoTails;
    private int headTails;
    private Random random;


    /**
     Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {
        numTrials = 0;
        twoHeads = 0;
        twoTails = 0;
        headTails = 0;
        random = new Random();

    }


    /**
     Runs the simulation for numTrials more trials. Multiple calls to this method
     without a reset() between them *add* these trials to the current simulation.

     @param numTrials  number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {
        this.numTrials += numTrials;
        while (0 < numTrials--){
            int firstToss = random.nextInt(2);
            int secondToss = random.nextInt(2);
            if (firstToss == 0 && secondToss == 0){
                twoTails++;
            }
            else if (firstToss == 1 && secondToss == 1){
                twoHeads++;
            }
            else {
                headTails++;
            }
        }
    }


    /**
     Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return numTrials; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        return twoHeads; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        return twoTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        return headTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
        numTrials = 0;
        twoHeads = 0;
        twoTails = 0;
        headTails = 0;
    }

}


