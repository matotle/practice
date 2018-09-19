package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//in progress
public class p54PokerHands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		p54PokerHands p = new p54PokerHands();
		p.readFile();
	}
private int az=0;
	void readFile() {
		BufferedReader reader = null;
		try {
			File file = new File("misc\\p054_poker.txt");
			reader = new BufferedReader(new FileReader(file));

			String line;
		while ((line = reader.readLine()) != null) {
				// get rid of any whitespace
			//	line = reader.readLine();
				String l = line.replace(" ", "").trim();
				Hand hand1 = createHand(l.substring(0, 10));
				Hand hand2 = createHand(l.substring(10));
				
				System.out.println("Hand 1:");
				ArrayList<CardSet> h1 = hand1.getCardSets();
				System.out.println("Hand Value: "+hand1.getHandValue()+" HighCardValue "+ hand1.getHighCardValue());
				for (int i = 0; i < h1.size(); i++) {
					System.out.println(h1.get(i).getType()+ " Value:" + h1.get(i).getValueOfSet()+ " High Card:" + h1.get(i).getHighCard());
				}
				System.out.println("Hand 2:");
				ArrayList<CardSet> h2 = hand2.getCardSets();
				System.out.println("Hand Value: "+hand2.getHandValue()+" HighCardValue "+ hand2.getHighCardValue());
				for (int i = 0; i < h2.size(); i++) {
					System.out.println(h2.get(i).getType()+ " Value:" + h2.get(i).getValueOfSet()+ " High Card:" + h2.get(i).getHighCard());
				}
				System.out.println("Better Hand: "+		handCompare(hand1,hand2));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Hand createHand(String s) {

		Hand hand = new Hand();

		hand.addCard(new Card(s.substring(0, 2), s.substring(1, 2), cardValtoNum(s.substring(0, 1))));
		hand.addCard(new Card(s.substring(2, 4), s.substring(3, 4), cardValtoNum(s.substring(2, 3))));
		hand.addCard(new Card(s.substring(4, 6), s.substring(5, 6), cardValtoNum(s.substring(4, 5))));
		hand.addCard(new Card(s.substring(6, 8), s.substring(7, 8), cardValtoNum(s.substring(6, 7))));
		hand.addCard(new Card(s.substring(8), s.substring(9), cardValtoNum(s.substring(8, 9))));
		
		CalcHandValue(hand);
		
		return hand;
	}

	boolean IsSingleSuite(ArrayList<Card> seq) {
		boolean b = true;
		for (int i = 1; i < 5; i++) {
			if (seq.get(0).getSuite().equals(seq.get(i).getSuite())) {
				b = false;
				break;
			}
		}
		return b;
	}

	// presumes previously sorted
	boolean IsConsecutive(ArrayList<Card> seq) {
		boolean b = true;
		// minus one since the last is already compared
		for (int i = 0; i < seq.size() - 1; i++) {
			// check if current num +1 is equal to next in sequence ascending
			if ((seq.get(i).getValue() + 1) != seq.get(i + 1).getValue()) {
				b = false;
				break;
			}
		}
		return b;
	}

	//Hand Values:
	// Royal Flush 9
	// Straight Flush 8
	// Four of Kind 7
	// Full House 6
	// Flush 5
	// Straight 4
	// Three of Kind 3
	// Two Pairs 2
	// One Pair 1
	// High Card 0

	public void CalcHandValue(Hand hand) {
		ArrayList<Card> seq = hand.getCards();
		// sorts ascending
		Collections.sort(seq);

		if (IsSingleSuite(seq) && IsConsecutive(seq) && seq.get(4).getValue() == 14) {
			hand.addCardSet(new CardSet("Royal Flush", seq, hand.getHighCardValue(), 9));

		} else if (IsSingleSuite(seq) && IsConsecutive(seq)) {
			hand.addCardSet(new CardSet("Strait Flush", seq, hand.getHighCardValue(), 8));

		} else if (IsConsecutive(seq)) {
			hand.addCardSet(new CardSet("Strait", seq, hand.getHighCardValue(), 5));

		} else if (IsSingleSuite(seq)) {
			hand.addCardSet(new CardSet("Flush", seq, hand.getHighCardValue(), 6));
		} else {
			int i = 0;
			while (i < 5) {
				if (i + 3 < 5 && (seq.get(i).getValue()) == seq.get(i + 3).getValue()) {// Check for four of a kind
					ArrayList<Card> subSeq = new ArrayList<Card>();
					Collections.addAll(subSeq, seq.get(i), seq.get(i + 1), seq.get(i + 2), seq.get(i + 3));
					hand.addCardSet(new CardSet("Four of a Kind", subSeq, subSeq.get(0).getValue(), 7));
					i += 4;
				} else if (i + 2 < 5 && seq.get(i).getValue() == seq.get(i + 2).getValue()) {// Check for 3 of a kind
					ArrayList<Card> subSeq = new ArrayList<Card>();
					Collections.addAll(subSeq, seq.get(i), seq.get(i + 1), seq.get(i + 2));
					hand.addCardSet(new CardSet("Three of a Kind", subSeq, subSeq.get(0).getValue(), 4));
					i += 3;
				} else if (i + 1 < 5 && seq.get(i).getValue() == seq.get(i + 1).getValue()) {// Check pair
					ArrayList<Card> subSeq = new ArrayList<Card>();
					Collections.addAll(subSeq, seq.get(i), seq.get(i + 1));
					hand.addCardSet(new CardSet("Pair", subSeq, subSeq.get(0).getValue(), 1));
					i += 2;
				} else {// highcard
					ArrayList<Card> subSeq = new ArrayList<Card>();
					Collections.addAll(subSeq, seq.get(i));
					hand.addCardSet(new CardSet("Lone Card", subSeq, subSeq.get(0).getValue(), 0));
					i += 1;
				}
			}
		}

		ArrayList<CardSet> cards = hand.getCardSets();

		int pairCount = 0;
		boolean threeKind = false;
		int CardSetValue = 0;
		for (int i = 0; i < cards.size(); i++) {

			if (cards.get(i).getValueOfSet() == 1) {
				pairCount += 1;
			} else if (cards.get(i).getValueOfSet() == 3) {
				threeKind = true;
			} else {
				CardSetValue = Math.max(CardSetValue, cards.get(i).getValueOfSet());
			}
		}

		if (pairCount == 1 && threeKind) {
			// Full House
			hand.setHandValue(6);
		} else if (pairCount == 2) {
			// Two Pair
			hand.setHandValue(3);
		} else {
			//the non combinations have same value as largest cardset
			hand.setHandValue(CardSetValue);

		}
	}

	int cardValtoNum(String s) {
		int num = 0;

		if ("A".equals(s)) {
			num = 14;
		} else if ("K".equals(s)) {
			num = 13;
		} else if ("Q".equals(s)) {
			num = 12;
		} else if ("J".equals(s)) {
			num = 11;
		} else if ("T".equals(s)) {
			num = 10;
		} else {
			num = Integer.parseInt(s);
		}
		return num;
	}

	
	private int handCompare(Hand h1, Hand h2) {
		int winningHand=0;
		
		if(h1.getHandValue() > h2.getHandValue()) {
			winningHand=1;
		}else if(h2.getHandValue() > h1.getHandValue()) {
			winningHand=2;
		}
		
		
		
		
		return winningHand;
	}
	
	
	
	
	private class Card implements Comparable<Card> {
		private String base;
		private String suite;
		private int value;
		private int b=az;
		private Card(String base, String suite, int value) {
			this.base = base;
			this.suite = suite;
			this.value = value;
			
		}

		private String getBase() {
			return base;
		}

		private String getSuite() {
			return suite;
		}

		private int getValue() {
			return value;
		}

		@Override
		public int compareTo(Card other) {
			return Integer.compare(this.value, other.value);
		}

	}

	private class CardSet {
		String type;

		ArrayList<Card> set;
		int highCard;
		int valueOfSet;

		private CardSet(String type, ArrayList<Card> set, int highCard, int valueOfSet) {
			this.type = type;
			this.set = set;
			this.highCard = highCard;
			this.valueOfSet = valueOfSet;
		}

		private String getType() {
			return type;
		}

		private ArrayList<Card> getSet() {
			return set;
		}

		private int getHighCard() {
			return highCard;
		}

		private int getValueOfSet() {
			return valueOfSet;
		}
	}

	private class Hand {

		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<CardSet> cardSets = new ArrayList<CardSet>();
		int highCard;
		int handValue;

		private Hand() {
		}

		private ArrayList<Card> getCards() {
			return cards;
		}

		private ArrayList<CardSet> getCardSets() {
			return cardSets;
		}

		private void addCard(Card card) {
			cards.add(card);
		}

		int getHighCardValue() {
			Collections.sort(cards);
			return cards.get(4).getValue();
		}

		private void addCardSet(CardSet cardSet) {
			cardSets.add(cardSet);
		}

		private int getHandValue() {
			return handValue;
		}

		private void setHandValue(int handValue) {
			this.handValue = handValue;
		}

	}
}
