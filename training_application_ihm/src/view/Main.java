package view;

import java.io.IOException;

import controller.ConnectionCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.objects.User;


/**
 * The Class Main, the start of the application.
 */
public class Main extends Application {

	/** The user. */
	private static User user;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Initialize connection.
	 * We lunch the application with the connection scene.
	 * @return the scene
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Scene initializeConnection() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("connection.fxml"));
		Scene root = loader.load();

		ConnectionCtrl connectionCtrl = loader.getController();
		connectionCtrl.setUser(user);

		return root;
	}

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			user = new User();

			Scene root = initializeConnection();

			primaryStage.setScene(root);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
