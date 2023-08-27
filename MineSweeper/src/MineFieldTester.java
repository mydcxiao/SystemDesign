
/**
 MineFieldTester
 class used to test the MineField Class
 */


public class MineFieldTester {
    static public void main(String[] args) {
        // Test 1-arg constructor and all accessors
        boolean[][] mineData1 = {{false, true, false},
                {true, false, false},
                {false, false, true}};
        boolean[][] mineData2 = {{false, true, false},
                {true, false, false}};
        boolean[][] mineData3 = {{true}};
        boolean[][] mineData4 = {{false}};

        System.out.println("test 1-arg constructor and all accessors: ");

        // mineData1 test
        MineField mineField = new MineField(mineData1);
        System.out.println("Case 1: ");
        System.out.print("MineField\n[Exp: \n0 1 0\n1 0 0\n0 0 1]: \n" +  mineField.toString());
        System.out.println("Number of Rows [Exp: 3]: " + mineField.numRows());
        System.out.println("Number of Columns [Exp: 3]: " + mineField.numCols());
        System.out.println("Number of Mines [Exp: 3]: " + mineField.numMines());
        System.out.println("hasMine(0, 0)? [Exp: false]: " + mineField.hasMine(0, 0));
        System.out.println("hasMine(0, 1)? [Exp: true]: " + mineField.hasMine(0, 1));
        System.out.println("inRange(2, 2)? [Exp: true]: " + mineField.inRange(2, 2));
        System.out.println("inRange(3, 3)? [Exp: false]: " + mineField.inRange(3, 3));
        System.out.println("inRange(-1, 0)? [Exp: false]: " + mineField.inRange(-1, 0));
        System.out.println("inRange(0, -1)? [Exp: false]: " + mineField.inRange(0, -1));
        System.out.println("Num of Adjacent Mines in [0, 0]? [Exp: 2]: " + mineField.numAdjacentMines(0, 0));
        System.out.println("Num of Adjacent Mines in [1, 1]? [Exp: 3]: " + mineField.numAdjacentMines(1, 1));
        System.out.println("Num of Adjacent Mines in [2, 0]? [Exp: 1]: " + mineField.numAdjacentMines(2, 0));
        System.out.println("Num of Adjacent Mines in [2, 2]? [Exp: 0]: " + mineField.numAdjacentMines(2, 2));

        // mineData2 test
        mineField = new MineField(mineData2);
        System.out.println("Case 2: ");
        System.out.print("MineField\n[Exp: \n0 1 0\n1 0 0]: \n" +  mineField.toString());
        System.out.println("Number of Rows [Exp: 2]: " + mineField.numRows());
        System.out.println("Number of Columns [Exp: 3]: " + mineField.numCols());
        System.out.println("Number of Mines [Exp: 2]: " + mineField.numMines());
        System.out.println("hasMine(0, 0)? [Exp: false]: " + mineField.hasMine(0, 0));
        System.out.println("hasMine(0, 1)? [Exp: true]: " + mineField.hasMine(0, 1));
        System.out.println("inRange(3, 3)? [Exp: false]: " + mineField.inRange(3, 3));
        System.out.println("inRange(-1, 0)? [Exp: false]: " + mineField.inRange(-1, 0));
        System.out.println("inRange(0, -1)? [Exp: false]: " + mineField.inRange(0, -1));
        System.out.println("Num of Adjacent Mines in [0, 0]? [Exp: 2]: " + mineField.numAdjacentMines(0, 0));
        System.out.println("Num of Adjacent Mines in [1, 1]? [Exp: 2]: " + mineField.numAdjacentMines(1, 1));

        // mineData3 test
        mineField = new MineField(mineData3);
        System.out.println("Case 3: ");
        System.out.print("MineField\n[Exp: \n1]: \n" +  mineField.toString());
        System.out.println("Number of Rows [Exp: 1]: " + mineField.numRows());
        System.out.println("Number of Columns [Exp: 1]: " + mineField.numCols());
        System.out.println("Number of Mines [Exp: 1]: " + mineField.numMines());
        System.out.println("hasMine(0, 0)? [Exp: true]: " + mineField.hasMine(0, 0));
        System.out.println("inRange(2, 2)? [Exp: false]: " + mineField.inRange(2, 2));
        System.out.println("inRange(3, 3)? [Exp: false]: " + mineField.inRange(3, 3));
        System.out.println("inRange(-1, 0)? [Exp: false]: " + mineField.inRange(-1, 0));
        System.out.println("inRange(0, -1)? [Exp: false]: " + mineField.inRange(0, -1));
        System.out.println("Num of Adjacent Mines in [0, 0]? [Exp: 0]: " + mineField.numAdjacentMines(0, 0));

        // mineData4 test
        mineField = new MineField(mineData4);
        System.out.println("Case 4: ");
        System.out.print("MineField\n[Exp: \n0]: \n" +  mineField.toString());
        System.out.println("Number of Rows [Exp: 1]: " + mineField.numRows());
        System.out.println("Number of Columns [Exp: 1]: " + mineField.numCols());
        System.out.println("Number of Mines [Exp: 0]: " + mineField.numMines());
        System.out.println("hasMine(0, 0)? [Exp: false]: " + mineField.hasMine(0, 0));
        System.out.println("inRange(2, 2)? [Exp: false]: " + mineField.inRange(2, 2));
        System.out.println("inRange(3, 3)? [Exp: false]: " + mineField.inRange(3, 3));
        System.out.println("inRange(-1, 0)? [Exp: false]: " + mineField.inRange(-1, 0));
        System.out.println("inRange(0, -1)? [Exp: false]: " + mineField.inRange(0, -1));
        System.out.println("Num of Adjacent Mines in [0, 0]? [Exp: 0]: " + mineField.numAdjacentMines(0, 0));


        // test 1-arg constructor and mutators
        System.out.println("test 1-arg constructor and mutators: ");
        mineField = new MineField(mineData1);
        mineField.resetEmpty();
        System.out.print("MineField\n[Exp: \n0 0 0\n0 0 0\n0 0 0]: \n" +  mineField.toString());
        mineField = new MineField(mineData2);
        mineField.resetEmpty();
        System.out.print("MineField\n[Exp: \n0 0 0\n0 0 0]: \n" +  mineField.toString());
        mineField = new MineField(mineData3);
        mineField.resetEmpty();
        System.out.print("MineField\n[Exp: \n0]: \n" +  mineField.toString());
        mineField = new MineField(mineData4);
        mineField.resetEmpty();
        System.out.print("MineField\n[Exp: \n0]: \n" +  mineField.toString());

        //mineData5 satisfies the PRE of populateMineField
        //test the mutator populateMineField
        boolean[][] mineData5 = {{false, true, false},
                {false, false, false},
                {false, false, true}};
        mineField = new MineField(mineData5);
        mineField.populateMineField(0, 1);
        System.out.println("Number of Mines [Exp: 2] " + mineField.numMines());
        System.out.print("MineField[Exp: 0 in (0, 1) with two random 1]: \n" +  mineField.toString());

        //test 3-args constructor, accessors and mutators
        mineField = new MineField(5, 5, 3);
        System.out.print("MineField before populating mines\n[Exp: \n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0]: \n" +  mineField.toString());
        System.out.println("Number of Rows [Exp: 5]: " + mineField.numRows());
        System.out.println("Number of Columns [Exp: 5]: " + mineField.numCols());
        System.out.println("Number of Mines [Exp: 3]: " + mineField.numMines());
        mineField.populateMineField(0, 0);
        System.out.print("MineField[Exp: 0 in (0, 0) with three random 1]: \n" +  mineField.toString());
        mineField.populateMineField(2, 2);
        System.out.print("MineField[Exp: 0 in (2, 2) with three random 1]: \n" +  mineField.toString());
        mineField.resetEmpty();
        System.out.print("MineField after reset\n[Exp: \n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0]: \n" +  mineField.toString());
        System.out.println("Number of Mines [Exp: 3]: " + mineField.numMines());
    }
}
