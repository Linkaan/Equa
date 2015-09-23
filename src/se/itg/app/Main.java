
package se.itg.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import se.itg.app.data.Data;
import se.itg.app.main.MainController;
import se.itg.app.scene.centerscene.CenterScene;

public class Main extends Application {

	private static MainController mainController;
	private static Scene mainScene;
	
	private boolean resizebottom = false;
	private double dx, dy;
	private double xOffset, yOffset;


	@Override
	public void start (Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("main/main.fxml"));

		Parent root = loader.load();

		mainScene = new Scene(root);
		mainController = loader.getController();
		openCenterScene(CenterScene.EQUATION_SOLVER_SCENE);

		stage.setResizable(true);
		stage.initStyle(StageStyle.DECORATED);
		stage.setTitle("Equa");
		stage.setScene(mainScene);
		stage.setMinWidth(600);
		stage.setMinHeight(400);
		stage.show();
	}

	public static Scene getMainScene () {
		return mainScene;
	}

	public static void openCenterScene (CenterScene<?> centerScene) {
		openCenterScene(centerScene, null);
	}

	public static <D extends Data> void openCenterScene (CenterScene<?> centerScene, D data) {
		mainController.openCenterScene(centerScene, data);
	}

	public static void main (String[] args) {
		launch(args);
	}

}
