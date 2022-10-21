package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	
	Stage primaryStage = new Stage();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		
		Controlador control= new Controlador();
		control.onCancelar(primaryStage);
		primaryStage.setTitle("login");
		primaryStage.setScene(new Scene(control.getView()));
		primaryStage.show();
		
	}

	public static void main(String args[]) {
		
		launch(args);
		
	}
	
}
