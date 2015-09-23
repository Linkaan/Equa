package se.itg.app.main;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import se.itg.app.controller.Controller;
import se.itg.app.data.Data;
import se.itg.app.scene.centerscene.CenterScene;

public class MainController{

	@FXML
	public BorderPane borderPane;
	
	private CenterScene<?> currentCenterScene = null;
	
	public void openEquationSolverScene(){
		openCenterScene(CenterScene.EQUATION_SOLVER_SCENE, null);
	}
	
	public <D extends Data> void openCenterScene(CenterScene<? extends Controller<?>> centerScene, D data){
		if(currentCenterScene != null){
			currentCenterScene.getController().hide();
		}
		
		currentCenterScene = centerScene;
		
		borderPane.setCenter(centerScene.getNode());
		//currentCenterScene.getController().setData(data);
		currentCenterScene.getController().show();
	}
	
}
