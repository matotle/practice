package problems;

public class P03PrimeFactors {

	public static void main(String[] args) { // "600851475143"
		double b = Double.parseDouble("600851475143");
		//double b = 28;
		System.out.println(largestPrimeFactor(b));
	}

	public static double largestPrimeFactor(double max) {
		double lpf = 1;
		double halfMax;
		// since the prime number will never be greater than the max /2 we can elimate
		// 50% of the values.
		if (max % 2 == 0) {
			halfMax = max / 2;
		} else {
			halfMax = (max + 1) / 2;
		}

		// decriment then first prime number is the largest so can immediately break;
		for (double i = halfMax; i > 2; i--) {

			// check if 'i' is a factor of max
			if (max % i == 0) {

				// check if 'i' is prime
				boolean prime = true;
				for (double j = 2; j < i; j++) {

					if (i % j == 0) {
						prime = false;
						break;
					}
				}
				if (prime) {
					lpf = i;
					break;
				}

			}

		}

		return lpf;
	}
}
