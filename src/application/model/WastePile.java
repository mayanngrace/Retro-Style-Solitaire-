package application.model;

import java.util.Vector;

import application.Main;
import javafx.scene.layout.Region;

public class WastePile extends Region {

	// Fields
	public Main main;
	Vector<Card> stack = new Vector<Card>();
	private Position pos;
	private double sizeX = 70;
	private double sizeY = 105;
	// end Fields
	
	// CSS Fields
	private String borderColor = "black";
	private String borderWidth = "1px";
	// end CSS Fields
	
	// Constructor
	public WastePile(Region t, Main main) {
		this.main = main;
		pos = new Position(t.getLayoutX(), t.getLayoutY());
		this.setLayoutX(t.getLayoutX());
		this.setLayoutY(t.getLayoutY());
		this.setPrefSize(sizeX, sizeY);
		this.updateStyle();
	}
	// end Constructor
	
	// Methods
	public void updateStyle() {
		this.setStyle(
			"-fx-border-color: " + borderColor + ";" +
			"-fx-border-width: " + borderWidth + ";"
		);
	}
	public void indent3() {
		for (Card c: stack) {
			c.setLayoutX(pos.getX());
			c.setLayoutY(pos.getY());
			c.setSelectable(false);
		}
		if (main.getDifficulty().equals("Normal")) {
			if (!stack.isEmpty() ) {
				stack.elementAt(stack.size()-1).setSelectable(true);		
			}
		} else {
			if (stack.size() >= 3) {
				stack.elementAt(stack.size()-2).setLayoutX(pos.getX()+15);
				stack.elementAt(stack.size()-2).setLayoutY(pos.getY()+10);
				stack.elementAt(stack.size()-1).setLayoutX(pos.getX()+30);
				stack.elementAt(stack.size()-1).setLayoutY(pos.getY()+20);
				stack.elementAt(stack.size()-1).setSelectable(true);
			} else if (stack.size() == 2) {
				stack.elementAt(stack.size()-1).setLayoutX(pos.getX()+15);
				stack.elementAt(stack.size()-1).setLayoutY(pos.getY()+10);
				stack.elementAt(stack.size()-1).setSelectable(true);
			} else if (stack.size() == 1){ // if size is 1
				stack.elementAt(stack.size()-1).setSelectable(true);
			} else { // if wastePile became empty
				
			}
		}
	}
	public void insert(Card c) {
		stack.add(c);
		c.toFront();
	}
	// end Methods
	
	// Getters
	public Vector<Card> getStack() {
		return stack;
	}
	// end Getters
	
	// CSS Setters
	public void setBorderColor(String s) {
		borderColor = s;
	}
	public void setBorderWidth(String s) {
		borderWidth = s;
	}
	// end CSS Setters
}
