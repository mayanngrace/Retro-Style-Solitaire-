package application.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import application.Main;
import application.model.Card;
import application.model.GameMechanics;
import application.model.HighScoreSystem;
import application.model.NormalPile;
import application.model.TableauColumn;
import application.model.WastePile;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;

public class GameSceneController {

	// Fields
	private Main main;
	private GameMechanics gameMechanics = new GameMechanics();
	private HighScoreSystem highScoreSystem = new HighScoreSystem();
	// end Fields
	
	// FXML Elements
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Region endRegion;
	@FXML
	private Region tableauColumn1;
	@FXML
	private Region tableauColumn2;
	@FXML
	private Region tableauColumn3;
	@FXML
	private Region tableauColumn4;
	@FXML
	private Region tableauColumn5;
	@FXML
	private Region tableauColumn6;
	@FXML
	private Region tableauColumn7;
	@FXML
	private Label scoreLabel;
	@FXML
	private Region stockPile;
	@FXML
	private Region wastePile;
	@FXML
	private Region foundationClubs;
	@FXML
	private Region foundationSpades;
	@FXML
	private Region foundationHearts;
	@FXML
	private Region foundationDiamonds;
	// end FXML Elements
	
	// Methods
	
	private void allowRedealing() {
		gameMechanics.getStockPile().setOnMouseClicked(event -> {
			if (!gameMechanics.getWastePile().getStack().isEmpty()) {
				if (main.getDifficulty().equals("Normal")) {
					gameMechanics.setScore(-100);
				}
				for (Card c: gameMechanics.getWastePile().getStack()) {
					c.setLocation("stockPile", stockPile);
					c.setFaceDown();
					gameMechanics.getStockPile().insertFront(c);
				}
				gameMechanics.getWastePile().getStack().clear();
				gameMechanics.arrangeStockPile();
			} else { // if wastePile is empty
				// nothing
			}
		});
	}
	
	private void generateCards() {
		gameMechanics.generateCardObjects();
		for (Card c: gameMechanics.getStockPile().getStack()) {
			c.setFaceDown();
			c.setSelectable(true);
			c.setLayoutX(stockPile.getLayoutX());
			c.setLayoutY(stockPile.getLayoutY());
			anchorPane.getChildren().add(c);
			c.toFront();
		}
	}
	
	private void generatePiles() {
		// Stock Pile
		NormalPile tmp = new NormalPile(stockPile);
		gameMechanics.setStockPile(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/redealBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp);
		tmp.toFront();
		// Waste Pile
		WastePile tmp2 = new WastePile(wastePile, main);
		gameMechanics.setWastePile(tmp2);
		tmp2.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/wastepileBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp2);
		tmp2.toFront();
		// Foundations
		tmp = new NormalPile(foundationClubs);
		gameMechanics.setFoundationClubs(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/clubsBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp);
		tmp.toFront();
		tmp = new NormalPile(foundationSpades);
		gameMechanics.setFoundationSpades(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/spadesBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp);
		tmp.toFront();
		tmp = new NormalPile(foundationHearts);
		gameMechanics.setFoundationHearts(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/heartsBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp);
		tmp.toFront();
		tmp = new NormalPile(foundationDiamonds);
		gameMechanics.setFoundationDiamonds(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/diamondsBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		anchorPane.getChildren().add(tmp);
		tmp.toFront();
	}
	
	private void generateTableauColumns() {
		TableauColumn tmp = new TableauColumn(tableauColumn1);
		gameMechanics.setTc1(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn2);
		gameMechanics.setTc2(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn3);
		gameMechanics.setTc3(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn4);
		gameMechanics.setTc4(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn5);
		gameMechanics.setTc5(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn6);
		gameMechanics.setTc6(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
		tmp = new TableauColumn(tableauColumn7);
		gameMechanics.setTc7(tmp);
		anchorPane.getChildren().add(tmp);
		tmp.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/tableauBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		tmp.toFront();
	}
	
	private void initializeCardEvents() {
		for (Card c: gameMechanics.getStockPile().getStack()) {
			c.setOnMouseClicked(event -> {
				boolean skip = false;
				if (gameMechanics.getSelectedCard() != null) { // if a card is selected
					if (gameMechanics.getSelectedCard() == c) {
						gameMechanics.deSelect();
						skip = true;	
					} else {
						if (c.getLocation().equals("foundationClubs") || c.getLocation().equals("foundationSpades") || c.getLocation().equals("foundationHearts") || c.getLocation().equals("foundationDiamonds")) {
							gameMechanics.moveToFoundation(c);
						} else if (c.getLocation().equals("tc1") || c.getLocation().equals("tc2") || c.getLocation().equals("tc3") || c.getLocation().equals("tc4") || c.getLocation().equals("tc5") || c.getLocation().equals("tc6") || c.getLocation().equals("tc7")) {
							gameMechanics.moveToTableau(c);
						} else {
							
						}
						gameMechanics.deSelect();
						skip = true;
					}					
				}
				if (c.getSelectable() && skip == false) {
					if (c.getLocation().equals("stockPile")) {
						gameMechanics.draw();
					} else if (c.getLocation().equals("wastePile")) {
						if (c == gameMechanics.getWastePile().getStack().elementAt(gameMechanics.getWastePile().getStack().size()-1)) {
							gameMechanics.selectCard(c);
						}
					} else {
						gameMechanics.selectCard(c);
					}
				}
				
			});
		}
		gameMechanics.initializeMoveEvents();
	}
	
	public void setMain(Main main) {
		this.main = main;
		anchorPane.setBackground(new Background(new BackgroundImage(new Image("file:assets/backgrounds/gameSceneBG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		gameMechanics.setMain(main);
		gameMechanics.setScoreLabel(scoreLabel);
		gameMechanics.setScore(0);
		generatePiles();
		generateTableauColumns();
		generateCards();
		gameMechanics.shuffleStockPile();
		initializeCardEvents();
		allowRedealing();
		gameMechanics.generateInitialCards();
	}
	
	@FXML
	public void toMainMenu() {
		try {
			highScoreSystem.newEntry(main.getPlayerName(), gameMechanics.getScore());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		main.score = gameMechanics.getScore();
		main.changeScene("Game Over");
	}

	// end Methods
	
}
