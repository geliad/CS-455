import java.util.ArrayList;
import java.util.Scanner;

// Name:Georgios Iliadis
// USC NetID: giliadis
// CSCI455 PA2
// Spring 2018


/**
   Runs a bulgarian solitaire simulator using the SolitaireBoard class. Sometimes it asks for user 
   input and checks if what's entered is correct and it can create its own random board as
   implemented in the SolitareBoard class.
 */

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }

      if(userConfig == true){
    	  ArrayList<Integer> A = new ArrayList<Integer>();
    	  Scanner in = new Scanner(System.in);
    	  boolean askForInput = true;
    	  System.out.println("Number of total cards is 45");
    	  System.out.println("You will be entering the initial configuration of the cards(i.e., how many in each pile).");
    	  
    	  while(askForInput == true){
    	      A = new ArrayList<Integer>();
    	      System.out.println("Please enter a space-separated list of positive integers followed by newline: ");
    	      String B = in.nextLine();
    	      Scanner in2 = new Scanner(B);
    	      askForInput = false;
    	      int sum = 0;
    	      
    	      while(in2.hasNextInt()){ //Error checking that the values entered are >0.
    	    	  int C = in2.nextInt();
    	    	  if(C > 0){
    	    		  A.add(C);
    	    		  sum += C;
    	    	  }
    	    	  else if(C<= 0){
    	    		  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
    	    		  askForInput = true;
    	    		  break;
    	    	  }
    	      }
    	      
    	      if (!askForInput){
    	    	  if (sum == SolitaireBoard.CARD_TOTAL){ 
    	    		  askForInput = false;
    	    	  }
    	    	  else {
    	    		  System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45");
    	    		  askForInput = true;
    	    	  }
    	      }
    	  }
          
    	  SolitaireBoard userInput = new SolitaireBoard(A);
    	  
    	  if(singleStep == false){
    	      while(userInput.isDone() == false){
    	    	  userInput.playRound();
    	      }
    	      if(userInput.isDone() == true){
    	    	  System.out.println("Done!");
    	      }
    	  }
    	  
    	  else if(singleStep == true){
    	      while(userInput.isDone() == false){
    	    	  System.out.println("<Type return to continue>");
    	    	  new Scanner(System.in).nextLine();
    	    	  userInput.playRound();
    	      }
    	      if(userInput.isDone() == true){
    	    	  System.out.println("Done!");
    	      }
    	  }
          }
          
          else{
        	  SolitaireBoard randInput = new SolitaireBoard();
    	  
        	  if(singleStep == false){
        		  while(randInput.isDone() == false){
        			  randInput.playRound();
        		  }
        		  if(randInput.isDone() == true){
        			  System.out.println("Done!");
        		  }
        	  }
        	  else{
        		  while(randInput.isDone() == false){
        			  System.out.println("<Type return to continue>");
        			  new Scanner(System.in).nextLine();
        			  randInput.playRound();
        		  }
        		  if(randInput.isDone() == true){
        			  System.out.println("Done!");
        		  }
        	  }
          }         	 
      
   }
  
  
}