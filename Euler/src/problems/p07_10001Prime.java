package problems;

public class p07_10001Prime {

	public static void main(String[] args) {
		System.out.println(primeCount(10001));

	}

	static int primeCount(int count) {
		// if count is one, then we take 2 as base case
		int primeVal = 2;
		if (count != 1) {
			// start at 1 bc since we already have first prime of 2
			int i = 1;
			// start at 2 since we start above 2 for the max num;
			int k = 2;

			while (i < count) {
				//increment k to move on the next num each time
				k++;
				// check if 'k' is prime
				boolean prime = true;
				//start at 2 since k is always divisable by 1
				for (int j = 2; j < k; j++) {

					if (k % j == 0) {
						prime = false;
						break;
					}
				}
				if (prime) {
					i++;
					primeVal = k;
				}

			}
		}
		return primeVal;
	}
}
