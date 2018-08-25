
// Name: Georgios Iliadis	
// USC NetID: giliadis
// CS 455 PA4
// Spring 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */

public class AnagramDictionary {
	private Map<String, ArrayList<String>> words;

	/**
	 * Create an anagram dictionary from the list of words given in the file
	 * indicated by fileName. PRE: The strings in the file are unique.
	 * 
	 * @param fileName
	 *            the name of the file to read from
	 * @throws FileNotFoundException
	 *             if the file is not found
	 */
	public AnagramDictionary(String fileName) throws FileNotFoundException {
		words = new HashMap<String, ArrayList<String>>();
		// map that has key as a sorted string, and value as an arraylist with values
		// all the anagrams of the key.
		Scanner in = new Scanner(new File(fileName));
		while (in.hasNextLine()) {
			String word = in.nextLine();
			String sortedWord = sortString(word);
			if (words.containsKey(sortedWord)) {
				words.get(sortedWord).add(word);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(word);
				words.put(sortedWord, al);
			}
		}
	}

	/**
	 * Get all anagrams of the given string. This method is case-sensitive. E.g.
	 * "CARE" and "race" would not be recognized as anagrams.
	 * 
	 * @param s
	 *            string to process
	 * @return a list of the anagrams of s
	 * 
	 */
	public ArrayList<String> getAnagramsOf(String s) {
		if (words.get(sortString(s)) == null) {
			return new ArrayList<>();
		} else {
			return new ArrayList<>(words.get(sortString(s)));
		}
	}

	/**
	 * Sort string alphabetically
	 * 
	 * @param inputString
	 *            the string to be sorted
	 */
	private static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray(); // convert input string to char array
		Arrays.sort(tempArray); // sort temparray
		return new String(tempArray); // return new sorted string
	}

}