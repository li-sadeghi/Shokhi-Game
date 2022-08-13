package GuiController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;

public class LoginGUI {
    @FXML
    Button StartButton ;
    @FXML
    TextField Player1NameField ;
    @FXML
    TextField Player2NameField ;





    Stage stage  = new Stage() ;
    public void Start(ActionEvent actionEvent) {


        try {
            stage = (Stage) ((((Node)(actionEvent.getSource())).getScene()).getWindow());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Game.fxml")) ;
            Parent root = loader.load();
            GameGUI gameGUI = loader.getController() ;

            gameGUI.setName1(Player1NameField.getText());
            gameGUI.setName2(Player2NameField.getText()) ;

            Scene scene = new Scene(root) ;
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public void startByEnter(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            try {
                stage = (Stage) ((((Node)(keyEvent.getSource())).getScene()).getWindow());
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Game.fxml")) ;
                Parent root = loader.load();
                GameGUI gameGUI = loader.getController() ;

                gameGUI.setName1(Player1NameField.getText());
                gameGUI.setName2(Player2NameField.getText()) ;

                Scene scene = new Scene(root) ;
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
