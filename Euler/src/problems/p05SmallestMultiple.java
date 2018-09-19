package problems;

public class p05SmallestMultiple {

	public static void main(String[] args) {
		System.out.println(smallestMultiple(20));
	}

	public static int smallestMultiple(int num) {
		int i = 40; // for 20 or 10 its not going to be smaller than 40, yes very arbritrary
		int sm = 0;
		boolean b = true;
		while (b) {

			for (int j = 1; j <= num; j++) {
				// if any are not a factor, incriment up and break the loop
				if (i % j != 0) {
					i++;
					break;
					
				} else if (j == num) { //if it gets here, its gone through all the required numbers, take number and leave.
					sm = i;
					b=false;

				}
			}
		}

		return sm;

	}

}
