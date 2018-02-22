
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class NamePopularity {

	public static void main(String[] args){
		String loc = "";
		Scanner scan = new Scanner(System.in);
		ArrayList <String> Names = new ArrayList<String>();
		try{
			System.out.println("Enter the year: ");
			int year = scan.nextInt();
			System.out.println("Enter the gender: ");
			String gender = scan.next();
			System.out.println("Enter the name: "); 
			String name = scan.next();
			scan.close();
			
			File file = new File(System.getProperty("user.dir")+"\\src\\babynameranking" + year + ".txt");
			Scanner fileScan = new Scanner(file);
			while(fileScan.hasNextLine()){
				String s = fileScan.nextLine() +" ";
				s = s.trim();

				String[] sArray = s.split("\t");
				for(int i=0;i<sArray.length;i++){
					
				}
				for(String temp : sArray)
					Names.add(temp);
			}
			fileScan.close();
			Iterator iterate = Names.iterator();
			while(iterate.hasNext()){
				String val = (String)iterate.next();
				
			}
			
			int start = gender.charAt(0)=='M' ? 1 : 2;
			for(int i = start; i < Names.size(); i+=3){
				if( name.equals(Names.get(i)) ){
					loc = Names.get( i - (gender.charAt(0)=='M' ? 1 : 2) );
				}
			}
		
			System.out.println(name + " is ranked " + loc + " in year " + year);
			
		}
		catch(Exception ex){
			System.out.println("I/O Errors: no such file"); 
		}
		
	}
	


}
