package application.controller;

import java.io.File;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainMenuController {

	// Fields
	private Main main;
	// end Fields
	
	// FXML Fields
	
	@FXML
	private MediaView bgMV;
	
	@FXML
	private Region howToPlayRegion;
	
	@FXML
	private AnchorPane mainMenuAP;
	
	@FXML
	private Region playRegion;
	
	@FXML
	private Region quitRegion;
	
	@FXML
	private Region viewHighScoresRegion;
	
	// end FXML Fields
	
	// Methods
	
	@FXML
	public void doHighScores() {
		main.changeScene("High Scores");
	}
	
	@FXML
	public void doPlay() {
		main.changeScene("Choose Difficulty");
	}
	
	@FXML
	public void doQuit() {
		System.exit(1);
	}
	
	@FXML
	public void doTutorial() {
		main.changeScene("How to Play");
	}
	
	public void setMain(Main main) {
		File file = new File("assets/mainMenu/vid.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		bgMV.setMediaPlayer(mediaPlayer);
		this.main = main;
	}
	
	// end Methods
	
}
