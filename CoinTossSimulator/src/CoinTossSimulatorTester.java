

public class CoinTossSimulatorTester{
    public static void main(String[] args){
        CoinTossSimulator cointoss = new CoinTossSimulator();
        System.out.println("After constructor:");
        System.out.println("Number of trials [exp: 0] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.run(1);
        System.out.println("After run(1)");
        System.out.println("Number of trials [exp: 1] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.run(10);
        System.out.println("After run(10):");
        System.out.println("Number of trials [exp: 11] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.run(100);
        System.out.println("After run(100):");
        System.out.println("Number of trials [exp: 111] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.reset();
        System.out.println("After reset:");
        System.out.println("Number of trials [exp: 0] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.run(1000);
        System.out.println("After run(1000):");
        System.out.println("Number of trials [exp: 1000] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));

        cointoss.run(1000000);
        System.out.println("After run(1001000):");
        System.out.println("Number of trials [exp: 1001000] : " + cointoss.getNumTrials());
        System.out.println("Two-head tosses: " + cointoss.getTwoHeads());
        System.out.println("Two-tail tosses: " + cointoss.getTwoTails());
        System.out.println("One-head one-tail tosses: " + cointoss.getHeadTails());
        System.out.println("Tosses add up correctly?: " + (cointoss.getTwoHeads() + cointoss.getTwoTails() + cointoss.getHeadTails() == cointoss.getNumTrials()));


    }
}