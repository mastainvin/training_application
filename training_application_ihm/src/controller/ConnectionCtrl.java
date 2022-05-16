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
import javafx.scene.Parent;
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

@SuppressWarnings("deprecation")
public class ConnectionCtrl implements Observer, Initializable{
	private User user;
	
    @FXML
    private Button ConnectionButton;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField pseudonymInput;

    @FXML
    private Hyperlink register;


    @FXML
    void valid(ActionEvent event) {
    	try {
    		User userConnection = DaoFactory.getInstance().getUserDao().authentificate(pseudonymInput.getText(), passwordInput.getText());
			try {
				userConnection.setStructure(userConnection.getTraining(
						 DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(userConnection), DaoFactory.getInstance()));
			} catch (InsertDataBaseException e1) {
				try {
					userConnection.createOrUpdateTraining(DaoFactory.getInstance());
					userConnection.setStructure(userConnection.getTraining(
							DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(userConnection), DaoFactory.getInstance()));
				} catch (InsertDataBaseException e) {
					e.printStackTrace();
				}

			}
			user.copy(userConnection); 

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/application.fxml"));
				
				ApplicationCtrl applicationCtrl = new ApplicationCtrl(user);
				loader.setController(applicationCtrl);
				
				Scene applicationView = loader.load();
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(applicationView);
				window.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (EmptyResultsQueryException e) {
			errorLabel.setText("Identifiant ou mot de passe incorrect");
		}
    }
    
    @FXML
    void switchToRegister(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/register.fxml"));
			Scene connectionViewScene = loader.load();
			
			RegisterCtrl registerCtrl = loader.getController();
			registerCtrl.setUser(user);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			window.setScene(connectionViewScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void update(Observable o, Object arg) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setUser(User user2) {
		user = user2;
		
	}

}