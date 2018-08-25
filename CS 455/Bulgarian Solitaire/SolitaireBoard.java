// Name:Georgios Iliadis
// USC NetID:giliadis
// CSCI455 PA2
// Spring 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
   The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
   by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
   for CARD_TOTAL that result in a game that terminates.
   (See comments below next to named constant declarations for more details on this.)
 */

public class SolitaireBoard {
	   
	public static final int NUM_FINAL_PILES = 9;
	// number of piles in a final configuration
	// (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
	   
	public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
	// bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
	// see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
	// the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

	private int [] board = new int[CARD_TOTAL];
	// New array of length CARD_TOTAL, in most cases it will be partially filled.
 
	private int numPiles;
	// 1<= numPiles <= 45, numPiles is equivalent to the numNames in the lecture example.
	// The sum of the value of elements should be CARD_TOTAL.
	// Each element in the array should be greater than 0.
	// numPiles stand for number of piles. It shows how many piles will be used, in other words,
	// how many elements will be in the array. Each array element is one pile.
	    
	private int counts = 1;
	// This is the number of times the playRound method will run.
	// I created this variable in order to be able to print out the number of times the playRound
	// method will need to run in order to end the game.
	    
	 
	    /**
	     Creates a solitaire board with the configuration specified in piles.
	     piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
	     PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
	    */
	   public SolitaireBoard(ArrayList<Integer> piles) {
	       
	     board = new int[CARD_TOTAL]; 
	     numPiles = piles.size();

	     for(int i = 0; i < piles.size(); i++) { //Converts ArrayList(piles) to Array(board).
	       board[i] = piles.get(i);
	     }
	     printInitialConf(board,numPiles);
	       
	     assert isValidSolitaireBoard();    
	   }
	 
	   
	   /**
	      Creates a solitaire board with a random initial configuration.
	   */
	   public SolitaireBoard() {
	     board = new int[CARD_TOTAL];
	     Random generator = new Random();
	       // We have an array of CARD_TOTAL length so I will create random numbers to fill the array.
	       // The sum of the elements must add up to CARD_TOTAL.

	     int i = 0;
	     int sum = 0;
	     numPiles = 0;
	     boolean rand = true;
	     while(rand){
	       board[i] = 1 + generator.nextInt(CARD_TOTAL - sum); 
		   // Creates a random number from 1 to (45 - the sum of the previous elements from that index).
	       sum = sum + board[i];
	       i++;
	       numPiles++;
	       
	       if(sum == CARD_TOTAL){rand = false;}
	     } 
	     printInitialConf(board,numPiles);
	       
	     assert isValidSolitaireBoard();
	   }
	  
	   
	   /**
	      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
	      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
	      The old piles that are left will be in the same relative order as before, 
	      and the new pile will be at the end.
	    */
	   public void playRound() {
	     int count = 0;
	     // count is the number of cards you remove from board to board2.
	     // I created it in order to know what will be the last element of my board after each round.
	     int j = 0;
	     int [] board2 = new int[CARD_TOTAL];
	     // I will create a second array, where I will add the new elements of the board array, excluding the 1s.
	     // This way I will be able to make sure that the pile of element 1 is deleted after playing 1 round.

	     for(int i = 0 ; i < numPiles; i++){
	       if(board[i] != 1){
	         board2[j] = board[i] - 1;
	         j = j+1;
	    	 count++;
	       }
	       else{
	         count++;
	       }
	     }
	       
	     board = board2;
	     board[j] = count;
	     numPiles = j+1;

	     System.out.print("[" + counts + "]" + " Current configuration: " + this.configString());
	     counts++;
	     System.out.println("");
	       
	     assert isValidSolitaireBoard();
	   }
	   
	   /**
	      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
	      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
	    */
	   
	   public boolean isDone() {		   
	     assert isValidSolitaireBoard();

	     if(numPiles != NUM_FINAL_PILES) {
	       return false;
	     }
	     else {
	       int[] board3 = board.clone();
	       Arrays.sort(board3);
	       int diff = CARD_TOTAL - NUM_FINAL_PILES;
	       for(int i = diff; i < CARD_TOTAL; i++){
	         if(board3[i] != i - diff + 1){
	    	   return false;
	    	 }
	       }
	     }
	     return true;
	       
	       // I will test if the number of piles in my array is the same as the NUM_FINAL_PILES.
	       // If it is, then I will create a new array, board3, in order to be able to sort it.
	       // I will be able to sort it without having any problems with the playRound method.
	       // If I didn't create a new array, then the board would have been sorted, and the playRound
	       // method would have used the new sorted board array to continue picking up cards.
	       // In the case of CARD_TOTAL = 45, I will start the loop from i=36, because the sorted array
	       // will contain 0s at start. Since I know that the numPiles=NUM_FINAL_PILES=9,I could calculate i=36.
	   }

	   
	   /**
	      Returns current board configuration as a string with the format of
	      a space-separated list of numbers with no leading or trailing spaces.
	      The numbers represent the number of cards in each non-empty pile.
	    */
	   public String configString() {
	       
		 String string = "";
	     for(int y = 0; y < numPiles - 1; y++){
	  	   string = string + board[y] + " ";
	     }
	     
	     string = string + board[numPiles -1];
	     assert isValidSolitaireBoard();
	     return string;
	   }
	   
	   /**
	      Returns true iff the solitaire board data is in a valid state
	      (See representation invariant comment for more details.)
	    */
	   private boolean isValidSolitaireBoard() {
	     int sum = 0;
	     //int numberOfPilesTest =0;
	     //loop to check that value at each pile is greater than 0 and less or equal to CARD_TOTAL
	     for(int i = 0; i < numPiles; i++){
	    	 sum = sum + board[i];
	    	 if(board[i] > 0 && board[i] <= CARD_TOTAL){
	         //numberOfPilesTest++;
	    		 return false;
	       }
	       else{
	         return false;
	       }
	     }
	     //If statement to make sure that the number of piles is correct.
	     //if(numberOfPilesTest != numPiles) {
	       //return false;
	     //}
	     //If statement to make sure that the sum of the array elements is equal to CARD_TOTAL
	     if(sum != CARD_TOTAL){
	       return false;
	     }
	     return true;
	   }
	   
	   private static void printInitialConf(int[] arr, int numberOfPiles) {
	     System.out.print("Initial configuration: ");
		 for(int y = 0; y < numberOfPiles; y++){
		   System.out.print(arr[y] + " ");
    	 }
		 System.out.println("");
	   }
	    
	}

