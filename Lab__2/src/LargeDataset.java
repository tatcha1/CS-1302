import java.util.*;
import java.io.*;
import java.net.URL;

public class LargeDataset {

	public static void main(String[] args) {
		ArrayList<Double> assistant = new ArrayList<>();
		ArrayList<Double> associate = new ArrayList<>();
		ArrayList<Double> full = new ArrayList<>();
		ArrayList<Double> all = new ArrayList<>();
		
		try{
			URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
			Scanner scan = new Scanner(url.openStream());
			
			while (scan.hasNext()) {
				String list = scan.nextLine(); //grab current line from scanner
				String[] ln = list.split(" ");  //[0] -> first name, [1] -> last name, [2] -> rank, [3] -> salary
				
				//get rank and salary from line
				String rank = ln[2];
				double salary = Double.parseDouble(ln[3]);
				
				//store salary in arraylist for the current rank
				if (rank.equalsIgnoreCase("assistant")){
					assistant.add(salary);
				} else if (rank.equalsIgnoreCase("associate")){
					associate.add(salary);
				} else if (rank.equalsIgnoreCase("full")) {
					full.add(salary);
				}	
				
				all.add(salary);
			}
			
			double totalAssistant =  totalSalary(assistant);
			double totalAssociate =  totalSalary(associate);
			double totalFull =  totalSalary(full);
			double totalAll =  totalSalary(all);
			
			System.out.printf("The assistants' salary is: $%.2f\n", totalAssistant);
			System.out.printf("The associates' salary is: $%.2f\n", totalAssociate);
			System.out.printf("The full professors' salary is: $%.2f\n", totalFull);
			System.out.printf("Total salaries paid: $%.2f\n\n", totalAll);
			

			System.out.printf("The average assistants' salary is: $%.2f\n", totalAssistant/assistant.size());
			System.out.printf("The average associates' salary is: $%.2f\n", totalAssociate/associate.size());
			System.out.printf("The average full professors' salary is: $%.2f\n", totalFull/full.size());
			System.out.printf("The average salary overall is: $%.2f\n", totalAll/all.size());
			
		}	
		catch(java.net.MalformedURLException ex){
			System.out.println("I/O Errors: no such file");
		}
		catch(java.io.IOException ex){
			System.out.println("I/O Errors: no such file");
		}
	}
	
	public static double totalSalary(ArrayList<Double> x) {
		double salary = 0;
		for(int i = 0; i < x.size(); i++){
			salary += x.get(i);
		}
		return salary;
	}

}
