package problems;

public class P04Palindrome {

	public static void main(String[] args) {
		System.out.println(largestPalindrome());

	}

	public static int largestPalindrome() {
		int lpd = 0;
		int jstart = 999;

		for (int i = 999; i > 99; i--) {

			for (int j = jstart; j > 99; j--) {

				int product = i * j;

				String palan = Integer.toString(product);

				if ((palan.substring(0, 1).equals(palan.substring(5))
						&& palan.substring(1, 2).equals(palan.substring(4, 5))
						&& palan.substring(2, 3).equals(palan.substring(3, 4))) && product > lpd) {
					lpd = product;

				}

			}

		}

		return lpd;
	}

}
