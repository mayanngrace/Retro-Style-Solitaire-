package application.model;

import java.util.Collections;
import java.util.Vector;

import application.Main;
import javafx.scene.control.Label;

public class GameMechanics {

	// Fields
	private Vector<Card> highlightedCards = new Vector<Card>();
	private Main main;
	private int score;
	private Card selectedCard = null;
	private Vector<Card> selectedStackOfCards = new Vector<Card>();
	
		// Piles
		private NormalPile stockPile;
		private WastePile wastePile;
		private NormalPile foundationClubs;
		private NormalPile foundationSpades;
		private NormalPile foundationHearts;
		private NormalPile foundationDiamonds;
		// end Piles
		
		// TableauColumns
		private TableauColumn tc1;
		private TableauColumn tc2;
		private TableauColumn tc3;
		private TableauColumn tc4;
		private TableauColumn tc5;
		private TableauColumn tc6;
		private TableauColumn tc7;
		// end TableauColumns
		
		// Score
		private Label scoreLabel;
		
	// end Fields
	
	// Methods
	
	public void arrangeStockPile() {
		// correct z-order of remaining cards in stockPile
		for (Card c: stockPile.getStack()) {
			c.toFront();
			c.setSelectable(true);
		}
	}
	
	public void deSelect() {
		if (selectedCard != null) {
			selectedCard.defaultStyle();	
		}
		selectedCard = null;
		for (Card c: highlightedCards) {
			c.defaultStyle();
		}
		for (Card c: selectedStackOfCards) {
			c.defaultStyle();
		}
		highlightedCards.clear();
		selectedStackOfCards.clear();
		// remove highlight of destinations
		foundationClubs.defaultStyle();
		foundationSpades.defaultStyle();
		foundationHearts.defaultStyle();
		foundationDiamonds.defaultStyle();
		tc1.defaultStyle();
		tc2.defaultStyle();
		tc3.defaultStyle();
		tc4.defaultStyle();
		tc5.defaultStyle();
		tc6.defaultStyle();
		tc7.defaultStyle();
	}
	
	public void draw() {
		if (main.getDifficulty().equals("Normal")) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("wastePile", wastePile);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
			wastePile.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		} else {
			if (stockPile.getStack().size() >= 3) {
				for (int i=0; i<3; i++) {
					stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("wastePile", wastePile);
					stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
					wastePile.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
					stockPile.getStack().remove(stockPile.getStack().size()-1);
				}
			} else { // if there are 2 or less cards in stockPile
				while (!stockPile.getStack().isEmpty()) {
					Card c = stockPile.getStack().elementAt(stockPile.getStack().size()-1);
					c.setLocation("wastePile", wastePile);
					c.setFaceUp();
					wastePile.insert(c);
					stockPile.getStack().remove(stockPile.getStack().size()-1);
				}
			}
			wastePile.indent3();
		}
	}
	
	public void flipUpTableau(String s) {
		if (s.equals("tc1")) {
			if (!tc1.getStack().isEmpty() ) {
				tc1.getStack().elementAt(tc1.getStack().size()-1).setIsTop(true);
				if (tc1.getStack().elementAt(tc1.getStack().size()-1).getFace().equals("down")) {
					tc1.getStack().elementAt(tc1.getStack().size()-1).setFaceUp();
					tc1.getStack().elementAt(tc1.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc2")) {
			if (!tc2.getStack().isEmpty() ) {
				tc2.getStack().elementAt(tc2.getStack().size()-1).setIsTop(true);
				if (tc2.getStack().elementAt(tc2.getStack().size()-1).getFace().equals("down")) {
					tc2.getStack().elementAt(tc2.getStack().size()-1).setFaceUp();
					tc2.getStack().elementAt(tc2.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc3")) {
			if (!tc3.getStack().isEmpty() ) {
				tc3.getStack().elementAt(tc3.getStack().size()-1).setIsTop(true);
				if (tc3.getStack().elementAt(tc3.getStack().size()-1).getFace().equals("down")) {
					tc3.getStack().elementAt(tc3.getStack().size()-1).setFaceUp();
					tc3.getStack().elementAt(tc3.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc4")) {
			if (!tc4.getStack().isEmpty() ) {
				tc4.getStack().elementAt(tc4.getStack().size()-1).setIsTop(true);
				if (tc4.getStack().elementAt(tc4.getStack().size()-1).getFace().equals("down")) {
					tc4.getStack().elementAt(tc4.getStack().size()-1).setFaceUp();
					tc4.getStack().elementAt(tc4.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc5")) {
			if (!tc5.getStack().isEmpty() ) {
				tc5.getStack().elementAt(tc5.getStack().size()-1).setIsTop(true);
				if (tc5.getStack().elementAt(tc5.getStack().size()-1).getFace().equals("down")) {
					tc5.getStack().elementAt(tc5.getStack().size()-1).setFaceUp();
					tc5.getStack().elementAt(tc5.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc6")) {
			if (!tc6.getStack().isEmpty() ) {
				if (tc6.getStack().elementAt(tc6.getStack().size()-1).getFace().equals("down")) {
					tc6.getStack().elementAt(tc6.getStack().size()-1).setFaceUp();
					tc6.getStack().elementAt(tc6.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else if (s.equals("tc7")) {
			if (!tc7.getStack().isEmpty() ) {
				tc7.getStack().elementAt(tc7.getStack().size()-1).setIsTop(true);
				if (tc7.getStack().elementAt(tc7.getStack().size()-1).getFace().equals("down")) {
					tc7.getStack().elementAt(tc7.getStack().size()-1).setFaceUp();
					tc7.getStack().elementAt(tc7.getStack().size()-1).setSelectable(true);
					setScore(5);
				}
			}
		} else {
			// nothing
		}
	}
	
	public void generateCardObjects() {
		for (int i=1; i<=4; i++) { // for each suit
			String suit;
			if (i == 1) {
				 suit = "Clubs";
			} else if (i == 2) {
				suit = "Spades";
			} else if (i == 3) {
				suit = "Hearts";
			} else {
				suit = "Diamonds";
			}
			Card tmp;
			// Aces
			tmp = new Card("A", suit, "stockPile", stockPile);
			stockPile.insert(tmp);
			// 2 to 10
			for (int j=2; j<=10; j++) {
				tmp = new Card(Integer.toString(j), suit, "stockPile", stockPile);
				stockPile.insert(tmp);
			}
			// J, Q, K
			tmp = new Card("J", suit, "stockPile", stockPile);
			stockPile.insert(tmp);
			tmp = new Card("Q", suit, "stockPile", stockPile);
			stockPile.insert(tmp);
			tmp = new Card("K", suit, "stockPile", stockPile);
			stockPile.insert(tmp);
		} // end for each suit
		
	} // end generateCardObjects
	
	public void generateInitialCards() {
		// tc1, 1 up
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc1", tc1);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc1.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc2, 1 down, 1 up
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc2", tc2);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		tc2.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc2", tc2);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc2.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc3, 2 down, 1 up
		for (int i=0; i<2; i++) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc3", tc3);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
			tc3.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		}
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc3", tc3);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc3.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc4, 3 down, 1 up
		for (int i=0; i<3; i++) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc4", tc4);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
			tc4.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		}
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc4", tc4);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc4.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc5, 4 down, 1 up
		for (int i=0; i<4; i++) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc5", tc5);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
			tc5.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		}
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc5", tc5);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc5.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc6, 5 down, 1 up
		for (int i=0; i<5; i++) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc6", tc6);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
			tc6.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		}
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc6", tc6);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc6.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		// tc7, 6 down, 1 up
		for (int i=0; i<6; i++) {
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc7", tc7);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setSelectable(false);
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceDown();
			stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
			tc7.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
			stockPile.getStack().remove(stockPile.getStack().size()-1);
		}
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setLocation("tc7", tc7);
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setFaceUp();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).toFront();
		stockPile.getStack().elementAt(stockPile.getStack().size()-1).setIsTop(true);
		tc7.insert(stockPile.getStack().elementAt(stockPile.getStack().size()-1));
		stockPile.getStack().remove(stockPile.getStack().size()-1);
		
		arrangeStockPile();
	} // end generateInitialCards()
	
	public void initializeMoveEvents() {
		// foundationClubs
		foundationClubs.setOnMouseClicked(event -> {
			if (foundationClubs.isHighlighted() && selectedCard != null) {
				// move to foundation clubs
				String source = selectedCard.getLocation();
				selectedCard.setLocation("foundationClubs", foundationClubs);
				selectedCard.toFront();
				selectedCard.defaultStyle();
				foundationClubs.getStack().add(selectedCard);
				if (source.equals("wastePile")) {
					wastePile.getStack().remove(wastePile.getStack().size()-1);
					wastePile.indent3();
					setScore(10);
				} else { // from tableau
					removeFromTableau(source);
					flipUpTableau(source);
					setScore(10);
				}
				deSelect();
			}
		});
		// foundationSpades
		foundationSpades.setOnMouseClicked(event -> {
			if (foundationSpades.isHighlighted() && selectedCard != null) {
				// move to foundation spades
				String source = selectedCard.getLocation();
				selectedCard.setLocation("foundationSpades", foundationSpades);
				selectedCard.toFront();
				selectedCard.defaultStyle();
				foundationSpades.getStack().add(selectedCard);
				if (source.equals("wastePile")) {
					wastePile.getStack().remove(wastePile.getStack().size()-1);
					wastePile.indent3();
					setScore(10);
				} else { // from tableau
					removeFromTableau(source);
					flipUpTableau(source);
					setScore(10);
				}
				deSelect();
			}
		});
		// foundationHearts
		foundationHearts.setOnMouseClicked(event -> {
			if (foundationHearts.isHighlighted() && selectedCard != null) {
				// move to foundation hearts
				String source = selectedCard.getLocation();
				selectedCard.setLocation("foundationHearts", foundationHearts);
				selectedCard.toFront();
				selectedCard.defaultStyle();
				foundationHearts.getStack().add(selectedCard);
				if (source.equals("wastePile")) {
					wastePile.getStack().remove(wastePile.getStack().size()-1);
					wastePile.indent3();
					setScore(10);
				} else { // from tableau
					removeFromTableau(source);
					flipUpTableau(source);
					setScore(10);
				}
				deSelect();
			}
		});
		// foundationDiamonds
		foundationDiamonds.setOnMouseClicked(event -> {
			if (foundationDiamonds.isHighlighted() && selectedCard != null) {
				// move to foundation diamonds
				String source = selectedCard.getLocation();
				selectedCard.setLocation("foundationDiamonds", foundationDiamonds);
				selectedCard.toFront();
				selectedCard.defaultStyle();
				foundationDiamonds.getStack().add(selectedCard);
				if (source.equals("wastePile")) {
					wastePile.getStack().remove(wastePile.getStack().size()-1);
					wastePile.indent3();
					setScore(10);
				} else { // from tableau
					removeFromTableau(source);
					flipUpTableau(source);
					setScore(10);
				}
				deSelect();
			}
		});
		
		// tableauColumns
		tc1.setOnMouseClicked(event -> {
			if (tc1.isHighlighted() && selectedCard != null) {
				// move to tc1
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc1", tc1);
						tc1.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc1", tc1);
					tc1.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc2.setOnMouseClicked(event -> {
			if (tc2.isHighlighted() && selectedCard != null) {
				// move to tc2
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc2", tc2);
						tc2.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc2", tc2);
					tc2.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc3.setOnMouseClicked(event -> {
			if (tc3.isHighlighted() && selectedCard != null) {
				// move to tc3
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc3", tc3);
						tc3.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc3", tc3);
					tc3.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc4.setOnMouseClicked(event -> {
			if (tc4.isHighlighted() && selectedCard != null) {
				// move to tc4
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc4", tc4);
						tc4.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc4", tc4);
					tc4.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc5.setOnMouseClicked(event -> {
			if (tc5.isHighlighted() && selectedCard != null) {
				// move to tc5
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc5", tc5);
						tc5.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc5", tc5);
					tc5.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc6.setOnMouseClicked(event -> {
			if (tc6.isHighlighted() && selectedCard != null) {
				// move to tc6
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc6", tc6);
						tc6.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc6", tc6);
					tc6.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		tc7.setOnMouseClicked(event -> {
			if (tc7.isHighlighted() && selectedCard != null) {
				// move to tc7
				String source = selectedCard.getLocation();
				if (!selectedStackOfCards.isEmpty()) {
					// move stack
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc7", tc7);
						tc7.insert(selectedStackOfCards.elementAt(i));
					}
					if (source.equals("tc1")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc1.removeLastElem();
						}
					} else if (source.equals("tc2")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc2.removeLastElem();
						}
					} else if (source.equals("tc3")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc3.removeLastElem();
						}
					} else if (source.equals("tc4")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc4.removeLastElem();
						}
					} else if (source.equals("tc5")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc5.removeLastElem();
						}
					} else if (source.equals("tc6")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc6.removeLastElem();
						}
					} else if (source.equals("tc7")) {
						for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
							tc7.removeLastElem();
						}
					} else {
						// nothing
					}
					
				} else { // single
					selectedCard.setLocation("tc7", tc7);
					tc7.insert(selectedCard);
					if (source.equals("wastePile")) {
						wastePile.getStack().remove(wastePile.getStack().size()-1);
						wastePile.indent3();
					} else if (source.equals("tc1")) {
						tc1.removeLastElem();
					} else if (source.equals("tc2")) {
						tc2.removeLastElem();
					} else if (source.equals("tc3")) {
						tc3.removeLastElem();
					} else if (source.equals("tc4")) {
						tc4.removeLastElem();
					} else if (source.equals("tc5")) {
						tc5.removeLastElem();
					} else if (source.equals("tc6")) {
						tc6.removeLastElem();
					} else if (source.equals("tc7")) {
						tc7.removeLastElem();
					} else {
						// nothing
					}
				}
			}
			deSelect();
		});
		
	}
	
	public void moveToFoundation(Card c) {
		if (!c.getSuit().equals(selectedCard.getSuit())) {
			deSelect();
			return;
		}
		if (c.getRealValue() != selectedCard.getRealValue()-1) {
			deSelect();
			return;
		}
		if (c.getLocation().equals("foundationClubs")) {
			String source = selectedCard.getLocation();
			selectedCard.setLocation("foundationClubs", foundationClubs);
			selectedCard.toFront();
			foundationClubs.getStack().add(c);
			if (source.equals("wastePile")) {
				wastePile.getStack().remove(wastePile.getStack().size()-1);
				wastePile.indent3();
				setScore(10);
			} else {
				setScore(10);
				removeFromTableau(source);
				flipUpTableau(source);
			}
			deSelect();
		}
		if (c.getLocation().equals("foundationSpades")) {
			String source = selectedCard.getLocation();
			selectedCard.setLocation("foundationSpades", foundationSpades);
			selectedCard.toFront();
			foundationSpades.getStack().add(c);
			if (source.equals("wastePile")) {
				wastePile.getStack().remove(wastePile.getStack().size()-1);
				wastePile.indent3();
				setScore(10);
			} else {
				setScore(10);
				removeFromTableau(source);
				flipUpTableau(source);
			}
			deSelect();
		}
		if (c.getLocation().equals("foundationHearts")) {
			String source = selectedCard.getLocation();
			selectedCard.setLocation("foundationHearts", foundationHearts);
			selectedCard.toFront();
			foundationHearts.getStack().add(c);
			if (source.equals("wastePile")) {
				wastePile.getStack().remove(wastePile.getStack().size()-1);
				wastePile.indent3();
				setScore(10);
			} else {
				setScore(10);
				removeFromTableau(source);
				flipUpTableau(source);
			}
			deSelect();
		}
		if (c.getLocation().equals("foundationDiamonds")) {
			String source = selectedCard.getLocation();
			selectedCard.setLocation("foundationDiamonds", foundationDiamonds);
			selectedCard.toFront();
			foundationDiamonds.getStack().add(c);
			if (source.equals("wastePile")) {
				wastePile.getStack().remove(wastePile.getStack().size()-1);
				wastePile.indent3();
				setScore(10);
			} else {
				setScore(10);
				removeFromTableau(source);
				flipUpTableau(source);
			}
			deSelect();
		}
	}
	
	public void moveToTableau(Card c) {
		if (!c.getValidDest()) { // if invalid destination
			deSelect();
			return;
		}
		if (selectedCard.getLocation().equals("wastePile")) {
			// wastePile to tableau	
			selectedCard.setVisible(false);
			selectedCard.toFront();
			if (c.getLocation().equals("tc1")) {
				selectedCard.setLocation("tc1", tc1);
				tc1.insert(selectedCard);
			} else if (c.getLocation().equals("tc2")) {
				selectedCard.setLocation("tc2", tc2);
				tc2.insert(selectedCard);
			} else if (c.getLocation().equals("tc3")) {
				selectedCard.setLocation("tc3", tc3);
				tc3.insert(selectedCard);
			} else if (c.getLocation().equals("tc4")) {
				selectedCard.setLocation("tc4", tc4);
				tc4.insert(selectedCard);
			} else if (c.getLocation().equals("tc5")) {
				selectedCard.setLocation("tc5", tc5);
				tc5.insert(selectedCard);
			} else if (c.getLocation().equals("tc6")) {
				selectedCard.setLocation("tc6", tc6);
				tc6.insert(selectedCard);
			} else if (c.getLocation().equals("tc7")) {
				selectedCard.setLocation("tc7", tc7);
				tc7.insert(selectedCard);
			} else {
				// nothing
			}
			wastePile.getStack().remove(wastePile.getStack().size()-1);
			wastePile.indent3();
			selectedCard.setVisible(true);
			setScore(5);
		} else if (selectedCard.getLocation().equals("foundationClubs") || selectedCard.getLocation().equals("foundationSpades") || selectedCard.getLocation().equals("foundationHearts") || selectedCard.getLocation().equals("foundationDiamonds")) {
			// foundation to tableau
			if (selectedCard.getLocation().equals("foundationClubs")) {
				foundationClubs.removeLastElem();
				setScore(-15);
			} else if (selectedCard.getLocation().equals("foundationSpades")) {
				foundationSpades.removeLastElem();
				setScore(-15);
			} else if (selectedCard.getLocation().equals("foundationHearts")) {
				foundationHearts.removeLastElem();
				setScore(-15);
			} else if (selectedCard.getLocation().equals("foundationDiamonds")) {
				foundationDiamonds.removeLastElem();
				setScore(-15);
			} else {
				// nothing
			}
			if (c.getLocation().equals("tc1")) {
				selectedCard.setLocation("tc1", tc1);
				tc1.insert(selectedCard);
			} else if (c.getLocation().equals("tc2")) {
				selectedCard.setLocation("tc2", tc2);
				tc2.insert(selectedCard);
			} else if (c.getLocation().equals("tc3")) {
				selectedCard.setLocation("tc3", tc3);
				tc3.insert(selectedCard);
			} else if (c.getLocation().equals("tc4")) {
				selectedCard.setLocation("tc4", tc4);
				tc4.insert(selectedCard);
			} else if (c.getLocation().equals("tc5")) {
				selectedCard.setLocation("tc5", tc5);
				tc5.insert(selectedCard);
			} else if (c.getLocation().equals("tc6")) {
				selectedCard.setLocation("tc6", tc6);
				tc6.insert(selectedCard);
			} else if (c.getLocation().equals("tc7")) {
				selectedCard.setLocation("tc7", tc7);
				tc7.insert(selectedCard);
			} else {
				// nothing
			}
		} else {
			// tableau to tableau
			String source = selectedCard.getLocation();
			// insert to dest, flip up
			if (c.getLocation().equals("tc1")) {
				if (!selectedCard.getIsTop()) { // stack to tc1
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc1", tc1);
						tc1.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc1
					selectedCard.setLocation("tc1", tc1);
					tc1.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc2")) {
				if (!selectedCard.getIsTop()) { // stack to tc2
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc2", tc2);
						tc2.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc2
					selectedCard.setLocation("tc2", tc2);
					tc2.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc3")) {
				if (!selectedCard.getIsTop()) { // stack to tc3
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc3", tc3);
						tc3.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc3
					selectedCard.setLocation("tc3", tc3);
					tc3.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc4")) {
				if (!selectedCard.getIsTop()) { // stack to tc4
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc4", tc4);
						tc4.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc4
					selectedCard.setLocation("tc4", tc4);
					tc4.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc5")) {
				if (!selectedCard.getIsTop()) { // stack to tc5
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc5", tc5);
						tc5.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc5
					selectedCard.setLocation("tc5", tc5);
					tc5.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc6")) {
				if (!selectedCard.getIsTop()) { // stack to tc6
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc6", tc6);
						tc6.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc6
					selectedCard.setLocation("tc6", tc6);
					tc6.insert(selectedCard);
				}
			} else if (c.getLocation().equals("tc7")) {
				if (!selectedCard.getIsTop()) { // stack to tc7
					for (int i=0; i<selectedStackOfCards.size(); i++) {
						selectedStackOfCards.elementAt(i).setLocation("tc7", tc7);
						tc7.insert(selectedStackOfCards.elementAt(i));
					}
				} else { // single to tc7
					selectedCard.setLocation("tc7", tc7);
					tc7.insert(selectedCard);
				}
			} else {
				// nothing
			}
			// remove from source, flip up
			if (source.equals("tc1")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc1.removeLastElem();
					}
				} else { // single
					tc1.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc2")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc2.removeLastElem();
					}
				} else { // single
					tc2.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc3")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc3.removeLastElem();
					}
				} else { // single
					tc3.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc4")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc4.removeLastElem();
					}
				} else { // single
					tc4.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc5")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc5.removeLastElem();
					}
				} else { // single
					tc5.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc6")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc6.removeLastElem();
					}
				} else { // single
					tc6.removeLastElem();
				}
				flipUpTableau(source);
			} else if (source.equals("tc7")) {
				if (!selectedCard.getIsTop()) { // stack
					for (@SuppressWarnings("unused") Card d: selectedStackOfCards) {
						tc7.removeLastElem();
					}
				} else { // single
					tc7.removeLastElem();
				}
				flipUpTableau(source);
			} else {
				// nothing
			}
			deSelect();
		}
	}  // end moveToTableau()

	public void removeFromTableau(String s) {
		if (s.equals("tc1")) {
			tc1.getStack().elementAt(tc1.getStack().size()-1).setIsTop(false);
			tc1.getStack().remove(tc1.getStack().size()-1);
		}
		if (s.equals("tc2")) {
			tc2.getStack().elementAt(tc2.getStack().size()-1).setIsTop(false);
			tc2.getStack().remove(tc2.getStack().size()-1);
		}
		if (s.equals("tc3")) {
			tc3.getStack().elementAt(tc3.getStack().size()-1).setIsTop(false);
			tc3.getStack().remove(tc3.getStack().size()-1);
		}
		if (s.equals("tc4")) {
			tc4.getStack().elementAt(tc4.getStack().size()-1).setIsTop(false);
			tc4.getStack().remove(tc4.getStack().size()-1);
		}
		if (s.equals("tc5")) {
			tc5.getStack().elementAt(tc5.getStack().size()-1).setIsTop(false);
			tc5.getStack().remove(tc5.getStack().size()-1);
		}
		if (s.equals("tc6")) {
			tc6.getStack().elementAt(tc6.getStack().size()-1).setIsTop(false);
			tc6.getStack().remove(tc6.getStack().size()-1);
		}
		if (s.equals("tc7")) {
			tc7.getStack().elementAt(tc7.getStack().size()-1).setIsTop(false);
			tc7.getStack().remove(tc7.getStack().size()-1);
		}
	}
	
	public void selectCard(Card c) {
		selectedCard = c;
		c.highlight();
		if (c.getLocation().equals("tc1") && !c.getIsTop()) {
			for (int i=0; i<tc1.getStack().size(); i++) {
				if (tc1.getStack().elementAt(i) == c) {
					for (int j=i; j<tc1.getStack().size(); j++) {
						tc1.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc1.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc2") && !c.getIsTop()) {
			for (int i=0; i<tc2.getStack().size(); i++) {
				if (tc2.getStack().elementAt(i) == c) {
					for (int j=i; j<tc2.getStack().size(); j++) {
						tc2.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc2.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc3") && !c.getIsTop()) {
			for (int i=0; i<tc3.getStack().size(); i++) {
				if (tc3.getStack().elementAt(i) == c) {
					for (int j=i; j<tc3.getStack().size(); j++) {
						tc3.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc3.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc4") && !c.getIsTop()) {
			for (int i=0; i<tc4.getStack().size(); i++) {
				if (tc4.getStack().elementAt(i) == c) {
					for (int j=i; j<tc4.getStack().size(); j++) {
						tc4.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc4.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc5") && !c.getIsTop()) {
			for (int i=0; i<tc5.getStack().size(); i++) {
				if (tc5.getStack().elementAt(i) == c) {
					for (int j=i; j<tc5.getStack().size(); j++) {
						tc5.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc5.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc6") && !c.getIsTop()) {
			for (int i=0; i<tc6.getStack().size(); i++) {
				if (tc6.getStack().elementAt(i) == c) {
					for (int j=i; j<tc6.getStack().size(); j++) {
						tc6.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc6.getStack().elementAt(j));
					}
					break;
				}
			}
		} else if (c.getLocation().equals("tc7") && !c.getIsTop()) {
			for (int i=0; i<tc7.getStack().size(); i++) {
				if (tc7.getStack().elementAt(i) == c) {
					for (int j=i; j<tc7.getStack().size(); j++) {
						tc7.getStack().elementAt(j).highlight();
						selectedStackOfCards.add(tc7.getStack().elementAt(j));
					}
					break;
				}
			}
		} else {
			// nothing
		}
		showDestinations();
	}
	
	private void showDestinations() {
		if (selectedCard.getValue().equals("A")) {
			if (selectedCard.getSuit().equals("Clubs")) {
				foundationClubs.highlight();
			} else if (selectedCard.getSuit().equals("Spades")) {
				foundationSpades.highlight();
			} else if (selectedCard.getSuit().equals("Hearts")) {
				foundationHearts.highlight();
			} else { // if Diamonds
				foundationDiamonds.highlight();
			}
		}
		if (selectedCard.getValue().equals("K")) {
			if (tc1.getStack().isEmpty()) {
				tc1.highlight();
			}
			if (tc2.getStack().isEmpty()) {
				tc2.highlight();
			}
			if (tc3.getStack().isEmpty()) {
				tc3.highlight();
			}
			if (tc4.getStack().isEmpty()) {
				tc4.highlight();
			}
			if (tc5.getStack().isEmpty()) {
				tc5.highlight();
			}
			if (tc6.getStack().isEmpty()) {
				tc6.highlight();
			}
			if (tc7.getStack().isEmpty()) {
				tc7.highlight();
			}
		}
		// foundations
		if (!foundationClubs.getStack().isEmpty() && selectedCard.getSuit().equals("Clubs")) {
			if (foundationClubs.getStack().elementAt(foundationClubs.getStack().size()-1).getRealValue() == selectedCard.getRealValue()-1) {
				foundationClubs.getStack().elementAt(foundationClubs.getStack().size()-1).highlightAsDest();
				highlightedCards.add(foundationClubs.getStack().elementAt(foundationClubs.getStack().size()-1));
			}
		}
		if (!foundationSpades.getStack().isEmpty() && selectedCard.getSuit().equals("Spades")) {
			if (foundationSpades.getStack().elementAt(foundationSpades.getStack().size()-1).getRealValue() == selectedCard.getRealValue()-1) {
				foundationSpades.getStack().elementAt(foundationSpades.getStack().size()-1).highlightAsDest();
				highlightedCards.add(foundationSpades.getStack().elementAt(foundationSpades.getStack().size()-1));
			}
		}
		if (!foundationHearts.getStack().isEmpty() && selectedCard.getSuit().equals("Hearts")) {
			if (foundationHearts.getStack().elementAt(foundationHearts.getStack().size()-1).getRealValue() == selectedCard.getRealValue()-1) {
				foundationHearts.getStack().elementAt(foundationHearts.getStack().size()-1).highlightAsDest();
				highlightedCards.add(foundationHearts.getStack().elementAt(foundationHearts.getStack().size()-1));
			}
		}
		if (!foundationDiamonds.getStack().isEmpty() && selectedCard.getSuit().equals("Diamonds")) {
			if (foundationDiamonds.getStack().elementAt(foundationDiamonds.getStack().size()-1).getRealValue() == selectedCard.getRealValue()-1) {
				foundationDiamonds.getStack().elementAt(foundationDiamonds.getStack().size()-1).highlightAsDest();
				highlightedCards.add(foundationDiamonds.getStack().elementAt(foundationDiamonds.getStack().size()-1));
			}
		}
		// tableauColumns
		Card top = null;
		// tc1
		if (!tc1.getStack().isEmpty()) {
			top = tc1.getStack().elementAt(tc1.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc2
		if (!tc2.getStack().isEmpty()) {
			top = tc2.getStack().elementAt(tc2.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc3
		if (!tc3.getStack().isEmpty()) {
			top = tc3.getStack().elementAt(tc3.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc4
		if (!tc4.getStack().isEmpty()) {
			top = tc4.getStack().elementAt(tc4.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc5
		if (!tc5.getStack().isEmpty()) {
			top = tc5.getStack().elementAt(tc5.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc6
		if (!tc6.getStack().isEmpty()) {
			top = tc6.getStack().elementAt(tc6.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// tc7
		if (!tc7.getStack().isEmpty()) {
			top = tc7.getStack().elementAt(tc7.getStack().size()-1);
			if (top.getRealValue()-1 == selectedCard.getRealValue()) {
				if (!top.getColor().equals(selectedCard.getColor())) {
					top.highlightAsDest();
					highlightedCards.add(top);
				}
			}
		}
		// end tableauColumns

	} // end showDestinations()
	
	public void shuffleStockPile() {
		Collections.shuffle(stockPile.getStack());
	}
	
	// end Methods
	
	// Setters
	public void setFoundationClubs(NormalPile np) {
		foundationClubs = np;
	}
	public void setFoundationDiamonds(NormalPile np) {
		foundationDiamonds = np;
	}
	public void setFoundationHearts(NormalPile np) {
		foundationHearts = np;
	}
	public void setFoundationSpades(NormalPile np) {
		foundationSpades = np;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public void setScore(int n) {
		score += n;
		String s = "Score: ";
		s += Integer.toString(score);
		scoreLabel.setText(s);
	}
	public void setScoreLabel (Label l) {
		scoreLabel = l;
	}
	public void setSelectedCard(Card c) {
		selectedCard = c;
	}
	public void setStockPile(NormalPile np) {
		this.stockPile = np;
	}
	public void setTc1(TableauColumn tc) {
		tc1 = tc;
	}
	public void setTc2(TableauColumn tc) {
		tc2 = tc;
	}
	public void setTc3(TableauColumn tc) {
		tc3 = tc;
	}
	public void setTc4(TableauColumn tc) {
		tc4 = tc;
	}
	public void setTc5(TableauColumn tc) {
		tc5 = tc;
	}
	public void setTc6(TableauColumn tc) {
		tc6 = tc;
	}
	public void setTc7(TableauColumn tc) {
		tc7 = tc;
	}
	public void setWastePile(WastePile wp) {
		wastePile = wp;
	}
	// end Setters
	
	// Getters
	public int getScore() {
		return score;
	}
	public Card getSelectedCard() {
		return selectedCard;
	}
	public NormalPile getStockPile() {
		return stockPile;
	}
	public WastePile getWastePile() {
		return wastePile;
	}
	public NormalPile getFoundationClubs() {
		return foundationClubs;
	}
	public NormalPile getFoundationSpades() {
		return foundationSpades;
	}
	public NormalPile getFoundationHearts() {
		return foundationHearts;
	}
	public NormalPile getFoundationDiamonds() {
		return foundationDiamonds;
	}
	public TableauColumn getTc1() {
		return tc1;
	}
	public TableauColumn getTc2() {
		return tc2;
	}
	public TableauColumn getTc3() {
		return tc3;
	}
	public TableauColumn getTc4() {
		return tc4;
	}
	public TableauColumn getTc5() {
		return tc5;
	}
	public TableauColumn getTc6() {
		return tc6;
	}
	public TableauColumn getTc7() {
		return tc7;
	}
	// end Getters
	
}
