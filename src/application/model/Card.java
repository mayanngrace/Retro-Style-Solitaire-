package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;

public class Card extends Region {

	// Fields
	private String color;
	private String face; // "up" or "down"
	private String imgPath;
	private boolean isTop = false;
	private String location; // "stockPile", "wastePile", "foundationClubs", "tc1"
	private int realValue;
	private String suit;
	private boolean selectable;
	private String value;
	private boolean validDest = false;
	// end Fields
	
	// CSS Fields
	private String borderColor = "black";
	private String borderStyle = "solid";
	private String borderWidth = "1px";
	private String prefWidth = "70px";
	private String prefHeight = "105px";
	// end CSS Fields
	
	// Constructor
	public Card(String value, String suit, String location, Region region) {
		this.value = value;
		this.suit = suit;
		if (value.equals("A") || value.equals("J") || value.equals("Q") || value.equals("K")) {
			if (value.equals("A")) {
				realValue = 1;
			} else if (value.equals("J")) {
				realValue = 11;
			} else if (value.equals("Q")) {
				realValue = 12;
			} else {
				realValue = 13;
			}
		} else {
			realValue = Integer.parseInt(value);
		}
		selectable = false;
		setLocation(location, region);
		setColor();
		setImgPath();
		updateStyle();
		setBackground();
	}
	// end Constructor
	
	// Methods
	
	public void defaultStyle() {
		validDest = false;
		borderColor = "black";
		borderWidth = "1px";
		updateStyle();
	}
	
	public void highlight() {
		borderColor = "blue";
		borderWidth = "3px";
		updateStyle();
	}
	
	public void highlightAsDest() {
		validDest = true;
		borderColor = "orange";
		borderWidth = "3px";
		updateStyle();
	}
	
	public void updateStyle() {
		this.setStyle(
			"-fx-fill: blue;" +
			"-fx-border-width: " + borderWidth + ";" +		
			"-fx-border-style: " + borderStyle + ";" +
			"-fx-pref-width: " + prefWidth + ";" +
			"-fx-pref-height: " + prefHeight + ";" +
			"-fx-border-color: " + borderColor + ";"
		);		
	}
	
	public void setBackground() {
		this.setBackground(new Background(new BackgroundImage(new Image("file:" + imgPath), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
	public void setFaceDown() {
		face = "down";
		this.setBackground(new Background(new BackgroundImage(new Image("file:assets/cards/newbg.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
	public void setFaceUp() {
		face = "up";
		this.setBackground(new Background(new BackgroundImage(new Image("file:" + imgPath), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
	}
	
	public String toString() {
		String s = "Card Object. ";
		s += "[Value: " + value + "]";
		s += "[Suit: " + suit + "]";
		s += "[Color: " + color + "]";
		return s;
	}
	
	// end Methods
	
	// Getters of Fields
	public String getColor() {
		return color;
	}
	public String getFace() {
		return face;
	}
	public boolean getIsTop() {
		return isTop;
	}
	public String getLocation() {
		return location;
	}
	public int getRealValue() {
		return realValue;
	}
	public Boolean getSelectable() {
		return selectable;
	}
	public String getSuit() {
		return suit;
	}
	public boolean getValidDest() {
		return validDest;
	}
	public String getValue() {
		return value;
	}
	// end Getters of Fields
	
	// Setters of Fields
	public void setColor() {
		if (suit == "Clubs" || suit == "Spades") {
			color = "black";
		} else {
			color = "red";
		}
	}
	public void setImgPath() {
		imgPath = "assets/cards/" + value + suit + ".png";
	}
	public void setIsTop(boolean b) {
		isTop = b;
	}
	public void setLocation(String s, Region r) {
		location = s;
		this.setLayoutX(r.getLayoutX());
		this.setLayoutY(r.getLayoutY());
	}
	public void setSelectable(Boolean b) {
		selectable = b;
	}
	// end Setters of Fields
	
	// Getters of CSS Fields
	
	// end Getters of CSS Fields
	
	// Setters of CSS Fields
	public void setBorderColor(String s) {
		borderColor = s;
	}
	public void setBorderStyle(String s) {
		borderStyle = s;
	}
	public void setBorderWidth(String s) {
		borderWidth = s;
	}
	// end Setters of CSS Fields
}
