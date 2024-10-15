package application;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SoundButton extends Button{
	private File soundFile;
	private MediaPlayer mediaPlayer;
	private static List<SoundButton> allButtons = new ArrayList<>();
	
	public SoundButton(String text) {
		super(text);
		this.setOnMouseClicked(e -> handleButtonAction());
		allButtons.add(this);
	}
	
	public static void stopAllMedia() {
		for (SoundButton button: allButtons) {
			if (button.mediaPlayer != null &&
				button.mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
					button.mediaPlayer.stop();
				}
		}
	}
	
	public void handleButtonAction() {
		if (soundFile == null) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new FileChooser
					.ExtensionFilter("Audio Files","*wav", "*mp3"));
			File selectedFile = fileChooser.showOpenDialog(new Stage());
			if (selectedFile != null) {
				soundFile = selectedFile;
				this.setText(selectedFile.getName());
				Media media = new Media(soundFile.toURI().toString());
				mediaPlayer = new MediaPlayer(media);
			}
		} else {
			if (mediaPlayer != null) {
				MediaPlayer.Status status = mediaPlayer.getStatus();
				if (status == MediaPlayer.Status.PLAYING) {
					mediaPlayer.stop();
				} else {
					mediaPlayer.play();
				}
			}
		}
	}
}
