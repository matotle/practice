package practice;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Michael Totleben Im not sure why I initially made this, just sum of consecutive numbers.
 */
public class ConsecutiveNumbers {

	public static void main(String[] args) {
		//Assume pre-sorted
		ArrayList<Integer> a = new ArrayList<Integer>();
		Collections.addAll(a, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 0);

		ConsecutiveNumbers c = new ConsecutiveNumbers();
		c.consecutiveNumCount(a);
	}

	void consecutiveNumCount(ArrayList<Integer> a) {
		int count = 1;
		int sum = 0;
		int current = 0;
		
		for (int i = 0; i < a.size(); i++) {
			//start with with first value and store it
			if (i == 0) {
				current = a.get(i);
				sum = current;
			} else {
				//check current vs next, if equal then add to sum.
				if (current == a.get(i)) {
					sum = sum + a.get(i);
					count = count + 1;
					//if last number print
					if (i == a.size() - 1) {
						System.out.printf("\n The sum of %s consecutive %s's are %s", count, current, sum);
					}
				} else {
					//
					System.out.printf("\n The sum of %s consecutive %s's are %s", count, current, sum);
					count = 1;
					current = a.get(i);
					sum = current;
					//if last number print
					if (i == a.size() - 1) {
						System.out.printf("\n The sum of %s consecutive %s are %s", count, current, sum);

					}
				}
			}
		}
	}
}
