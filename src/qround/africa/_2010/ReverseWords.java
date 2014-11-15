package qround.africa._2010;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * Problem
 * 
 * Given a list of space separated words, reverse the order of the words. 
 * Each line of text contains L letters and W words. 
 * A line will only consist of letters and space characters. 
 * There will be exactly one space character between each pair of consecutive words.
 * 
 * Input
 * The first line of input gives the number of cases, N.
 * N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. 
 * Spaces will not appear at the start or end of a line.
 * 
 * Output
 * For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.
 * 
 * Limits
 * 
 * Small dataset
 * N = 5
 * 1 ¡Ü L ¡Ü 25
 * 
 * Large dataset
 * N = 100
 * 1 ¡Ü L ¡Ü 1000
 * 
 * 
 * Sample
 * 
 * Input  
 * 3
 * this is a test
 * foobar
 * all your base
 * 
 * 
 * Output
 * Case #1: test a is this
 * Case #2: foobar
 * Case #3: base your all
 * 
 * 
 * @author CherryPisces
 *
 */


public class ReverseWords {
	
	public static String solution(String line) {
		String[] words = line.split(" ");
		StringBuilder reversed = new StringBuilder();
		for(int i=words.length-1; i>=1; i--) {
			reversed.append(words[i]);
			reversed.append(" ");
		}
		reversed.append(words[0]);		
		return reversed.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir = System.getProperty("user.dir")+"\\src\\qround\\africa\\_2010\\";
		BufferedReader reader = new BufferedReader(new FileReader(dir+"B-large-practice.in"));
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"B-large-practice.out"));
		
		int numOfCases = Integer.valueOf(reader.readLine());
		for(int i=1; i<=numOfCases; i++) {
			String line = reader.readLine();
			String reversed = solution(line);
			writer.println("Case #"+i+": "+reversed);
		}		
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
