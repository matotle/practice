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
		a1.add(1);
		a1.add(33);
		a1.add(77);
		a1.add(43);
		a1.add(23);

		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(44);
		a2.add(20);
		a2.add(12);
		a2.add(6);
		a2.add(1);
		a2.add(55);
		a2.add(1);
		a2.add(33);
		a2.add(77);
		a2.add(43);
		a2.add(23);

		ArrayList<Integer> a3 = new ArrayList<>();
		a3.add(44);
		a3.add(20);
		a3.add(12);
		a3.add(6);
		a3.add(1);
		a3.add(55);
		a3.add(1);
		a3.add(33);
		a3.add(77);
		a3.add(43);
		a3.add(23);
		
		
		System.out.println("Unsorted Array:");
		sa.displayArray(a1);

		System.out.println("\nBubble Sort:");
		sa.displayArray(sa.bubbleSort(a2));

		System.out.println("\nMerge Sort:");
		sa.displayArray(sa.mergeSort(a3));

		System.out.println("\nUnsorted Array:");
		sa.displayArray(a1);

	}

	public ArrayList<Integer> bubbleSort(ArrayList<Integer> set) {
		boolean mod = false;
		int i = 0;
		while (i < (set.size() - 1)) {

			if (i < set.size() - 1 && set.get(i) < set.get((i + 1))) {
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

	public ArrayList<Integer> mergeSort(ArrayList<Integer> set) {

		if (set.size() > 1) {
			int mid = set.size() / 2;

			ArrayList<Integer> left = new ArrayList<Integer>(mid);
			for (int i = 0; i < mid; i++) {
				left.add(i, set.get(i));
			}

			ArrayList<Integer> right = new ArrayList<Integer>(set.size() - mid);
			for (int i = 0; i < (set.size() - mid); i++) {
				right.add((i), set.get(i + mid));
			}
			left = mergeSort(left);
			right = mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			while (i < left.size() && j < right.size()) {
				if (left.get(i) > right.get(j)) {
					set.set(k, left.get(i));
					i++;
				} else {
					set.set(k, right.get(j));
					j++;
				}
				k++;
			}

			while (i < left.size()) {
				set.set(k, left.get(i));
				i++;
				k++;
			}
			while (j < right.size()) {
				set.set(k, right.get(j));
				j++;
				k++;
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
