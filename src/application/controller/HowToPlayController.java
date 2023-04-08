package application.controller;

import java.io.File;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class HowToPlayController {

	// Fields
	private Main main;
	private int currentPage = 0;
	// end Fields
	
	// FXML Fields
	@FXML
	private Region backRegion;
	@FXML
	private MediaView bgMV;
	@FXML
	private AnchorPane howToPlayAP;
	// end FXML Fields
	
	// Methods
	
	@FXML
	public void goBack() {
		if (currentPage == 0) {
			main.changeScene("Main Menu");
		} else if (currentPage == 1) {
			currentPage = 0;
			File file = new File("assets/howToPlay/tut1.mp4");
			MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			bgMV.setMediaPlayer(mediaPlayer);
		} else if (currentPage == 2) {
			currentPage = 1;
			File file = new File("assets/howToPlay/tut2.mp4");
			MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			bgMV.setMediaPlayer(mediaPlayer);
		}
	}
	
	@FXML
	public void doNext() {
		if (currentPage == 0) {
			currentPage = 1;
			File file = new File("assets/howToPlay/tut2.mp4");
			MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			bgMV.setMediaPlayer(mediaPlayer);
		} else if (currentPage == 1) {
			currentPage = 2;
			File file = new File("assets/howToPlay/tut3.mp4");
			MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
			mediaPlayer.setAutoPlay(true);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			bgMV.setMediaPlayer(mediaPlayer);
		} else if (currentPage == 2) {
			main.changeScene("Main Menu");
		}
	}
	
	public void setMain(Main main) {
		this.main = main;
		currentPage = 0;
		File file = new File("assets/howToPlay/tut1.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		bgMV.setMediaPlayer(mediaPlayer);
	}
	
	// end Methods
}
