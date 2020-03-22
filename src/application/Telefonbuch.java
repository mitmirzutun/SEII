package application;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class Telefonbuch extends Application {
	public void start(Stage primaryStage) {
		try {
			
			StackPane root = new StackPane();
			TextField tf = new TextField();
			tf.setPrefColumnCount(5);
			tf.setMaxWidth(100);
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
	            	StringArray[tmp.length]=tf.getText();
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
	        tf.setOnAction(event);
			root.getChildren().add(tf);
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
