//	CMSC 23 LEC2 Machine Problem
//
//	Bajo, Justin Ryan
//	Licup, John Paolo
//	Palisoc, May Ann Grace
//	Santos, Ethan Mark

package application;
	
import java.io.IOException;

import application.controller.ChooseDifficultyController;
import application.controller.GameOverController;
import application.controller.GameSceneController;
import application.controller.HighScoresController;
import application.controller.HowToPlayController;
import application.controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	// Fields
	private String difficulty; // Can be "Normal" (1 card per draw) or "Hard" (3 cards per draw)
	private AnchorPane myAnchorPane;
	private FXMLLoader myFXMLLoader;
	private Scene myScene;
	private String playerName;
	private Stage primaryStage;
	public int score;
	// end Fields
	
	// Getters
	public String getDifficulty() {
		return difficulty;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	// end Getters
	
	// Setters
	public void setDifficulty(String s) {
		difficulty = s;
	}
	public void setPlayerName(String s) {
		playerName = s;
	}
	// end Setters
	
	// Methods
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		try {
			this.primaryStage.setResizable(false);
			this.primaryStage.setTitle("Solitaire");
			this.primaryStage.show();
			changeScene("Main Menu");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Changes the JavaFX Scene. Possible parameter values: "Main Menu", "Game Scene", "How to Play", "High Scores", "Choose Difficulty"
	 * @param scene
	 */
	public void changeScene(String scene) {
		if (scene == "Main Menu") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				MainMenuController mainMenuController = myFXMLLoader.getController();
				mainMenuController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (scene == "Game Scene") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/GameScene.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				GameSceneController gameSceneController = myFXMLLoader.getController();
				gameSceneController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (scene == "How to Play") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/HowToPlay.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				HowToPlayController howToPlayController = myFXMLLoader.getController();
				howToPlayController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (scene == "High Scores") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/HighScores.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				HighScoresController highScoresController = myFXMLLoader.getController();
				highScoresController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (scene == "Choose Difficulty") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/ChooseDifficulty.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				ChooseDifficultyController chooseDifficultyController = myFXMLLoader.getController();
				chooseDifficultyController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (scene == "Game Over") {
			try {
				myFXMLLoader = new FXMLLoader();
				myFXMLLoader.setLocation(Main.class.getResource("view/GameOver.fxml"));
				myAnchorPane = (AnchorPane) myFXMLLoader.load();
				myScene = new Scene(myAnchorPane);
				primaryStage.setScene(myScene);
				GameOverController gameOverController = myFXMLLoader.getController();
				gameOverController.setMain(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperties());
		launch(args);
	}
	
	// end Methods
	
}
