package my.heartbroken.google;

import my.common.utils.Utilities;

public class MCharsSubstr 
{
	public static String getSubstrOfMChars(String str, int m) 
	{
		if (str==null || str.length()==0)
			return "";		
		
		int len = str.length();		
		String max = "";
		
		for(int i=0; i<len;) 
		{	
			StringBuilder sb = new StringBuilder();
			int counter = 1;
			int checker = 0;
			char firstChar = str.charAt(i);
			int firstCharPos = i;    // first char position in the string
			sb.append(firstChar);
			checker |= 1 << (firstChar - 'a');
			
			for(int j=i+1; j<len; j++) {	
				char currChar = str.charAt(j);
				if (currChar == firstChar) 
					firstCharPos++;				

				int tester = checker & (1<<(currChar - 'a'));
				if ( tester > 0 ) // already have such character
				{
					sb.append(currChar);
					continue;
				}

				// new character
				if (++counter > m) 
				{
					i = firstCharPos + 1;
						
					if (sb.length() > max.length()) {
						max = sb.toString();
					}
					break;
				}
				sb.append(currChar);					
				checker |= 1 << (currChar - 'a');				
			}
			
			if (counter <= m) {				
				if ((counter==m) && sb.length() > max.length()) {
					max = sb.toString();
				}				
				break;
			}
			
		}
		
		return max;
		
	}
	
	
	public static boolean contains(char[] array, char s) {
		
		for(char c : array) {
			if (c == s)
				return true;
		}
		
		return false;
	}
	
	public static int getPos(char[] array, char s) {
		
		for(int i=0; i<array.length; i++) {
			if (array[i] == s)
				return i;
		}
		
		return -1;
	}
	
	
	/*
	 * 
	 * http://stackoverflow.com/questions/21119224/find-longest-substring-of-n-unique-characters
	 * 
	 */
	public static String getLongestSubStrOfMChars(String str, int n) {
		
		int i=0, j=0, counter=0;
		int[] res = new int[2];
		char[] char_array = new char[n];
		int[] last = new int[n];
		
		while(i < str.length()) {
			
			if (j < str.length()) {
				if (counter<n && !contains(char_array, str.charAt(j))) {
					char_array[counter] = str.charAt(j);
					last[counter] = j;
					counter++;	
				} else {
					last[getPos(char_array, str.charAt(j))] = j;
					j++;
				}
								
				if (counter == n  && j-i > res[1]-res[0]) {
					res[0] = i;
					res[1] = j;
				}
				
				char fristChar = str.charAt(i);
				i = last[getPos(char_array, fristChar)] + 1;
				char_array[getPos(char_array, fristChar)] = ' ';
				counter--;
			}
		}
		
		return str.substring(res[0], res[1]+1);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("");		
		int lengthOfStr = Utilities.randomIntInRange(0, 60);
		for(int i=0; i<lengthOfStr; i++) {
			char c = (char)Utilities.randomIntInRange(97, 122);
			sb.append(c);
		}
		System.out.println("The string is:\n" + sb.toString());
	//	int m = Utilities.randomIntInRange(2, 6);
		int m = 3;
		String s = "abcdeefuiuiwiwwaaaa";
		System.out.println("\noriginal str is:" + s);
		System.out.print("The longest substring with " +m+ " characters are: ");
		String substr = MCharsSubstr.getSubstrOfMChars(s, m); 
		System.out.println(substr);
		System.out.println("Use stackoverflow answer: " + getLongestSubStrOfMChars(s, m));
		
	}

}
