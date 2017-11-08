import java.util.ArrayList;
import java.util.Iterator;

public class MeanMedianMode {

	public static void main(String[] args) {

		MeanMedianMode m = new MeanMedianMode();

		ArrayList<Integer> dm = new ArrayList<>();
		dm.add(44);
		dm.add(20);
		dm.add(11);
		dm.add(12);
		dm.add(6);
		dm.add(1);
		dm.add(55);
		dm.add(1);
		System.out.println("Mean: " + m.findMean(dm));
		System.out.println("Mode: " + m.findMode(dm));
		System.out.println("Median: " + m.findMedian(dm));
		m.displaySortedArray(dm);
	}

	public float findMean(ArrayList<Integer> set) {
		Iterator<Integer> itr = set.iterator();
		int sum = 0;

		while (itr.hasNext()) {
			sum = sum + ((int) itr.next());
		}
		float mean = ((float) sum) / set.size();

		return mean;

	}

	public int findMode(ArrayList<Integer> set) {
		Iterator<Integer> itr = set.iterator();
		int mode = 0;

		while (itr.hasNext()) {
			int i = ((int) itr.next());
			if (mode < i) {
				mode = i;
			}
		}
		return mode;

	}

	public double findMedian(ArrayList<Integer> set) {
		set = bubbleSort(set);

		int num = set.size();
		double median = 0;
		double mid = 0;
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

	public ArrayList<Integer> bubbleSort(ArrayList<Integer> set) {
		boolean mod = false;
		int i = 0;
		while (i < (set.size()-1) ) {

			if (i < set.size()-1 && set.get(i) < set.get((i + 1))) {
				int store = set.get(i);
				set.set(i, set.get((i + 1)));
				set.set((i + 1), store);
				mod = true;
			}
			i++;
		}

		if (mod) {
			return bubbleSort(set);
		} else {
			return set;
		}

	}

	// made this a seperate call since i didnt want array to print the middle of the
	// other method
	public void displaySortedArray(ArrayList<Integer> set) {
		
		System.out.println("Sorted Array:");
		set = bubbleSort(set);
		int i =0;
		while (i < (set.size()-1)) {
			System.out.print(set.get(i) + " ");
			i++;

		}

	}

}
