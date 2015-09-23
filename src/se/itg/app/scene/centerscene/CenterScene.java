package se.itg.app.scene.centerscene;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import se.itg.app.Main;
import se.itg.app.controller.Controller;
import se.itg.app.scene.calcScene.CalcController;
import se.itg.app.scene.calcScene.CalcControllerData;

public class CenterScene<C extends Controller<?>>{

   public CenterScene(String fxmlName) {
       try {
           FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlName));
           node = loader.load();
           controller = loader.getController();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   private Node node;
   private Object controller;

   public Node getNode(){
       return node;
   }

   @SuppressWarnings("unchecked")
	public C getController() {
       return (C)controller;
   }
   
   public static final CenterScene<CalcController> EQUATION_SOLVER_SCENE = new CenterScene<>("scene/calcScene/calc.fxml");
   
}