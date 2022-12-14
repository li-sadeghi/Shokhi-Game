import GuiController.GameGUI;
import GuiController.LoginGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.Scanner;

public class GuiMain extends Application {


    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml")) ;
        Parent root = loader.load() ;
        Scene scene = new Scene(root) ;
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
