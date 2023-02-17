package gyruda;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Gyruda {
	private LinkedList<Card> deck;
	private final int numClones = 18;
	private final int numNonlegendaryClones = 4;
	private final int numPseudoClones = 4;
	private final int numKolaghans = 2;
	public Gyruda() {
		deck = new LinkedList<Card>();
		makeDeck();
	}
	
	public int castGyruda(int startingHand, int turnCount, boolean onDraw) {
		if (!onDraw) {
			turnCount--;
		}
		for (int i = 0; i<startingHand+turnCount; i++) {
			draw();
		}
		LinkedList<Card> board = new LinkedList<Card>();
		int kolaghansLeft = 0;
		for (Card card:deck) {
			if (card.getIsKolaghan()) {
				kolaghansLeft++;
			}
		}
		boolean hasNonlegend = false;
		for (int i = 0; i<deck.size(); i+=4) {
			List<Card> top4;
			if (deck.size() <= i+4) {
				top4 = deck.subList(i, deck.size());
			} else {
				top4 = deck.subList(i, i+4);
			}
			Card chosenCard = null;
			int chosenCardRank = 0;
			for (Card card:top4) {
				if (card.getIsKolaghan()) {
					/*
					kolaghansLeft--;
					if (chosenCardRank < 1) {
						chosenCard = card;
						chosenCardRank = 1;
					}
					if (kolaghansLeft == 0) {
						chosenCard = card;
						break;
					}
					*/
					chosenCard = card;
					break;
				} else if (card.getIsNonlegendaryClone() && chosenCardRank < 4) {
					chosenCard = card;
					chosenCardRank = 4;
				} else if (card.getIsPseudoClone() && chosenCardRank < 3) {
					chosenCard = card;
					chosenCardRank = 3;
				} else if (card.getIsClone() && chosenCardRank < 2) {
					chosenCard = card;
					chosenCardRank = 2;
				}
			}
			if (chosenCard != null) {
				if (chosenCard.getIsClone() && !chosenCard.getIsNonlegendaryClone() && !chosenCard.getIsPseudoClone()) {
					if (hasNonlegend) {
						board.add(chosenCard);
					}
				} else {
					board.add(chosenCard);
				}
				if (chosenCard.getIsNonlegendaryClone()) {
					hasNonlegend = true;
				}
				if (!chosenCard.getIsClone()) {
					break;
				}
			} else {
				break;
			}
		}
		boolean hasKolaghan = false;
		int totalPower = 0;
		for (Card card:board) {
			if (card.getIsKolaghan()) {
				hasKolaghan = true;
			}
			totalPower+=card.getPower();
		}
		//System.out.println(board.toString());
		if (hasKolaghan) {
			return totalPower;
		} else {
			return 0;
		}
	}
	private void makeDeck() {
		for (int i = 0;i< numClones; i++) {
			deck.add(new Card(6, true, false, false, false)); //Make regular clones
		} 
		for (int i = 0;i< numNonlegendaryClones; i++) {
			deck.add(new Card(6, true, true, false, false)); //Make Spark Doubles
		} 
		for (int i = 0;i< numPseudoClones; i++) {
			deck.add(new Card(4, true, false, true, false)); //Make Wispweaver Angels
		} 
		for (int i = 0; i< numKolaghans; i++) {
			deck.add(new Card(6, false, false, false, true)); //Make Kolaghans (duh)
		}
		while (deck.size() < 60) {
			deck.add(new Card(Integer.MIN_VALUE, false, false, false, false)); //The other stuff
		}
		Collections.shuffle(deck);
	}
	
	private void draw() {
		deck.remove();
	}
	
	
	
}
