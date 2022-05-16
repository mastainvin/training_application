package view;
	
import java.io.IOException;

import controller.ConnectionCtrl;
import javafx.application.Application;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static User user;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			user = new User();

			Scene root = initializeConnection();
			
			primaryStage.setScene(root);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Scene initializeConnection() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("connection.fxml"));
		Scene root = loader.load();
		    
		ConnectionCtrl connectionCtrl = loader.getController();
		connectionCtrl.setUser(user);
		
		return root;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
