/*
 * 
 */
package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.Disponibility;
import model.objects.Equipment;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * Make the user register him self. By chosing a pseudonym and a password.
 */
public class RegisterCtrl {

	/** The connection. */
	@FXML
	private Hyperlink connection;

	/** The error label. */
	@FXML
	private Label errorLabel;

	/** The pseudonym input. */
	@FXML
	private TextField pseudonymInput;

	/** The pwd input. */
	@FXML
	private PasswordField pwdInput;

	/** The Register button. */
	@FXML
	private Button RegisterButton;

	/** The repeat pwd input. */
	@FXML
	private PasswordField repeatPwdInput;

	/** The user. */
	private User user;

	/**
	 * Sets the user.
	 *
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Switch to connection.
	 *
	 * @param event the event
	 */
	@FXML
	void switchToConnection(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/connection.fxml"));
			Scene connectionViewScene = loader.load();

			ConnectionCtrl connectionCtrl = loader.getController();
			connectionCtrl.setUser(user);

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
		if (pseudonymInput.getText() == "" || pwdInput.getText() == "" || repeatPwdInput.getText() == "") {
			errorLabel.setText("Veuillez tout remplir."); 
		} else if (pwdInput.getText().equals(repeatPwdInput.getText())) { // The passwords have to be the same.

			user.setPseudonym(pseudonymInput.getText());
			user.setPasswordEncrypted(pwdInput.getText());

			// Set the basic Role.
			try {
				user.setIdRole(DaoFactory.getInstance().getRoleDao().getRoleByName("user").getIdRole());
			} catch (EmptyResultsQueryException e1) {
				e1.printStackTrace();
			}

			// -- Chosing the basic parameters for the user (normaly the user have to chose them
			try {
				user.setIdMorphology(DaoFactory.getInstance().getMorphologyDao().getMorphologyByName("longiligne")
						.getIdMorphology());
				user.setIdGoal(DaoFactory.getInstance().getGoalDao().getGoalByName("force").getIdGoal());
				user.setEmail(user.getPseudonym() + "@" + user.getPseudonym());
				DaoFactory.getInstance().getUserDao().addUser(user); // Add the user to the db.
				user.copy(DaoFactory.getInstance().getUserDao().getUserByPseudonym(pseudonymInput.getText()));

				List<Equipment> allEquipments = DaoFactory.getInstance().getEquipmentDao().getAllEquipment();

				for (Equipment equipment : allEquipments) {
					DaoFactory.getInstance().getHasEquipmentDao().addCompatibleEquipment(user.getIdUser(),
							equipment.getIdEquipment());
				}

				Disponibility firstDisponibility = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(120,
						1);
				Disponibility secondDisponibility = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(90,
						2);

				DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),
						firstDisponibility.getIdDisponibility());
				DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),
						secondDisponibility.getIdDisponibility());

				// We create his training
				user.createOrUpdateTraining(DaoFactory.getInstance());
				user.setStructure(user.getTrainingSuperSet(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance()));

				try { // Go the main scene.
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

			} catch (InsertDataBaseException | EmptyResultsQueryException e) {
				errorLabel.setText("Pseudonyme déjà pris.");
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			}
		} else {
			errorLabel.setText("Les mots de passe de correspondent pas.");
		}
	}

}
