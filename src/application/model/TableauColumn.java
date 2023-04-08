package application.model;

import java.util.Vector;

import javafx.scene.layout.Region;

public class TableauColumn extends Region {

	// Fields
	private boolean highlighted = false;
	/**
	 * Vector that will contain the cards in this column.
	 */
	private Vector<Card> stack = new Vector<Card>();
	private Position pos;
	private double sizeX = 70;
	private double sizeY = 105;
	// end Fields
	
	// CSS Fields
	private String borderColor = "black";
	private String borderWidth = "1px";
	// end CSS Fields
	
	// Constructor
	public TableauColumn(Region t) {
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
	public void insert(Card c) {
		if (!stack.isEmpty()) {
			stack.elementAt(stack.size()-1).setIsTop(false);
		}
		c.setLayoutY(pos.getY() + stack.size()*15);
		c.toFront();
		stack.add(c);
		stack.elementAt(stack.size()-1).setIsTop(true);
	}
	public void removeLastElem() {
		if (!stack.isEmpty()) {
			stack.remove(stack.size()-1);
		}
	}
	public void updateStyle() {
		this.setStyle(
			"-fx-border-color: " + borderColor + ";" +
			"-fx-border-width: " + borderWidth + ";"
		);
	}
	// end Methods
	
	// Getters
	public boolean isHighlighted() {
		return highlighted;
	}
	public Vector<Card> getStack() {
		return stack;
	}
	// end Getters
	
}
