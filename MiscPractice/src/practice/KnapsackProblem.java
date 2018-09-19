package practice;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Michael Totleben This is my version of the Knapsack problem. The
 *         Objective is to get the max value of items into a sack with limted
 *         Capacity
 */

public class KnapsackProblem {

	public static void main(String[] args) {

		// define sack weight capacity
		KnapsackProblem ksp = new KnapsackProblem(12);
		ArrayList<Item> iList = new ArrayList<Item>();
		// with Current Items Max value =25 for a weight of 9.
		Collections.addAll(iList, ksp.new Item(20, 50), ksp.new Item(10, 4), ksp.new Item(8, 4), ksp.new Item(23, 9),
				ksp.new Item(8, 4), ksp.new Item(2, 10), ksp.new Item(5, 1), ksp.new Item(10, 3), ksp.new Item(7, 2),
				ksp.new Item(3, 2), ksp.new Item(5, 2), ksp.new Item(1, 2), ksp.new Item(7, 2));

		System.out.println("All Items:");
		ksp.displayArray(iList);
		System.out.println("Taken Items:");
		ksp.displayArray(ksp.SortandTake(iList));

		System.out.println("Taken Value: " + ksp.totalValue);
		System.out.print("Taken Weight: " + ksp.totalWeight + "lbs out of a capacity of ");
		System.out.println(ksp.getCapacity() + "lbs");
	}// end main method

	// Keep variables private for scope protection
	private int SackCapacity;
	private int totalValue = 0;
	private int totalWeight = 0;

	// takes in weight capacity
	public KnapsackProblem(int SackCapacity) {
		this.SackCapacity = SackCapacity;
	}

	/*
	 * sort the items with bubble sort by highest value ratio then grabs as many
	 * will fit into capacity
	 */
	public ArrayList<Item> SortandTake(ArrayList<Item> introSet) {
		ArrayList<Item> set = new ArrayList<Item>(introSet);
		boolean mod = false;

		// recursive sort
		for (int i = 0; i < (set.size() - 1); i++) {
			if (set.get(i).getValueRatio() < set.get((i + 1)).getValueRatio()) {
				Item store = set.get(i);
				set.set(i, set.get((i + 1)));
				set.set((i + 1), store);
				mod = true;
			}
		}
		// if anything was moved then do sort again
		if (mod) {
			return SortandTake(set);
		} else {
			// begin taking items after sorted
			int cap = SackCapacity;
			ArrayList<Item> set2 = new ArrayList<Item>();
			for (int i = 0; i < (set.size() - 1); i++) {
				if (set.get(i).getWeight() <= cap) {
					set2.add(set.get(i));
					// decriment the remaining weight and incriment the value
					cap = cap - set.get(i).getWeight();
					totalValue = totalValue + set.get(i).getValue();
					totalWeight = totalWeight + set.get(i).getWeight();
				}
			}
			return set2;
		}
	}

	// display values in the array
	public void displayArray(ArrayList<Item> set) {

		int i = 0;
		while (i < (set.size())) {
			set.get(i).printItemValues();
			i++;
		}

	}

	// public getters for access outside class
	public int getCapacity() {
		return SackCapacity;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public int getTotalValue() {
		return totalValue;

	}

	// create item subclass to be fed into array.
	private class Item {
		private int weight;
		private int value;

		// create constructor
		private Item(int value, int weight) {
			this.value = value;
			this.weight = weight;

		}

		private void printItemValues() {
			System.out
					.println("| Value: " + value + " Weight: " + weight + " Value Ratio: " + ((double) value / weight));

		}

		// getters, technically not necssary but good practice for scope control.
		private int getWeight() {
			return weight;

		}

		private int getValue() {
			return value;

		}

		private double getValueRatio() {
			return (double) value / weight;

		}
	}

}
