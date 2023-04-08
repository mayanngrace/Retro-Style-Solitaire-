package application.controller;

import java.io.File;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class GameOverController {

	// Fields
	Main main;
	// end Fields
	
	// FXML Fields
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private MediaView bgMV;
	@FXML
	private Label scoreLabel;
	// end FXML Fields
	
	// Methods
	public void setMain(Main main) {
		this.main = main;
		File file = new File("assets/gameOver/vid.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		bgMV.setMediaPlayer(mediaPlayer);
		scoreLabel.setText(Integer.toString(main.score));
	}
	@FXML
	public void toMainMenu() {
		main.changeScene("Main Menu");
	}
	// end Methods
	
}
