package Client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameClient extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("King of Tokyo: Spiel starten");
		
		//Label
		Label lbSpielername = new Label("Spielername");
		Label lbPort = new Label("Port eingeben:");
		
		//Button
		Button btStart = new Button("Verbinden");
		
		//TextField
		TextField tfSpielername = new TextField();
		TextField tfPort = new TextField();
		
		
		//Container erstellen
		VBox mainContainer = new VBox();
		mainContainer.setPadding(new Insets(10, 20, 20, 10));
		mainContainer.setSpacing(20);
		
		HBox boxName = new HBox();
		boxName.setPadding(new Insets(10, 20, 20, 10));
		boxName.setSpacing(20);
		
		HBox boxPort = new HBox();
		boxPort.setPadding(new Insets(10, 20, 20, 10));
		boxPort.setSpacing(20);
		
		
		
		//Container befüllen
		
		boxName.getChildren().addAll(lbSpielername, tfSpielername);
		boxPort.getChildren().addAll(lbPort, tfPort);
		
		mainContainer.getChildren().addAll(boxName, boxPort, btStart);
		
		//Scene erstellen und anzeigen
		Scene scene = new Scene(mainContainer);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
		public static void main(String[] args) {
			launch(args);
		
	}

}
