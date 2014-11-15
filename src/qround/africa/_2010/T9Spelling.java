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
 * The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. 
 * We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. 
 * The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. 
 * In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time. 
 * The space character ' ' should be printed to indicate a pause. 
 * For example, 2 2 indicates AA whereas 22 indicates B.
 * 
 * 
 * Input
 * 
 * The first line of input gives the number of cases, N. N test cases follow. 
 * Each case is a line of text formatted as
 * desired_message
 * 
 * Each message will consist of only lowercase characters a-z and space characters ' '. 
 * Pressing zero emits a space.
 * 
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: " followed by the message translated into the sequence of keypresses.
 * 
 * Limits
 * 1 ¡Ü N ¡Ü 100.
 * Small dataset
 * 1 ¡Ü length of message in characters ¡Ü 15.
 * Large dataset
 * 1 ¡Ü length of message in characters ¡Ü 1000.
 * 
 * Sample
 * 
 * Input 
 * 4
 * hi
 * yes
 * foo  bar
 * hello world
 * 
 * Output 
 * Case #1: 44 444
 * Case #2: 999337777
 * Case #3: 333666 6660 022 2777
 * Case #4: 4433555 555666096667775553
 * 
 * 
 * @author CherryPisces
 *
 */


public class T9Spelling {
	
	public static String mapping(char alphabet) {
		switch (alphabet) {
		case 'a':
			return "2";
		case 'b':
			return "22";
		case 'c': 
			return "222";
		case 'd':
			return "3";
		case 'e':
			return "33";
		case 'f': 
			return "333";
		case 'g':
			return "4";
		case 'h':
			return "44";
		case 'i': 
			return "444";
		case 'j':
			return "5";
		case 'k':
			return "55";
		case 'l': 
			return "555";
		case 'm':
			return "6";
		case 'n':
			return "66";
		case 'o': 
			return "666";
		case 'p':
			return "7";
		case 'q':
			return "77";
		case 'r': 
			return "777";
		case 's':
			return "7777";
		case 't':
			return "8";
		case 'u': 
			return "88";
		case 'v':
			return "888";
		case 'w':
			return "9";
		case 'x': 
			return "99";
		case 'y': 
			return "999";
		case 'z': 
			return "9999";
		case ' ':
			return "0";
		default :
			return "";
		}
	
	}
		
	public static String solution(String msg) {	
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<msg.length();i++) {			
			if(i>=1) {
				if(mapping(msg.charAt(i-1)).charAt(0) == 
				   mapping(msg.charAt(i)).charAt(0)) {
					sb.append(" ");
				}
			}			
			sb.append(mapping(msg.charAt(i)));			
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir = System.getProperty("user.dir")+"\\src\\qround\\africa\\_2010\\";
		BufferedReader reader = new BufferedReader(new FileReader(dir+"C-large-practice.in"));		
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"C-large-practice.out"));
		
		int numOfCases = Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=numOfCases; i++) {		
			String msg = reader.readLine();			
			String translated_msg = solution(msg);	
			writer.println("Case #"+i+": "+translated_msg);
		}
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
