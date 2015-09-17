package se.itg.app;

import se.itg.app.main.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private MainController mainController;
	private Scene mainScene;
	
	@Override
	public void start (Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("main/main.fxml"));
		
		Parent root = loader.load();
		
		mainController = loader.getController();
		
		mainScene = new Scene(root);
		
		stage.setTitle("Equa");
		stage.setScene(mainScene);
		stage.setMinWidth(400);
		stage.setMinHeight(400);
		stage.show();
	}

	public static void main(String[] args){
		launch(args);	 
	}
	
}
