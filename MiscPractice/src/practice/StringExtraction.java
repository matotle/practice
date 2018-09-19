package practice;
import java.util.ArrayList;
/**
 * @author Michael Totleben 
 * just a string extraction
 */
public class StringExtraction {

	public static void main(String[] args) {
		String[] a = { "Harp", "Crave", "Death", "Feat", "Lean", "Carp", "Larp" };
		String[] b = { "arp", "ve", "eat", "Cur" };
		StringExtraction e = new StringExtraction();
		e.extractString(a, b);

	}

	public void extractString(String[] host, String[] targets) {
		ArrayList<String> subList = new ArrayList<>();

		for (int i = 0; i < targets.length; i++) {
			int count = 0;
			for (int j = 0; j < host.length; j++) {

				if (host[j].contains(targets[i])) {
					if (subList.contains(targets[i])) {
						count++;
					} else {
						subList.add(targets[i]);
						count++;
					}
				}
			}
			System.out.printf("\n %s instances of %s", count, targets[i]);
		}

	}

}
