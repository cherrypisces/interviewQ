package _2014.round._1c;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	
	public static long permutation(int n) {
		long p =1;
		for(int i=2;i<=n;i++) {
			p = p*i;
		}
		return p;
	}
	
	public static long solution (String[] sets) {
		ArrayList<Integer>[] begin = new ArrayList[26];
		ArrayList<Integer>[] end   = new ArrayList[26];
		for (int i=0; i<26; i++) {
			begin[i] = new ArrayList<Integer>();
			  end[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<sets.length; i++) {
			char first = sets[i].charAt(0);
			char last = sets[i].charAt(sets[i].length()-1);
			
			begin[first-'a'].add(i);
			end[last-'a'].add(i);
		}
		
		int valid_sets = 0;
		long sum = 1;
		for(int i=0; i<26;i++) {
			if (end[i].size() == 0 || begin[i].size() == 0)
				continue;
			
			Collections.sort(begin[i]);
			Collections.sort(end[i]);
			
			int c = 0;
			for(int j=0; j<begin[i].size(); j++) {
				if (end[i].contains(begin[i].get(j))) {
					c++;
				}
			}
			
			long i_ways = 0;
			if (c > 0) {
				i_ways += permutation(c);
			} 
			if ((end[i].size()-c) > 0 && (begin[i].size()-c) > 0 ) {
				i_ways += (end[i].size()-c) * (begin[i].size()-c);
			} 
			
			if (i_ways >0) {
				valid_sets++;
				sum *= i_ways;
			}
		}
		System.out.println("valid_sets:" + valid_sets + " sum : " + sum);
		sum *= permutation(valid_sets);
		return sum;
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
				int N = reader.nextInt();
				String[] str = new String[N];
				for(int k=0; k<N; k++) {
					str[k] = reader.next();
				}
				long result = solution(str);
				System.out.println("Case #"+i+": "+result);
			//	writer.println("Case #"+i+": "+answer);
			}
			
			reader.close();
		//	writer.flush();
		//	writer.close();
	}

}
