

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.lang.String;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 A dictionary of all anagram sets.
 Note: the processing is case-sensitive; so if the dictionary has all lower
 case words, you will likely want any string you test to have all lower case
 letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {

    /**
     Representative Invariant:
     --anagramDict can't be null
     Use a map to store the anagram dictionary
     @param anagramDict Map to store the anagram dictionary
     */

    private Map<String, ArrayList<String>> anagramDict;


    /**
     Create an anagram dictionary from the list of words given in the file
     indicated by fileName.
     @param fileName  the name of the file to read from
     @throws FileNotFoundException  if the file is not found
     @throws IllegalDictionaryException  if the dictionary has any duplicate words
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException,
            IllegalDictionaryException {
        File inFile = new File(fileName);
        try(Scanner in = new Scanner(inFile)) {
            anagramDict = new HashMap<>();
            while(in.hasNext()) {
                String word = in.next();
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String label = new String(chars);
                if(anagramDict.containsKey(label)) {
                    if(anagramDict.get(label).contains(word)) {
                        throw new IllegalDictionaryException(word);
                    }
                    anagramDict.get(label).add(word);
                }
                else {
                    anagramDict.put(label, new ArrayList<String>());
                    anagramDict.get(label).add(word);
                }
            }
        }
        assert isValidAnagramDict();
    }


    /**
     Get all anagrams of the given string. This method is case-sensitive.
     E.g. "CARE" and "race" would not be recognized as anagrams.
     @param s string to process
     @return a list of the anagrams of s
     */
    public ArrayList<String> getAnagramsOf(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        String label = new String(chars);
        if(!anagramDict.containsKey(label)) {
            assert isValidAnagramDict();
            return new ArrayList<String>();
        }
        assert isValidAnagramDict();
        return new ArrayList<String>(anagramDict.get(label));
    }

    /**
     Check if the anagram dictionary is valid
     @return true if valid, otherwise false
     */
    private boolean isValidAnagramDict() {
        if(anagramDict != null) {
            return true;
        }
        return false;
    }
}

