package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class Main extends Application {
	@Override
	public void start(Stage window) {
		window.setTitle("Soundboard 101");
		
		BorderPane initialView = new BorderPane();
		VBox layout = new VBox();
		layout.setPadding(new Insets(18, 18, 18, 18));
		Text chooseGridSize = new Text("How many sounds do you want to have?");
		chooseGridSize.setStyle("-fx-font-weight: bold");
		chooseGridSize.setStyle("-fx-font-size: 18px");
		
		layout.getChildren().add(chooseGridSize);
		layout.setAlignment(Pos.CENTER);
		
		GridPane initialGrid = new GridPane();
		initialGrid.setHgap(18);
		initialGrid.setVgap(18);
		initialGrid.setPadding(new Insets(18, 18, 18, 18));
		initialGrid.setAlignment(Pos.CENTER);
		
		Button create2 = new Button("2 SOUNDS");
		create2.setPrefSize(100, 100);
		create2.setOnMouseClicked(e -> {
			GridPane grid = createButtonsGrid(2);
			grid.setHgap(18);
			grid.setVgap(18);
			grid.setPadding(new Insets(18, 18, 18, 18));
			grid.setAlignment(Pos.CENTER);
			
			Button stopButton = new Button("STOP ALL");
			stopButton.setPrefSize(100, 100);
			stopButton.setOnMouseClicked(s -> SoundButton.stopAllMedia());
			
			VBox box = new VBox();
			box.getChildren().add(stopButton);
			box.setAlignment(Pos.CENTER);
			box.setPadding(new Insets(18, 18, 18, 18));
			
			BorderPane view = new BorderPane();
			view.setCenter(grid);
			view.setBottom(box);

			Scene scene = new Scene(view, 400, 300);
			window.setScene(scene);
			window.show();
		});
		Button create4 = new Button("4 SOUNDS");
		create4.setPrefSize(100, 100);
		create4.setOnMouseClicked(e -> {
			GridPane grid = createButtonsGrid(4);
			grid.setHgap(18);
			grid.setVgap(18);
			grid.setPadding(new Insets(18, 18, 18, 18));
			grid.setAlignment(Pos.CENTER);
			
			Button stopButton = new Button("STOP ALL");
			stopButton.setPrefSize(100, 100);
			stopButton.setOnMouseClicked(s -> SoundButton.stopAllMedia());
			
			VBox box = new VBox();
			box.getChildren().add(stopButton);
			box.setAlignment(Pos.CENTER);
			box.setPadding(new Insets(18, 18, 18, 18));
			
			BorderPane view = new BorderPane();
			view.setCenter(grid);
			view.setBottom(box);

			Scene scene = new Scene(view, 400, 300);
			window.setScene(scene);
			window.show();
		});
		Button create6 = new Button("6 SOUNDS");
		create6.setPrefSize(100, 100);
		create6.setOnMouseClicked(e -> {
			GridPane grid = createButtonsGrid(6);
			grid.setHgap(18);
			grid.setVgap(18);
			grid.setPadding(new Insets(18, 18, 18, 18));
			grid.setAlignment(Pos.CENTER);

			Button stopButton = new Button("STOP ALL");
			stopButton.setPrefSize(100, 100);
			stopButton.setOnMouseClicked(s -> SoundButton.stopAllMedia());
			
			VBox box = new VBox();
			box.getChildren().add(stopButton);
			box.setAlignment(Pos.CENTER);
			box.setPadding(new Insets(18, 18, 18, 18));
			
			BorderPane view = new BorderPane();
			view.setCenter(grid);
			view.setBottom(box);

			Scene scene = new Scene(view, 400, 300);
			window.setScene(scene);
			window.show();
		});
		Button create8 = new Button("8 SOUNDS");
		create8.setPrefSize(100, 100);
		create8.setOnMouseClicked(e -> {
			GridPane grid = createButtonsGrid(8);
			grid.setHgap(18);
			grid.setVgap(18);
			grid.setPadding(new Insets(18, 18, 18, 18));
			grid.setAlignment(Pos.CENTER);

			Button stopButton = new Button("STOP ALL");
			stopButton.setPrefSize(100, 100);
			stopButton.setOnMouseClicked(s -> SoundButton.stopAllMedia());
			
			VBox box = new VBox();
			box.getChildren().add(stopButton);
			box.setAlignment(Pos.CENTER);
			box.setPadding(new Insets(18, 18, 18, 18));
			
			BorderPane view = new BorderPane();
			view.setCenter(grid);
			view.setBottom(box);

			Scene scene = new Scene(view, 400, 300);
			window.setScene(scene);
			window.show();
		});
		
		initialGrid.add(create2, 0, 0);
		initialGrid.add(create4, 0, 1);
		initialGrid.add(create6, 1, 0);
		initialGrid.add(create8, 1, 1);
		
		initialView.setCenter(initialGrid);
		initialView.setTop(layout);
		
		Scene scene = new Scene(initialView, 400, 300);
		window.setScene(scene);
		window.show();
	}
	
	public GridPane createButtonsGrid(int number) {
		ArrayList<SoundButton> buttons = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			buttons.add(new SoundButton("S" + i));
		}
		for (SoundButton button: buttons) {
			button.setPrefSize(100, 100);
		}
		GridPane grid = new GridPane();
		int columns = 0;
		if (number / 2 == 1 || number / 2 == 2) {
			columns = 2;
		} else if (number / 2 == 3) {
			columns = 3;
		} else {
			columns = 4;
		}
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < buttons.size(); i++) {
			grid.add(buttons.get(i), col, row);
			col++;
			if (col == columns) {
				col = 0;
				row++;
			}
		}
		
		return grid;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
