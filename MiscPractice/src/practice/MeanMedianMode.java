package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Michael Totleben mean, median and mode using the merge sort from my
 *         sortingAlgorithms class.
 */

public class MeanMedianMode {

	public static void main(String[] args) {

		MeanMedianMode m = new MeanMedianMode();

		ArrayList<Integer> dm = new ArrayList<>();
		Collections.addAll(dm, 44, 20, 11, 12, 6, 3, 55, 1, 2);

		System.out.println("Mean: " + m.findMean(dm));
		System.out.println("Mode: " + m.findMode(dm));
		System.out.println("Median: " + m.findMedian(dm));
		m.displaySortedArray(dm);

		m.displayArray(dm);
	}

	public float findMean(ArrayList<Integer> set) {
		Iterator<Integer> itr = set.iterator();
		int sum = 0;
		// simply add all values and then divide them.
		while (itr.hasNext()) {
			sum = sum + ((int) itr.next());
		}
		float mean = ((float) sum) / set.size();

		return mean;
	}

	public int findMode(ArrayList<Integer> set) {
		Iterator<Integer> itr = set.iterator();
		int mode = 0;
		// check each value for the largest value.
		while (itr.hasNext()) {
			int i = ((int) itr.next());
			if (mode < i) {
				mode = i;
			}

		}
		return mode;

	}

	public double findMedian(ArrayList<Integer> introSet) {
		sortingAlgorithms sa = new sortingAlgorithms();
		// first sort to get be able to get middle value
		ArrayList<Integer> set = sa.mergeSort(introSet);
		int num = set.size();
		double median = 0;
		double mid = 0;
		// if even the average of the two values
		if (num % 2 == 0) {
			int temp = (num / 2) - 1;
			for (int i = 0; i < num; i++) {
				if (temp == i || (temp + 1) == i) {
					mid = mid + set.get(i);
				}
			}
			median = mid / 2;

		} else {
			int temp = (num / 2);
			for (int i = 0; i < num; i++) {
				if (temp == i) {
					median = set.get(i);
				}
			}
		}

		return median;

	}

	// made this a seperate call since i didnt want array to print the middle of the
	// other method
	public void displaySortedArray(ArrayList<Integer> introSet) {
		ArrayList<Integer> set = new ArrayList<Integer>(introSet);
		System.out.println("Sorted Array:");
		sortingAlgorithms sa = new sortingAlgorithms();
		set = sa.mergeSort(set);
		for (int i = 0; i < (set.size() - 1); i++) {
			System.out.print(set.get(i) + " ");
		}
		System.out.print("\n");
	}

	public void displayArray(ArrayList<Integer> set) {

		System.out.println("Unsorted Array:");
		for (int i = 0; i < (set.size() - 1); i++) {
			System.out.print(set.get(i) + " ");

		}

	}

}
