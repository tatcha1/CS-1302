import java.net.URL;
import java.util.Scanner;
public class WordCount {

	public static void main(String[] args) {
		try{
			URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			int score = 0;
			Scanner scan = new Scanner(url.openStream());
			while (scan.hasNext()) {
				String line = scan.nextLine();
				score += line.split(" ").length;
			}
			
			System.out.println("The number of words is: " + score);
		}
		catch(java.net.MalformedURLException ex){
			System.out.println("I/O Errors: no such file");
		}
		catch(java.io.IOException ex){
			System.out.println("I/O Errors: no such file");
		}
	}
}

