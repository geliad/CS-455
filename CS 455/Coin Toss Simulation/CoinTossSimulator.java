import java.util.Random;

// Name:
// USC NetID:
// CS 455 PA1
// Spring 2018

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
	private int num_twoheads;
	private int num_twotails;
	private int num_headtail;
	private int num_trials;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   num_trials = 0;
	   num_headtail = 0;
	   num_twotails = 0;
	   num_twoheads = 0;

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	   int origNumTrial = num_trials;
	   num_trials = num_trials + numTrials;
	   Random gen1 = new Random();
	   Random gen2 = new Random();
	   
	   for(int i = origNumTrial + 1; i <= num_trials; i++) {
		   int value1 = gen1.nextInt(2);
		   int value2 = gen2.nextInt(2);
		   //.out.println(value1 + " " + value2);
		   //when random number = 0 -> heads
		   //when random number = 1 -> tails
	   
		   if(value1==0 && value2 == 0) {
			   num_twoheads++;
		   }
		   else if( (value1 == 0 && value2 == 1) || (value1 == 1 && value2 == 0) ){
			   num_headtail++;
		   }
		   else if(value1 ==1 && value2 == 1){
			   num_twotails++;
		   }
	   }
   }
   
   /**
      Returns true if number of trials equals number of heads plus number of tails plus number of headtails.
      @return
    */
   public boolean check() {
	   return num_trials == num_twoheads + num_twotails + num_headtail;
   }
	 
   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return num_trials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return num_twoheads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return num_twotails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return num_headtail; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   num_trials = 0;
	   num_headtail = 0;
	   num_twoheads = 0;
	   num_twotails = 0;

   }

}
