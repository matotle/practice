package practice;

public class SummationSequence {

	public static void main(String[] args) {

		SummationSequence s1 = new SummationSequence();

		s1.summation(1, 100);
	}

	public void summation(int start, int end) {

		for (int i = start; i <= end; i++) {

			int j = 1;
			int sum = i;

			while (j < i) {
				sum += j;
				j++;
			}
			System.out.println("The summation sequence of natural numbers to " + i + " equals " + sum);
		}
	}

}
