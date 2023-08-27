
/**
 VisibleFieldTester
 class used to test the VisibleField Class
 */

public class VisibleFieldTester {
    public static void main(String[] args) {
        //test win condition with fixed MineField
        boolean[][] mineData = {{true, false, false, false},
                {true, true, false, false},
                {false, true, false, true}};
        MineField mineField = new MineField(mineData);
        System.out.print("initial minefield [Exp: \n1 0 0 0\n1 1 0 0\n0 1 0 1]: \n" + mineField.toString());
        VisibleField visibleField = new VisibleField(mineField);
        System.out.println("Number of Mines Left[Exp: 5]: " + visibleField.numMinesLeft());
        System.out.print("initial visiblefield [Exp: \n-1 -1 -1 -1\n-1 -1 -1 -1\n-1 -1 -1 -1]: \n");
        printVisibleField(visibleField);
        visibleField.uncover(0, 3);
        System.out.println("Is (0, 3) uncovered? [Exp: true]" + visibleField.isUncovered(0, 3));
        System.out.println("Is (0, 2) uncovered? [Exp: true]" + visibleField.isUncovered(0, 2));
        System.out.println("Is (1, 2) uncovered? [Exp: true]" + visibleField.isUncovered(1, 2));
        System.out.println("Is (1, 3) uncovered? [Exp: true]" + visibleField.isUncovered(1, 3));
        System.out.println("Is (0, 1) uncovered? [Exp: false]" + visibleField.isUncovered(0, 1));
        System.out.println("Is Game Over? [Exp: false]" + visibleField.isGameOver());
        System.out.print("visiblefield with (0, 3) uncovered [Exp: \n-1 -1 1 0\n-1 -1 3 1\n-1 -1 -1 -1]: \n");
        printVisibleField(visibleField);
        visibleField.cycleGuess(2, 1);
        visibleField.cycleGuess(2, 3);
        visibleField.cycleGuess(0, 1);
        System.out.println("Number of Mines Left [Exp: 2]: " + visibleField.numMinesLeft());
        visibleField.cycleGuess(2, 3);
        visibleField.cycleGuess(0, 1);
        System.out.println("Number of Mines Left [Exp: 4]: " + visibleField.numMinesLeft());
        visibleField.cycleGuess(0, 0);
        visibleField.cycleGuess(0, 0);
        visibleField.cycleGuess(0, 0);
        System.out.println("Status of (0, 0) [Exp: " + visibleField.COVERED + "]: " + visibleField.getStatus(0, 0));
        System.out.println("Status of (0, 1) [Exp: " + visibleField.QUESTION + "]: " + visibleField.getStatus(0, 1));
        System.out.println("Status of (2, 1) [Exp: " + visibleField.MINE_GUESS + "]: " + visibleField.getStatus(2, 1));
        System.out.print("current visiblefield [Exp: \n-1 -3 1 0\n-1 -1 3 1\n-1 -2 -1 -3]: \n");
        printVisibleField(visibleField);
        visibleField.uncover(2, 0);
        System.out.println("Is (2, 0) uncovered? [Exp: true]" + visibleField.isUncovered(2, 0));
        System.out.println("Is (1, 0) uncovered? [Exp: false]" + visibleField.isUncovered(1, 0));
        System.out.println("Is (1, 1) uncovered? [Exp: false]" + visibleField.isUncovered(1, 1));
        System.out.println("Is (2, 1) uncovered? [Exp: false]" + visibleField.isUncovered(2, 1));
        System.out.println("Is Game Over? [Exp: false]" + visibleField.isGameOver());
        System.out.print("current visiblefield [Exp: \n-1 -3 1 0\n-1 -1 3 1\n3 -2 -1 -3]: \n");
        printVisibleField(visibleField);
        visibleField.uncover(0, 1);
        visibleField.uncover(2, 2);
        System.out.println("Is Game Over? [Exp: true]" + visibleField.isGameOver());
        System.out.print("win visiblefield [Exp: \n-2 3 1 0\n-2 -2 3 1\n3 -2 3 -2]: \n");
        printVisibleField(visibleField);

        //reset the game
        visibleField.resetGameDisplay();
        System.out.print("reset visiblefield [Exp: \n-1 -1 -1 -1\n-1 -1 -1 -1\n-1 -1 -1 -1]: \n");
        printVisibleField(visibleField);
        System.out.println("Number of Mines Left[Exp: 5]: " + visibleField.numMinesLeft());
        System.out.print("underlying minefield [Exp: \n1 0 0 0\n1 1 0 0\n0 1 0 1]: \n" + mineField.toString());

        //test lose condition with fixed minefield
        visibleField.cycleGuess(0, 2);
        visibleField.cycleGuess(1, 3);
        visibleField.cycleGuess(1, 2);
        visibleField.cycleGuess(1, 2);
        visibleField.uncover(0, 3);
        System.out.println("Is Game Over? [Exp: false]" + visibleField.isGameOver());
        System.out.print("current visiblefield [Exp: \n-1 -1 -2 0\n-1 -1 3 -2\n-1 -1 -1 -1]: \n");
        printVisibleField(visibleField);
        visibleField.cycleGuess(2, 3);
        visibleField.cycleGuess(2, 2);
        visibleField.cycleGuess(2, 0);
        visibleField.cycleGuess(0, 0);
        System.out.println("Number of Mines Left [Exp: -1]: " + visibleField.numMinesLeft());
        visibleField.uncover(2, 1);
        System.out.println("Is Game Over? [Exp: true]" + visibleField.isGameOver());
        System.out.print("lose visiblefield [Exp: \n-2 -1 10 0\n9 9 3 10\n10 11 10 -2]: \n");
        printVisibleField(visibleField);

    }

    /**
     Print the visibleField
     */
    private static void printVisibleField(VisibleField visibleField) {
        for (int i = 0; i < visibleField.getMineField().numRows(); i++) {
            for (int j = 0; j < visibleField.getMineField().numCols(); j++) {
                System.out.print(visibleField.getStatus(i, j) + " ");
            }
            System.out.print('\n');
        }
    }
}