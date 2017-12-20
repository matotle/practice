import java.util.ArrayList;

public class sortingAlgorithms {

	public static void main(String[] args) {

		sortingAlgorithms sa = new sortingAlgorithms();
		ArrayList<Integer> a1 = new ArrayList<>();

		a1.add(44);
		a1.add(20);
		a1.add(12);
		a1.add(6);
		a1.add(1);
		a1.add(55);
		a1.add(33);
		a1.add(77);
		a1.add(43);
		a1.add(23);
		a1.add(48);

		// Display unsorted Array
		System.out.println("Unsorted Array:");
		sa.displayArray(a1);
		// Display Bubble sorted Array
		System.out.println("\nBubble Sort:");
		sa.displayArray(sa.bubbleSort(a1));
		// Display merge sorted Array
		System.out.println("\nMerge Sort:");
		sa.displayArray(sa.mergeSort(a1));
		// Display unsorted Array to show original array was not modified
		System.out.println("\nUnsorted Array:");
		sa.displayArray(a1);
	}

	public ArrayList<Integer> bubbleSort(ArrayList<Integer> introSet) {
		// create a new array to not mess with the orignal, could turn into helper
		// method but meh.
		ArrayList<Integer> set = new ArrayList<Integer>();
		for (int i = 0; i < introSet.size(); i++) {
			set.add(i, introSet.get(i));
		}
		// if anything is modified becomes true.
		boolean mod = false;
		int i = 0;
		// set size-1 since it compares with the number after eg: n<(n+1) in sequence
		while (i < (set.size() - 1)) {
			// n<(n+1) in sequence
			if (set.get(i) < set.get((i + 1))) {
				int store = set.get(i);
				set.set(i, set.get((i + 1)));
				set.set((i + 1), store);
				mod = true;
			}
			i++;
		}
		// if anything was modified, the set could still need sorting, else return.
		if (mod) {
			return bubbleSort(set);
		} else {
			return set;
		}
	}

	public ArrayList<Integer> mergeSort(ArrayList<Integer> introSet) {
		// create a new array to not mess with the orignal, could turn into helper
		// method but meh.
		ArrayList<Integer> set = new ArrayList<Integer>();
		for (int i = 0; i < introSet.size(); i++) {
			set.add(i, introSet.get(i));
		}
		// split the array in two
		if (set.size() > 1) {
			int mid = set.size() / 2;
			// create left array
			ArrayList<Integer> left = new ArrayList<Integer>(mid);
			for (int i = 0; i < mid; i++) {
				left.add(i, set.get(i));
			}
			// create right array
			ArrayList<Integer> right = new ArrayList<Integer>(set.size() - mid);
			for (int i = 0; i < (set.size() - mid); i++) {
				right.add((i), set.get(i + mid));
			}
			// continue spliting and sorting the fragments
			left = mergeSort(left);
			right = mergeSort(right);

			int i = 0;// general count
			int r = 0;// right spec
			int l = 0;// left spec
			// compare the right and left halves of the array
			while (i < left.size() && r < right.size()) {
				// if left is greater than right set primary as left else opposite
				if (left.get(i) > right.get(r)) {
					set.set(l, left.get(i));
					i++;
				} else {
					set.set(l, right.get(r));
					r++;
				}
				l++;
			}
			// fill in the set with left values
			while (i < left.size()) {
				set.set(l, left.get(i));
				i++;
				l++;
			}
			// fill in the set with right values
			while (r < right.size()) {
				set.set(l, right.get(r));
				r++;
				l++;
			}
		}
		return set;
	}

	public void displayArray(ArrayList<Integer> set) {

		int i = 0;
		while (i < (set.size())) {
			System.out.print(set.get(i) + " ");
			i++;
		}
	}

}
