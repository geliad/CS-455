
// Name: Georgios Iliadis	
// USC NetID: giliadis
// CS 455 PA4
// Spring 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	private int[] mult;
	private String unique = "";

	/**
	 * Constructs a rack where the string entered will be saved as a string of
	 * unique letters and an array with the number of occurances of each letter.
	 * 
	 * @param str
	 *            The string that the user will input
	 */
	public Rack(String str) {
		Map<String, Integer> mapLetter = new TreeMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
			String x = String.valueOf(str.charAt(i)); // first character of String str, saved as string to compare
														// in map.
			if (!mapLetter.containsKey(x)) {
				mapLetter.put(x, 1);
			} else {
				int y = mapLetter.get(x) + 1;
				mapLetter.put(x, y);
			}
		}
		mult = new int[mapLetter.keySet().size()];
		int i = 0;
		for (Map.Entry<String, Integer> entry : mapLetter.entrySet()) {
			mult[i] = entry.getValue();
			unique += entry.getKey();
			i++;
		}
	}

	/**
	 * Method to return the rack after it is sorted and with only unique values. I
	 * will use it when calling the allSubsetsH method in the WordFinder class.
	 * 
	 * @return the unique sorted letters in the rack
	 */
	public String getRack() {
		return unique;
	}

	/**
	 * Method to return the array mult which has the number of occurances of each
	 * letter. I will use it when calling the allsubsetsH method in the WordFinder
	 * class.
	 * 
	 * @return mult Returns the mult array
	 */
	public int[] getMult() {
		return mult;
	}

	/**
	 * I created a public method in order to be able to use the method in the
	 * WordFiner class. It's like a helper method to be able to use this method to
	 * different classes
	 * 
	 * @param unique
	 *            The unique string
	 * @param mult
	 *            The array with the number of occurances of each letter
	 * @param k
	 *            The index value for mult. It will go 1 up after every recursive
	 *            call.
	 * @return An arraylist with all the subsets of the rack given as a
	 *         string(unique) and an array(mult).
	 */
	public static ArrayList<String> allSubsetsH(String unique, int[] mult, int k) {
		return allSubsets(unique, mult, k);
	}

	/**
	 * Finds all subsets of the multiset starting at position k in unique and mult.
	 * unique and mult describe a multiset such that mult[i] is the multiplicity of
	 * the char unique.charAt(i). PRE: mult.length must be at least as big as
	 * unique.length() 0 <= k <= unique.length()
	 * 
	 * @param unique
	 *            a string of unique letters
	 * @param mult
	 *            the multiplicity of each letter from unique.
	 * @param k
	 *            the smallest index of unique and mult to consider.
	 * @return all subsets of the indicated multiset
	 * @author Claire Bono
	 */
	private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
		ArrayList<String> allCombos = new ArrayList<>();

		if (k == unique.length()) { // multiset is empty
			allCombos.add("");
			return allCombos;
		}

		// get all subsets of the multiset without the first unique char
		ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

		// prepend all possible numbers of the first char (i.e., the one at position k)
		// to the front of each string in restCombos. Suppose that char is 'a'...

		String firstPart = ""; // in outer loop firstPart takes on the values: "", "a", "aa", ...
		for (int n = 0; n <= mult[k]; n++) {
			for (int i = 0; i < restCombos.size(); i++) { // for each of the subsets
															// we found in the recursive call
				// create and add a new string with n 'a's in front of that subset
				allCombos.add(firstPart + restCombos.get(i));
			}
			firstPart += unique.charAt(k); // append another instance of 'a' to the first part
		}

		return allCombos;
	}

}