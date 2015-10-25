package Server;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class GameServer extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Titel setzen
		primaryStage.setTitle("Server starten");
		
		//Labels
		Label lbServerStarten = new Label("Server starten");
		lbServerStarten.setTextFill(Color.RED);
		Label lbPortEingeben = new Label("Port eingeben");
		Label lbStatus = new Label ("Server Status:");
				
				
		//Button
		Button btServerStarten = new Button("Server Starten");
				
		//TextEinghabe
		TextField tfPort = new TextField();
		
		
		//Container erstellen
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 20, 20, 10));
		vBox.setSpacing(20);
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 20, 20, 10));
		hBox.setSpacing(20);
		//Zwei Elemente: Label und TextField
		hBox.getChildren().addAll(lbPortEingeben, tfPort);
		
		
		
		//Container befüllen
		vBox.getChildren().add(lbServerStarten);
		vBox.getChildren().add(hBox);
		vBox.getChildren().add(btServerStarten);
		vBox.getChildren().add(lbStatus); 
		//hier noch den Status anzeigen: offline o. online
		
		
		
		//Scene erstellen und anzeigen
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
		
		public static void main(String[] args) {
			launch(args);
		}
			
	}
	
