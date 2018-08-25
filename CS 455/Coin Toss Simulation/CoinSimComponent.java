import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws three bar shapes where the height is determined by the number of
   heads,tails and headtails. When resizing the frame, the simulation doesn't run again,
   the only thing that changes is the scale, thus the bars are resized on the frame.
 */

public class CoinSimComponent extends JComponent{
	
	private static final int BAR_WIDTH = 50;
	private static final int VERTICAL_BUFFER = 40;
	private static final int HEIGHT_OF_LABEL = 15;//Calculated from Bar.java , same for all labels
	private int nTrials;
	private int nTails;
	private int nHeads;
	private int nHeadsTails;
	
	/**
	   Creates a CoinSimComponent object in order to paint the component
	   in the frame and run the simulation out of the paintComponent method.
	   @param trials number of trials
	 */
	
	public CoinSimComponent(int trials) {
		nTrials = trials;
	}

	/**
	   I need to create a CTS object and use the run method, so that every time I resize
	   the frame, it would not run the run method again. 
	   So by resizing, I will not call the run again.
	 */
	
	public void runSimu() {
		CoinTossSimulator simulator = new CoinTossSimulator();
		simulator.run(nTrials);
		nHeads = simulator.getTwoHeads();
		nTails = simulator.getTwoTails();
		nHeadsTails = simulator.getHeadTails();
	}
			
	public void paintComponent(Graphics g) {
			
		Graphics2D g2 = (Graphics2D) g;
		 
		int width =  getWidth();
		int height = getHeight(); // height = 444
		
		int heightExcludingBar = (2*VERTICAL_BUFFER + HEIGHT_OF_LABEL);
		int h = height - heightExcludingBar;
		
		double scale1 = h * nHeads/nTrials;
		double scale2 = h * nHeadsTails / nTrials ;
		double scale3 = h * nTails / nTrials;
		
		int heightBelowBarStart = VERTICAL_BUFFER + HEIGHT_OF_LABEL;
		
		int bottom1 = height - heightBelowBarStart - (int)scale1;//htan - barheight1
		int bottom2 = height - heightBelowBarStart - (int)scale2;
		int bottom3 = height - heightBelowBarStart - (int)scale3;
		
		//width = 778
		//bar width = 50
		int left1 =  width/4 - BAR_WIDTH/2;
		int left2 = 2 * width/4 - BAR_WIDTH/2;
		int left3 = 3 * width/4 - BAR_WIDTH/2;
		
		int per1 = nHeads*100 / (int) nTrials;
		int per2 = nHeadsTails*100 / (int) nTrials;
		int per3 = nTails*100 / (int) nTrials ;
		
		Bar bar1 = new Bar(bottom1, left1 , BAR_WIDTH, nHeads, scale1, Color.RED, "Two Heads: " + nHeads + "("+ per1 +"%)");
		Bar bar2 = new Bar(bottom2, left2 , BAR_WIDTH, nHeadsTails, scale2, Color.GREEN, "One Head and one Tail: " + nHeadsTails + "(" + per2 + "%)");
		Bar bar3 = new Bar(bottom3, left3 , BAR_WIDTH, nTails, scale3, Color.BLUE, "Two Tails: " + nTails + "(" + per3 + "%)");
		
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);

		System.out.println("Height: " + height);
		//System.out.println("Width: " + width);
		//System.out.println(height + "-" + sc1 + "-" + heightBelowBarStart);
		//System.out.println(height + "-" + sc2 + "-" + heightBelowBarStart);
		//System.out.println(height + "-" + sc3 + "-" + heightBelowBarStart);
		//System.out.println("Bottom 1: "+bottom1);
		//System.out.println("Bottom 2: "+bottom2);
		//System.out.println("Bottom 3: "+bottom3);
		//System.out.println("Scale1: " + sc1);
		System.out.println("Height tou prwtou: "+scale1);
		System.out.println("Height tou deuterou: "+scale2);
		System.out.println("Height tou tritou: "+scale3);
		System.out.println(h + " * " + nHeadsTails + " / " + nTrials );
		//System.out.println("Height tou tritou: "+bh3*sc);
		
					

	}
}

