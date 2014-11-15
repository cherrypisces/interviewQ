package _2014.round._1c;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C {
	
	public static void solution () {		

	}
	
	public static void main(String[] args) throws IOException {
		//	String dir = System.getProperty("user.dir")+"\\src\\round\\qualification\\";
		//	Scanner reader = new Scanner(new FileReader(dir+"A-small-attempt0.in"));
		//	PrintWriter writer = new PrintWriter(new FileWriter(dir+"A-small-attempt0.out"));
			
		//	Scanner reader = new Scanner(new FileReader(dir+"A-large.in"));
		//	PrintWriter writer = new PrintWriter(new FileWriter(dir+"A-large.out"));	
			
			Scanner reader=new Scanner(System.in);
			
			int numOfCases = reader.nextInt();
			for(int i=1; i<=numOfCases; i++) {		
				solution();
				System.out.println("Case #"+i+": ");
			//	writer.println("Case #"+i+": "+answer);
			}
			
			reader.close();
		//	writer.flush();
		//	writer.close();
	}

}
