package application.model;

import java.util.Vector;

import javafx.scene.layout.Region;

public class NormalPile extends Region {

	// Fields
	private boolean highlighted = false;
	Vector<Card> stack = new Vector<Card>();
	@SuppressWarnings("unused")
	private Position pos;
	private double sizeX = 70;
	private double sizeY = 105;
	// end Fields
	
	// CSS Fields
	private String borderColor = "black";
	private String borderWidth = "1px";
	// end CSS Fields
	
	// Constructor
	public NormalPile(Region t) {
		pos = new Position(t.getLayoutX(), t.getLayoutY());
		this.setLayoutX(t.getLayoutX());
		this.setLayoutY(t.getLayoutY());
		this.setPrefSize(sizeX, sizeY);
		this.updateStyle();
	}
	// end Constructor
	
	// Methods
	public void defaultStyle() {
		highlighted = false;
		borderColor = "black";
		borderWidth = "1px";
		updateStyle();
	}
	
	public void highlight() {
		highlighted = true;
		borderColor = "orange";
		borderWidth = "3px";
		updateStyle();
	}
	public void updateStyle() {
		this.setStyle(
			"-fx-border-color: " + borderColor + ";" +
			"-fx-border-width: " + borderWidth + ";"
		);
	}
	public void insert(Card c) {
		stack.add(c);
	}
	public void insertFront(Card c) {
		stack.insertElementAt(c, 0);
	}
	public boolean isHighlighted() {
		return highlighted;
	}
	public void removeLastElem() {
		if (!stack.isEmpty()) {
			stack.remove(stack.size()-1);
		}
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
