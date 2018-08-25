import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of trials: ");
		int trials = in.nextInt();
		
		while(trials<1) {
			System.out.println("ERROR: Number entered must be greater than 0!");
			System.out.print("Enter number of trials: ");
			trials = in.nextInt();
		}
		
		JFrame frame = new JFrame();
		frame.setSize(800,500);
		frame.setTitle("Coin Sim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CoinSimComponent component = new CoinSimComponent(trials);
		component.runSimu();
		frame.add(component);
		frame.setVisible(true);
	}
}


		
	
