package dad.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controlador implements Initializable{

		FileAuthService auth= new FileAuthService();
		LdapAuthService ldap= new LdapAuthService();
	
		//Model
	
		StringProperty usuarioProperty = new SimpleStringProperty();
		StringProperty contrasenaProperty = new SimpleStringProperty();
	
		//view
		
		App app= new App();
		
		
	    @FXML
	    private Button accederButton;

	    @FXML
	    private Button cancelarButton;

	    @FXML
	    private PasswordField contrasenaTextField;

	    @FXML
	    private CheckBox ldapCheck;

	    @FXML
	    private TextField nombreTextField;

	    @FXML
	    private VBox view;

	    @FXML
	    void onAcceder(ActionEvent event) throws Exception {
	    	
	    	if(ldapCheck.isSelected()) {
	    		if(ldap.login(usuarioProperty.get(), contrasenaProperty.get())) {
	    			Alert alert = new Alert(AlertType.CONFIRMATION);
	    			alert.setTitle("Iniciar sesión");
	    			alert.setHeaderText("Acceso permitido");
	    			alert.setContentText("Las credenciales de acceso son válidas");
	    			alert.show();
	    		}
	    		else {
	    			Alert alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Iniciar sesión");
	    			alert.setHeaderText("Acceso denegado");
	    			alert.setContentText("El usuario y/o la contraseña no son válidos");
	    			alert.show();
	    		}
	    	}
	    	else {
	    		if(auth.login(usuarioProperty.get(), contrasenaProperty.get())) {
	    			Alert alert = new Alert(AlertType.CONFIRMATION);
	    			alert.setTitle("Iniciar sesión");
	    			alert.setHeaderText("Acceso permitido");
	    			alert.setContentText("Las credenciales de acceso son válidas");
	    			alert.show();
	    		}
	    		else {
	    			Alert alert = new Alert(AlertType.ERROR);
	    			alert.setTitle("Iniciar sesión");
	    			alert.setHeaderText("Acceso denegado");
	    			alert.setContentText("El usuario y/o la contraseña no son válidos");
	    			alert.show();
	    		}
	    	}
	    }

	    @FXML
	    void onCancelar(ActionEvent event) {
	        	App.primaryStage.close();
	    	
	    }

	    
	    public Controlador() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Root.fxml"));
			loader.setController(this);
			loader.load();
		}
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			usuarioProperty.bind(nombreTextField.textProperty());
			contrasenaProperty.bind(contrasenaTextField.textProperty());
		}
	
		public VBox getView() {
			return view;
		}

		public final StringProperty usuarioPropertyProperty() {
			return this.usuarioProperty;
		}
		

		public final String getUsuarioProperty() {
			return this.usuarioPropertyProperty().get();
		}
		

		public final void setUsuarioProperty(final String usuarioProperty) {
			this.usuarioPropertyProperty().set(usuarioProperty);
		}
		

		public final StringProperty contrasenaPropertyProperty() {
			return this.contrasenaProperty;
		}
		

		public final String getContrasenaProperty() {
			return this.contrasenaPropertyProperty().get();
		}
		

		public final void setContrasenaProperty(final String contrasenaProperty) {
			this.contrasenaPropertyProperty().set(contrasenaProperty);
		}
		
		
}
