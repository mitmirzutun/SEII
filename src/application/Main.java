package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane root = new BorderPane();
        SearchArea searchArea = new SearchArea();
        Button b= new Button("New Entry");
        EventHandler<MouseEvent> e= new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				TextField tf = new TextField();
				BorderPane root = new BorderPane();
				root.setTop(tf);
				Button b = new Button("Confirm");
				root.setBottom(b);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("First Name");
				primaryStage.setScene(new Scene(root, 300,275));
			}
		};
        b.setOnMouseClicked(e);
        root.setTop(searchArea.getPane());
        root.setBottom(b);
        primaryStage.setTitle("Search");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}