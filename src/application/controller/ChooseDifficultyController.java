package application.controller;

import java.io.File;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ChooseDifficultyController {

	// Fields
	private Main main;
	// end Fields
	
	// FXML Fields
	@FXML
	private Region backRegion;
	@FXML
	private MediaView bgMV;
	@FXML
	private AnchorPane chooseDifficultyAP;
	@FXML
	private Region hardRegion;
	@FXML
	private TextField nameField;
	@FXML
	private Region normalRegion;
	// end FXML Fields
	
	// Methods
	
	@FXML
	public void chooseHard() {
		main.setDifficulty("Hard");
		main.changeScene("Game Scene");
		setName();
	}
	
	@FXML
	public void chooseNormal() {
		main.setDifficulty("Normal");
		main.changeScene("Game Scene");
		setName();
	}
	
	@FXML
	public void goBack() {
		main.changeScene("Main Menu");
	}
	
	public void setMain(Main main) {
		this.main = main;
		File file = new File("assets/chooseDifficulty/vid.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		bgMV.setMediaPlayer(mediaPlayer);
	}
	
	private void setName() {
		String name = "Player";
		if (nameField.getText().length() > 0) {
			name = nameField.getText();
		}
		main.setPlayerName(name);
	}
	
	// end Methods
}
