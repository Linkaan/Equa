package se.itg.app.scene.calcScene;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
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
	
	@Override
	public void show () {
		equation.requestFocus();
	}

	@Override
	public void hide () {
		
	}

	@Override
	public void initialize (URL location, ResourceBundle resources) {
		equation.textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
			updateAnswer(newValue);
			System.out.println(newValue);
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
	
	private void updateAnswer(String equation){
		if(equation.equals("")){
			answer.setText("");
		}
		else{
			answer.setText("" + Parser.calculate(equation));		
		}
	}
}
