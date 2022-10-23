package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	
	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage=primaryStage;
		
		Controlador control= new Controlador();
		primaryStage.setTitle("login");
		primaryStage.setScene(new Scene(control.getView()));
		primaryStage.show();
		
	}

	public static void main(String args[]) {
		
		launch(args);
		
	}
	
}
