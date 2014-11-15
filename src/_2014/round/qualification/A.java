package _2014.round.qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static String solution (int[] first, int[] second, int row1, int row2) {

		int answer = 0;
		boolean[] counter = new boolean[16];
		
		for(int k=(row1-1)*4; k<row1*4; k++){
			counter[first[k]-1] = true;
		}
		
		boolean hasDup = false; 
		for(int k=(row2-1)*4; k<row2*4; k++){
			if (counter[second[k]-1]) {
				if(hasDup) return "Bad magician!";				
				answer = second[k];	
				hasDup = true;
			} else {
				counter[second[k]-1] = true;
			}
		}
		
		if(answer != 0) 
			return Integer.toString(answer);
		else
			return "Volunteer cheated!";
	}
	
	public static void main(String[] args) throws IOException {
		
		String dir = System.getProperty("user.dir")+"\\src\\round\\qualification\\";
		Scanner reader = new Scanner(new FileReader(dir+"A-small-attempt0.in"));
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"A-small-attempt0.out"));
		
		int numOfCases = reader.nextInt();
		for(int i=1; i<=numOfCases; i++) {
			int row1 = reader.nextInt();
			int[] first = new int[16];
			for(int j=0; j<16; j++)
				first[j] = reader.nextInt();
			
			int row2 = reader.nextInt();
			int[] second = new int[16];
			for(int j=0; j<16; j++)
				second[j] = reader.nextInt();

			String answer = solution(first, second, row1, row2);

			writer.println("Case #"+i+": "+answer);
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
