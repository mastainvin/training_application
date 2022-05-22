/*
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * View controller to connect the user
 * @author Vincent Mastain
 * @version 1.0
 * 
 */
@SuppressWarnings("deprecation")
public class ConnectionCtrl implements Observer, Initializable {

	/** The Connection button. */
	@FXML
	private Button ConnectionButton;

	/** The error label. */
	@FXML
	private Label errorLabel;

	/** The password input. */
	@FXML
	private PasswordField passwordInput;

	/** The pseudonym input. */
	@FXML
	private TextField pseudonymInput;

	/** The register. */
	@FXML
	private Hyperlink register;

	/** The user. */
	private User user;

	/**
	 * Initialize.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	/**
	 * Sets the user.
	 *
	 * @param user2 the new user
	 */
	public void setUser(User user2) {
		user = user2;

	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
	}

	/**
	 * Switch to register scene.
	 *
	 * @param event the event
	 */
	@FXML
	void switchToRegister(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/register.fxml"));
			Scene connectionViewScene = loader.load();

			RegisterCtrl registerCtrl = loader.getController();
			registerCtrl.setUser(user);

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(connectionViewScene);
			window.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Valid.
	 *
	 * @param event the event
	 */
	@FXML
	void valid(ActionEvent event) {
		try {
			// We try to connect the user
			User userConnection = DaoFactory.getInstance().getUserDao().authentificate(pseudonymInput.getText(),
					passwordInput.getText());
			try { // We try to get his actual training
				userConnection.setStructure(userConnection.getTrainingSuperSet(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(userConnection),
						DaoFactory.getInstance()));
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) { // We create him if it doesn't exist.
				try {
					userConnection.createOrUpdateTraining(DaoFactory.getInstance());
					userConnection.setStructure(userConnection.getTrainingSuperSet(
							DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(userConnection),
							DaoFactory.getInstance()));
				} catch (EmptyResultsQueryException | InsertDataBaseException e) { // Here is an error that never occur.
					e.printStackTrace();
				}

			}
			user.copy(userConnection);

			try { // Switch to the main scene.
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/application.fxml"));

				ApplicationCtrl applicationCtrl = new ApplicationCtrl(user);
				loader.setController(applicationCtrl);

				Scene applicationView = loader.load();
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(applicationView);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (EmptyResultsQueryException e) { // If we cant the user is incorrect
			errorLabel.setText("Identifiant ou mot de passe incorrect");
		}
	}

}