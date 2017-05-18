/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import modal.*;
import services.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author slim
 */
public class InterfaceModifNomController implements Initializable {
        private PasswordField mdpLabel;
    UserServices usr=new UserServices();
    @FXML
    private TextField nomTF;
    @FXML
    private PasswordField mdpTF;
    @FXML
    private PasswordField mdp1TF;

    /**
     *  the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modificationTerminée(ActionEvent event) throws SQLException {
        String mdp=mdpTF.getText();
        String mdp1=mdp1TF.getText();
        String nom=nomTF.getText();
        if(usr.VerifierMotPasse(mdp) && usr.VerifierMotPasse(mdp1)){
            usr.modifierNom(nom);
            Stage stagex = (Stage) nomTF.getScene().getWindow();
            stagex.close();
            Alerte.display("Modification nom avec succés", "Votre nom a été modifié avec succés !");
            
            //retour a l'interface accueil
        } else {
            Alerte.display("Erreur", "Veuillez verifier votre mot de passe");
        }
    }
    
}
