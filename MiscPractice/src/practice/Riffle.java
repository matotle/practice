package practice;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Michael Totleben This is my version of a riffle of deck of 52 cards. 
 */
public class Riffle {

	public static void main(String[] args) {
		ArrayList<Integer> deck = new ArrayList<>();
		// create the deck
		for (int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		Riffle r = new Riffle();
		// print method
		ArrayList<Integer> deck2 = r.riffle(deck);
		for (int i = 0; i < 52; i++) {
			System.out.println(deck2.get(i));
		}
	}

	public ArrayList<Integer> riffle(ArrayList<Integer> deck) {
		ArrayList<Integer> shuffledDeck = new ArrayList<>();
		ArrayList<Integer> halfA = new ArrayList<>();
		ArrayList<Integer> halfB = new ArrayList<>();

		// split the deck into A & B
		for (int i = 0; i < 52; i++) {
			if (i < 26) {
				halfA.add((Integer) deck.get(i));
			} else {
				halfB.add((Integer) deck.get(i));
			}
		}
		// add decks to shuffled deck
		int iA = 0;
		int iB = 0;
		while (iA < 26 || iB < 26) {

			// generate random seeds for card drawing
			Random rA = new Random();
			Random rB = new Random();
			// pick how many cards will be drawn: random is exclusive at top bound, thus 27
			int drawA = rA.nextInt((27 - (iA)));
			int drawB = rB.nextInt((27 - (iB)));

			// make sure not more than 26 are added from deck A & B respectively
			for (int j = 0; j < drawA; j++) {
				if (iA < 26) {
					shuffledDeck.add(halfA.get(iA));
					iA++;
				}
			}
			for (int j = 0; j < drawB; j++) {
				if (iB < 26) {
					shuffledDeck.add(halfB.get(iB));
					iB++;
				}
			}
		}
		return shuffledDeck;
	}
}