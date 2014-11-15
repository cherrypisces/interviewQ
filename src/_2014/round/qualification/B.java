package _2014.round.qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	
	public static double solution (double C, double F, double X) {		
		double seconds = 0.0;
		
		if (C>=X) {
			seconds = X/2.0;
			return seconds;
		} 
		
		int farms = 0;
		seconds = C/2.0;
		while(true) {			
			double t_not_buy = (X-C) / (farms * F + 2.0);
			double t_buy = X/((farms+1) * F + 2.0);
			if(t_not_buy < t_buy) {
				seconds += t_not_buy;
				break;
			}
			else {
				farms++;	
				seconds += C/(farms * F + 2.0);
			}
		}
		
		return seconds;
	}
	
	public static void main(String[] args) throws IOException {
		String dir = System.getProperty("user.dir")+"\\src\\round\\qualification\\";
//		Scanner reader = new Scanner(new FileReader(dir+"B-small-attempt0.in"));
//		PrintWriter writer = new PrintWriter(new FileWriter(dir+"B-small-attempt0.out"));
		Scanner reader = new Scanner(new FileReader(dir+"B-large.in"));
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"B-large.out"));

		int numOfCases = reader.nextInt();
		for(int i=1; i<=numOfCases; i++) {
			double C = reader.nextDouble();
			double F = reader.nextDouble();
			double X = reader.nextDouble();
			
			double minSeconds = solution(C, F, X);
			
			writer.println("Case #"+i+": "+String.format("%.7f", minSeconds));
		} 
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
