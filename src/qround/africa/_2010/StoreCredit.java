package qround.africa._2010;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * http://code.google.com/codejam/contest/351101/dashboard#s=p0
 * 
 * Problem
 * You receive a credit C at a local store and would like to buy two items. 
 * You first walk through the store and create a list L of all available items. 
 * From this list you would like to buy two items that add up to the entire value of the credit. 
 * The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first)
 * 
 * Input
 * The first line of input gives the number of cases, N. N test cases follow. 
 * For each test case there will be:
 * 		One line containing the value C, the amount of credit you have at the store.
 * 		One line containing the value I, the number of items in the store.
 * 		One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
 * 		Each test case will have exactly one solution.
 * 
 * Output
 * For each test case, output one line containing "Case #x: " 
 * followed by the indices of the two items whose price adds up to the store credit. 
 * The lower index should be output first.
 * 
 * Limits
 * 5 ¡Ü C ¡Ü 1000
 * 1 ¡Ü P ¡Ü 1000
 * 
 * Small dataset
 * N = 10
 * 3 ¡Ü I ¡Ü 100
 * 
 * Large dataset
 * N = 50
 * 3 ¡Ü I ¡Ü 2000
 * 
 * Sample
 * 
 * Input 
 * 3
 * 100
 * 3
 * 5 75 25
 * 200
 * 7
 * 150 24 79 50 88 345 3
 * 8
 * 8
 * 2 1 9 4 4 56 90 3
 * 
 * Output 
 * Case #1: 2 3
 * Case #2: 1 4
 * Case #3: 4 5
 * 
 * 
 * 
 * @author CherryPisces
 *
 */


public class StoreCredit {

	protected static int[] solution(int credit, int[] items, int[] statistics) {
		int[] found = new int[]{-1, -1};
		
		for(int i=1;i<1001;i++) {
			if( ((i!=credit-i) && statistics[i]>0 && statistics[credit-i]>0) || 
				((i==credit-i) && statistics[i]>1) ) {
				
				int one=i, another=credit-i;				
				for(int j=0; j<items.length; j++) {
				
					if(items[j]==one || items[j]==another) {
						if(found[0]==-1) {
							found[0] = j+1;
							continue;
						} else {
							found[1] = j+1;
							break;
						}
					}
				}				
				
				break;
			}
		}
		
		return found;
	}
	
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		String dir = System.getProperty("user.dir")+"\\src\\qround\\africa\\_2010\\";
		Scanner reader = new Scanner(new FileReader(dir+"A-large-practice.in"));
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"A-large-practice.out"));
		
		int numOfCases = reader.nextInt();
		
		for(int i=1; i<=numOfCases; i++) {
			
			int credit = reader.nextInt();
			int[] statistics = new int[1001];
			int len = reader.nextInt();
			int[] items = new int[len];
			for(int j=0; j<len; j++) {
				items[j] = reader.nextInt();
				statistics[items[j]]++;
			}
			
			int[] pos = solution(credit, items, statistics);
			
			writer.println("Case #"+i+": "+pos[0]+" "+pos[1]);
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
