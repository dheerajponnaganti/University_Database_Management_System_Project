package loginApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class login extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResourceAsStream("a.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("University Database Management System");
        stage.show();
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
