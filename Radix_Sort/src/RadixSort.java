import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Radix_Sort {
	private int multOf10 = 1;
	private Deque<Integer> finalArr = new LinkedList<Integer>();
	private Iterator<Integer> listIt;
	private Integer o1;
	
	//find max and then return the number of digits of max
	public int findMaxDigits(LinkedList<Integer> arr) {
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
	
	//divide each number by 10
	//if the number / 10 == 0, extract the number
	//each iteration is going to extract the smallest numbers
	public LinkedList<Integer> extractNums(LinkedList<Integer> arr) {
		LinkedList<Integer> preSortedArr1 = new LinkedList<Integer>();
		this.listIt = arr.iterator();
		
		while(this.listIt.hasNext()) {
			o1 = this.listIt.next();
			if(o1 == 0 && multOf10 == 1) {
				preSortedArr1.add(o1);
			} else if (o1 / multOf10 == 0) {
				this.finalArr.offer(o1);
			} else {
				preSortedArr1.add(o1);
			}
		}
		
		return preSortedArr1;
	}
	
	public LinkedList<Integer> sortNums(LinkedList<Integer> arr) {
		//extract the smallest numbers
		LinkedList<Integer> preSortedArr1 = extractNums(arr);
		//store the remaining numbers
		LinkedList<Integer> preSortedArr2 = new LinkedList<Integer>();
		
		//k is used to sort the numbers by their last digit, from 0 to 9
		for (int k = 0; k < 10; k++) {
			this.listIt = preSortedArr1.iterator();
			while(this.listIt.hasNext()) {
				o1 = this.listIt.next();
				if ((o1 / this.multOf10) % 10 == k) {
					preSortedArr2.add(o1);
				}
			}
		}
		this.multOf10 *= 10;
		return preSortedArr2;
	}
	
	public Deque<Integer> getFinalArr() {
		return this.finalArr;
	}
}
