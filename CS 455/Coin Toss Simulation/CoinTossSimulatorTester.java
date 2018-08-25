
public class CoinTossSimulatorTester {

	public static void main(String[] args) {
		CoinTossSimulator simu = new CoinTossSimulator();
		
		System.out.println("After constructor: ");
		System.out.println("Number of trials [exp:0]: " + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoHeads());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(simu.check());
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.println("True");
		}
		else{System.out.println("False");}
		*/
		System.out.println();

		System.out.println("After run[1]: ");
		simu.run(1);
		System.out.println("Number of trials [exp:1]: " + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		System.out.println(simu.check());
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.println("True");
		}
		else{System.out.println("False");}
		*/
		System.out.println();

		
		
		System.out.println("After run[10]: ");
		simu.run(10);
		System.out.println("Number of trials [exp:11]: " + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.println("True");
		}
		else{System.out.println("False");}
		*/
		System.out.println(simu.check());
		System.out.println();

		

		System.out.println("After run[100]: ");
		simu.run(100);
		System.out.println("Number of trials [exp:111]: " + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.println("True");
		}
		else{System.out.println("False");}
		*/
		System.out.println(simu.check());
		System.out.println();

		
		
		System.out.println("After reset: ");
		simu.reset();
		System.out.println("Number of trials [exp: 0]: " + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.println("True");
		}
		else{System.out.println("False");}
		*/
		System.out.println(simu.check());
		System.out.println();

		
		System.out.println("After run[1000]: ");
		simu.run(1000);
		System.out.println("Number of trials [exp:1000]:" + simu.getNumTrials());
		System.out.println("Two-head tosses: "+ simu.getTwoHeads());
		System.out.println("Two-tail tosses: " + simu.getTwoTails());
		System.out.println("One-head one-tail tosses: " + simu.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		/*if(simu.getHeadTails() + simu.getTwoHeads() + simu.getTwoTails() == simu.getNumTrials()) {
			System.out.print("True");
		}
		else{System.out.print("False");}
		*/
		System.out.println(simu.check());
		
		
	}
	
}


