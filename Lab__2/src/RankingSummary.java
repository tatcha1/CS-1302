import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RankingSummary {

	public static void main(String[] args) {
		try{
			printHeader();
			printNames();
		} catch(FileNotFoundException ex) {
			System.out.println("I/O Errors: no such file"); 
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public static void printHeader(){
		for(int i = 0; i < 110; i++) System.out.print("-");
		
		System.out.print("\nYear");
		
		for(int i = 0; i < 2; i++){				
			for(int rank = 1; rank <= 5; rank++){
				System.out.print("    Rank " + rank);
			}
		}
		System.out.println("");
		for(int i = 0; i < 110; i++) System.out.print("-");
		System.out.println("");
	}
	
	public static void printNames()throws FileNotFoundException {
		for(int year = 2010; year >= 2001; year--){
			File file = new File(System.getProperty("user.dir")+"\\src\\babynameranking" + year + ".txt");
			Scanner fileScan = new Scanner(file);
			System.out.print(year);
			
			ArrayList <String> boyNames = new ArrayList<>();
			ArrayList <String> girlNames = new ArrayList<>();
			
			//Load Names into lists based on gender
			while(fileScan.hasNext()){
				int Rank = fileScan.nextInt();
				String BoyName = fileScan.next();
				boyNames.add(BoyName);
				String GirlName = fileScan.next();
				girlNames.add(GirlName);
			}
			
			for(int i =0; i < 5; i++){
				System.out.print("    " + girlNames.get(i));
			}
			for(int i = 0; i < 5; i++){
				System.out.print("    " + boyNames.get(i));
			}
			System.out.println("");
			
		}

	}

}
