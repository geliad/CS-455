
// Name: Georgios Iliadis	
// USC NetID: giliadis
// CS 455 PA4
// Spring 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFinder {

	private static final String DEFAULT_DICTIONARY = "sowpods.txt";

	/**
	 * Finds all the words that can be made from the letters in the rack given by
	 * the user. It prompts the user for a rack, finds all possible words that are
	 * present in the dictionary and their scores, and then lists them before asking
	 * the user for another rack. The user can exit the program and make it stop by
	 * typing ".".
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {// exceptions kai malakies gia file reading
		AnagramDictionary anagramDictionary = null;
		try {
			anagramDictionary = new AnagramDictionary(args.length == 0 ? DEFAULT_DICTIONARY : args[0]);
		} catch (FileNotFoundException exception) {
			System.out.println("ERROR: File not found");
			System.exit(0);
		}
		System.out.println("Type . to quit.");
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("Rack? ");
			String userInput = in.nextLine();
			String userInputOnlyLetters = removeNonLetterChars(userInput);
			if (userInput.equals(".")) {
				System.exit(0);
			}
			// The map will have the words that appear in the dictionary as keys and their
			// score as values. If the score is the same, word will be sorted aplhabetically
			// so I used TreeMap
			Map<String, Integer> order = new TreeMap<String, Integer>();
			ScoreTable scoreTable = new ScoreTable();
			Rack rack = new Rack(userInputOnlyLetters);
			ArrayList<String> allSubsetsArrayList = rack.allSubsetsH(rack.getRack(), rack.getMult(), 0);
			for (int i = 0; i < allSubsetsArrayList.size(); i++) {
				String subset = allSubsetsArrayList.get(i);
				for (int j = 0; j < anagramDictionary.getAnagramsOf(subset).size(); j++) {// enter word(key) and
					String wordOfAnagram = anagramDictionary.getAnagramsOf(subset).get(j);// the word that will be added
																							// in the map as a key
					order.put(wordOfAnagram, scoreTable.getScore(wordOfAnagram));
				}
			}
			printResults(order, sortString(userInputOnlyLetters));
		}
	}

	/**
	 * Prints the results, prints how many word can be made from the provided rack
	 * and gives the score for each word.
	 * 
	 * @param a
	 *            Map<String,Integer> that I added the words and the scores
	 * @param str
	 *            The String inputed by the user, after I removed any non letters
	 */
	private static void printResults(Map<String, Integer> a, String str) {
		ArrayList<Map.Entry<String, Integer>> freq = new ArrayList<Map.Entry<String, Integer>>(a.entrySet());
		Collections.sort(freq, new SortByValue());

		System.out.println("We can make " + freq.size() + " words from " + "\"" + str + "\"");
		if (freq.size() > 0) {
			System.out.println("All of the words with their scores (sorted by score):");
			for (Map.Entry<String, Integer> entry : freq) {
				System.out.println(entry.getValue() + ": " + entry.getKey());
			}
		}
	}

	/**
	 * Remove any non letter characters from the string
	 * 
	 * @param str
	 *            The string to modify
	 * @return The string after the non letter characters were removed
	 */
	private static String removeNonLetterChars(String str) {
		String newStr = str.replaceAll("[^a-zA-Z]", "");
		return newStr;
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

// To sort the Map by score
class SortByValue implements Comparator<Map.Entry<String, Integer>> {

	public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
		return b.getValue() - a.getValue();
	}
}
