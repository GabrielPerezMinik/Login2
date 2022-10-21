package dad.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controlador implements Initializable{

		//Model
	
		StringProperty usarioProperty = new SimpleStringProperty();
		StringProperty contrasenaProperty = new SimpleStringProperty();
	
		//view
		
		Stage primaryStage = new Stage();
		
	    @FXML
	    private Button accederButton;

	    @FXML
	    private Button cancelarButton;

	    @FXML
	    private TextField contrasenaTextField;

	    @FXML
	    private CheckBox ldapCheck;

	    @FXML
	    private TextField nombreTextField;

	    @FXML
	    private VBox view;

	    @FXML
	    void onAcceder(ActionEvent event) {

	    }

	    @FXML
	    void onCancelar(ActionEvent event) {

	    	primaryStage.close();
	    	
	    }

	    public Controlador() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Root.fxml"));
			loader.setController(this);
			loader.load();
		}
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
		}
	
		public VBox getView() {
			return view;
		}
		
}
