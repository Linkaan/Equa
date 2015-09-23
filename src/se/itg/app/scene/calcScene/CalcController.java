package se.itg.app.scene.calcScene;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import se.itg.app.controller.Controller;
import se.itg.parse.Parser;

public class CalcController implements Controller<CalcControllerData>, Initializable{

	private CalcControllerData data;
	
	@FXML
	public TextField equation;
	
	@FXML
	public Label answer;
	
	public void solve(){
		answer.setText("" + Parser.calculate(equation.getText()));
	}
	
	@Override
	public void show () {
		equation.requestFocus();
	}

	@Override
	public void hide () {
		
	}

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		equation.textProperty().addListener((ChangeListener<String>) (observable, oldValue, aewValuerg2) -> {
			
		});
	}
	
	@Override
	public void setData (CalcControllerData data) {
		this.data = data;
	}

	@Override
	public CalcControllerData getData () {
		return data;
	}
}
