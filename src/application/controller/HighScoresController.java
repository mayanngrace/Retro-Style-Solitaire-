package application.controller;

import java.io.File;

import application.Main;
import application.model.HighScoreSystem;
import application.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class HighScoresController {
	
	// Fields
	private Main main;
	private HighScoreSystem highScoreSystem = new HighScoreSystem(); 
	// end Fields
	
	// FXML Fields
	@FXML
	private Region backRegion;
	@FXML
	private MediaView bgMV;
	@FXML
	private AnchorPane highScoresAP;
	@FXML
	private Label hsLabel;
	// end FXML Fields
	
	// Methods
	
	@FXML
	public void goBack() {
		main.changeScene("Main Menu");
	}
	
	public void setMain(Main main) {
		this.main = main;
		File file = new File("assets/highScores/vid.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		bgMV.setMediaPlayer(mediaPlayer);
		highScoreSystem.readHS();
		highScoreSystem.sortDB();
		String s = "";
		for (Player p: highScoreSystem.database) {
			s += p.getName() + ": " + p.getScore() + "\n";
		}
		hsLabel.setText(s);
	}
	
	// end Methods
}
