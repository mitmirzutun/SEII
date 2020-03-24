package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
		public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			TextField tf1 = new TextField();
			tf1.setPrefColumnCount(5);
			tf1.setMaxWidth(100);
			TextField tf2 = new TextField();
			tf2.setPrefColumnCount(5);
			tf2.setMaxWidth(100);
			Label l = new Label();
	        // action event 
	        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
	        	String[] StringArray=new String[0];
	            public void handle(ActionEvent e) 
	            {
	            	String[] tmp = StringArray;
	            	StringArray=new String[tmp.length+1];
	            	for (int i=0;i<tmp.length;i++)
	            		StringArray[i]=tmp[i];
	            	StringArray[tmp.length]=tf1.getText();
	                System.out.println(StringArray[tmp.length]);
	                l.setText(concat(StringArray));
	            } 
	            private String concat(String s[]) {
	            	int length=s.length;
	            	for (int i=0;i<s.length;i++)
	            		length+=s[i].length();
	            	StringBuilder sb=new StringBuilder(length);
	            	for (int i=0;i<s.length;i++) {
	            		sb.append(s[i]);
	            		sb.append('\n');
	            	}
	            	return sb.toString();
	            }
	        };
	        tf1.setOnAction(event);
	        tf2.setOnAction(event);
			root.getChildren().add(tf1);
			root.getChildren().add(l);
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Hello World");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
