

import java.util.Arrays;
import java.lang.String;

/**
 A ScoreTable of Scrabble tiles to calculate the total points of a word.
 */

public class ScoreTable{

    /**
     Representation Invariant:
     -- points should not be null and its length should be equal to NUM_LETTERS(26)
     @param points an array that stores the score of each low-case letter and upper-case letter in alphabetic order
     */

    private int[] points;

    /**
     Constructor of class ScoreTable.
     Initialize the points array with hard-coded values.
     */

    public ScoreTable(){
        points = new int[]{ 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    }

    /**
     Loop over the char in the given word to calculate the total points.
     @param s string of the word
     @return total points of the word
     */

    public int getPoints(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int point = 0;
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                point = points[s.charAt(i) - 'a'];
            }
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                point = points[s.charAt(i) - 'A'];
            }
            sum += point;
        }
        return sum;
    }

    /**
     Check if the points array is valid
     @return true if valid, otherwise false
     */
    private boolean isValidPoints(){
        final int NUM_LETTERS = 26;
        if(points == null || points.length != NUM_LETTERS) {
            return false;
        }
        return true;
    }
}