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
	private Stage primaryStage;
	private BorderPane root;
	private String[] data;
	private int state;
	private final int FIRSTNAME=0;
	private final int LASTNAME=1;
	private final int NUMBER=2;
	private TelefonEntry te;
	private Telefonbuch tb;
	public void start() throws Exception {
		Button b;
		final TextField tf;
		switch (state) {
		case FIRSTNAME:
			data=new String[3];
			primaryStage.setTitle("First Name");
			tf = new TextField();
			b=new Button("Next");
			{
				EventHandler<MouseEvent> e=new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						try {
						data[0]=tf.getText();
						if (data[0]!=null&&data[0]!="")
							state=LASTNAME;
						start();
						} catch (Exception e) {
					
						}
					}
				};
				b.setOnMouseClicked(e);
			}
			this.root.setTop(tf);
			this.root.setBottom(b);
			break;
		case LASTNAME:
			primaryStage.setTitle("Last Name");
			tf = new TextField();
			b=new Button("Next");
			{
				EventHandler<MouseEvent> e=new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						try {
						data[1]=tf.getText();
						if (data[1]!=null&&data[1]!="")
							state=NUMBER;
						start();
						} catch (Exception e) {
					
						}
					}
				};
				b.setOnMouseClicked(e);
			}
			this.root.setTop(tf);
			this.root.setBottom(b);
			break;
		case NUMBER:
			primaryStage.setTitle("First Name");
			tf = new TextField();
			b=new Button("Next");
			{
				EventHandler<MouseEvent> e=new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						try {
						data[2]=tf.getText();
						if (data[2]==null||data[2]=="")
							return;
						state=FIRSTNAME;
				        SearchArea searchArea = new SearchArea();
				        Button b= new Button("New Entry");
				        root.setTop(searchArea.getPane());
				        root.setBottom(b);
				        te=new TelefonEntry(data[0], data[1], data[2]);
				        primaryStage.setTitle("Search");
						} catch (Exception e) {
					
						}
					}
				};
				b.setOnMouseClicked(e);
			}
			this.root.setTop(tf);
			this.root.setBottom(b);
		}
		System.out.println(data[0]+" "+data[1]+" "+data[2]);
	}
	public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    	tb=new Telefonbuch();
        BorderPane root = new BorderPane();
        SearchArea searchArea = new SearchArea();
        Button b= new Button("New Entry");
        EventHandler<MouseEvent> e= new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				try {
					start();
					tb.addEintrag(te);
				} catch (Exception e) {
					
				}
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