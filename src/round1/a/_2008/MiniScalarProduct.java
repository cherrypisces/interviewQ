package round1.a._2008;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Problem
 * 
 * You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). 
 * The scalar product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.
 * Suppose you are allowed to permute the coordinates of each vector as you wish. 
 * Choose two permutations such that the scalar product of your two new vectors is the smallest possible, and output that minimum scalar product.
 * 
 * Input
 * The first line of the input file contains integer number T - the number of test cases. 
 * For each test case, the first line contains integer number n. 
 * The next two lines contain n integers each, giving the coordinates of v1 and v2 respectively.
 * 
 * 
 * Output
 * For each test case, output a line
 * 		Case #X: Y
 * where X is the test case number, starting from 1, 
 * and Y is the minimum scalar product of all permutations of the two given vectors.
 * 
 * 
 * Limits
 * 
 * Small dataset
 * T = 1000
 * 1 ¡Ü n ¡Ü 8
 * -1000 ¡Ü xi, yi ¡Ü 1000
 * 
 * Large dataset
 * T = 10
 * 100 ¡Ü n ¡Ü 800
 * -100000 ¡Ü xi, yi ¡Ü 100000
 * 
 * 
 * Sample
 * 
 * Input
 * 2
 * 3
 * 1 3 -5
 * -2 4 1
 * 5
 * 1 2 3 4 5
 * 1 0 1 0 1
 * 
 * Output 
 * Case #1: -25
 * Case #2: 6
 * 
 * 
 * @author CherryPisces
 *
 */


////  TO avoid stack overflow:
////  	-- use none-recursive
////  	-- avoid sort on sorted-arrays: pick random pivot

public class MiniScalarProduct {
	public static int partition(int[] array, int start, int end) {
		Random rand = new Random();
		int pos = rand.nextInt(end-start+1)+start;
		swap(array, end,  pos);
        int pivot = array[end];
		
		int less = start-1;
		int curr = start-1;
		while(curr < end) {
			curr++;			
			if (array[curr] < pivot) {
				less++;		
				swap(array, less, curr);
			}
		}
		swap(array, less+1, end);
		return less+1;
	}
	
	private static void swap(int[] array, int idx1, int idx2) {
		if(idx1 != idx2) {
			array[idx1] = array[idx1] ^ array[idx2];
			array[idx2] = array[idx2] ^ array[idx1];
			array[idx1] = array[idx1] ^ array[idx2];
		}
	}
	
	public static void qsort(int[] array, int start, int end) {
		if ( start >= end ) return;
		int pos = partition(array, start, end);	
		qsort(array, start, pos-1);
		qsort(array, pos+1, end);
	}	
	
	// none recursive way
	// reference : https://community.oracle.com/thread/1661642?tstart=0
	public static void better_qsort(int[] array) {
		int[] subIndex = new int[100];
		
		int to_resolve = 2;
		int left = 0, right = array.length-1;
		while(to_resolve > 0) 
		{
			if (left < right) 
			{
				int pivot = partition(array, left, right);				
				// always pick small sub problem to resolve first
				if ( (pivot-left) < (right-pivot) ) 
				{
					subIndex[to_resolve] = pivot+1;
					subIndex[to_resolve+1] = right;
					right = pivot - 1;
				} 
				else 
				{
					subIndex[to_resolve] = left;
					subIndex[to_resolve+1] = pivot-1;
					left = pivot + 1;
				}				
				to_resolve += 2;
			} 
			else 
			{
				to_resolve -= 2;
				left	= subIndex[to_resolve];
				right 	= subIndex[to_resolve+1];
			}
		}
	}
	
	public static void print(int[] array, int start, int end) {
		System.out.print("after:");
		for(int i=start; i<=end; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static long solution(int[] v1, int[] v2) {
		qsort(v1, 0, v1.length-1);
		qsort(v2, 0, v2.length-1);

		BigInteger min = new BigInteger("0");
		for(int i=0; i<v1.length; i++) {	
			BigInteger left = new BigInteger(Integer.toString(v1[i]));
			BigInteger right = new BigInteger(Integer.toString(v2[v1.length-1-i]));
			min = min.add(left.multiply(right));
		}
		
		return min.longValue();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir = System.getProperty("user.dir")+"\\src\\round1\\a\\_2008\\";
		Scanner reader = new Scanner(new FileReader(dir+"A-large-practice.in"));
		PrintWriter writer = new PrintWriter(new FileWriter(dir+"A-large-practice.out"));
	
		int numOfCases = reader.nextInt();
		for(int i=1; i<=numOfCases; i++) {
			int dimension = reader.nextInt();
			int[] v1 = new int[dimension];
			int[] v2 = new int[dimension];
			for(int t=0; t<dimension; t++) {
				v1[t] = reader.nextInt();
			}
			for(int t=0; t<dimension; t++) {
				v2[t] = reader.nextInt();
			}
			
			long result = solution(v1, v2);
			
			writer.println("Case #"+i+": "+result);
		}	
		reader.close();
		writer.close();
		
		////// purely test for non recursive quick sort ///////
		int [] arr = Utilities.randomArray(20, 1, 30);
		Utilities.printArray(arr);
		better_qsort(arr);
		System.out.println("after sort:");
		Utilities.printArray(arr);
		
		ArrayList<Integer> tt = new ArrayList<Integer>(100);
		tt.add(0,3);
		tt.add(1,3);
		//System.out.println(tt.get(0));
	}

}
