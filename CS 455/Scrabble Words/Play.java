import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Play {

	public static void main(String[] args) throws FileNotFoundException {
		ScoreTable scr = new ScoreTable();
		Rack x = new Rack("pool");
		System.out.println("Score tou Hello einai: " + scr.getScore("Hello"));
		String a = x.getRack();
		System.out.println("\"" + x.getRack() + "\"");
		System.out.println(Arrays.toString(x.getMult()));
		
		AnagramDictionary ana = new AnagramDictionary("sowpods.txt");

		}
		
	}


