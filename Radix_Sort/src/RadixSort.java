import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RadixSort {
	static int multOf10 = 1;
	static ArrayList<Integer> finalArr = new ArrayList<Integer>();
	
	public static int findMaxDigits(ArrayList<Integer> arr) {
		int max = arr.get(0);
		int counter = 0;
		
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
			}
		}
		while(max != 0) {
			max /= 10;
			counter++;
		}
		return counter;
	}
	
	public static ArrayList<Integer> extractNums(ArrayList<Integer> arr) {
		ArrayList<Integer> preSortedArr1 = new ArrayList<Integer>();
		
		for (int j = 0; j < arr.size(); j++) {
			if (arr.get(j) / multOf10 == 0) {
				//System.out.println("rem " + arr.get(j));
				finalArr.add(arr.get(j));
			} else {
				preSortedArr1.add(arr.get(j));
			}
		}
		//System.out.println("pre" + preSortedArr1);
		return preSortedArr1;
	}
	
	public static ArrayList<Integer> sortNums(ArrayList<Integer> arr) {
		ArrayList<Integer> preSortedArr1 = new ArrayList<Integer>();
		ArrayList<Integer> preSortedArr2 = new ArrayList<Integer>();
		
		preSortedArr1 = extractNums(arr);
		
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < preSortedArr1.size(); j++) {
				if ((preSortedArr1.get(j) / multOf10) % 10 == k) {
					preSortedArr2.add(preSortedArr1.get(j));
					//System.out.println(k + " " + preSortedArr2.get(j));
				}
			}
		}
		multOf10 *= 10;
		return preSortedArr2;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList
				(1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713, 10, 0));
		int maxDigits = findMaxDigits(arr);
		
		for (int i = 0; i < maxDigits; i++) {
			arr = sortNums(arr);
			System.out.println(i + 1 + " digit from last\npresorted array: " + arr);
			System.out.println("final array: " + finalArr);
			System.out.println();
		}
		
		finalArr.addAll(arr);
		System.out.println("result: " + finalArr);
	}

}
