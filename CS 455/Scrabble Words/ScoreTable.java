// Name: Georgios Iliadis	
// USC NetID: giliadis
// CS 455 PA4
// Spring 2018

/**
 * This class has information about how much each scrabble letter is worth. So
 * for each word that will be found from the letters that the user inputs in the
 * rack, then I will be able to get the score of that word.
 * 
 * @author Georgios Iliadis
 *
 */
public class ScoreTable {
	private static final int[] SCORE_TABLE = new int[] { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1,
			4, 4, 8, 4, 10 };
	private static final char LETTER_A = 'a';

	/**
	 * I create the array with scores for each letter manually as I know the value
	 * for each letter.
	 */
	public ScoreTable() {
	}

	/**
	 * I will get the score of each entered word, using the array ScoreTable and
	 * using the index value suggested in the description of the assignment.
	 * 
	 * @param word
	 *            The word for which the value will be returned depending on its
	 *            letters.
	 */
	public int getScore(String word) {
		int score = 0;
		String lowerCase = word.toLowerCase(); // Upper case and lower case letters have the same value so I will
												// convert everything to lower case.
		for (int i = 0; i < lowerCase.length(); i++) {
			score += SCORE_TABLE[lowerCase.charAt(i) - LETTER_A];
		}
		return score;
	}
}