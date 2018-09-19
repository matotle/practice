package problems;

public class p06SumSquareDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(SumSquareDifference());
	}

	public static int SumSquareDifference() {
		int max = 100;
		int sumOfSquares = 0;
		int squaresOfSums = 0;

		for (int i = 0; i <= max; i++) {

			sumOfSquares += (int) Math.pow(i, 2);
			squaresOfSums += i;

		}
		squaresOfSums = (int) Math.pow(squaresOfSums, 2);

		return squaresOfSums - sumOfSquares;
	}

}
