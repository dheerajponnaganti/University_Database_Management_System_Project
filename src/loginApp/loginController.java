package loginApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    LoginModel loginModel = new LoginModel();

@FXML
private Text dbstatus;
@FXML
private TextField username;
@FXML
private PasswordField password;
@FXML
private ComboBox combobox;
@FXML
private Button login;
@FXML
private Text loginstatus;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (this.loginModel.isDatabaseConnected())
        {
            this.dbstatus.setText("Connected");
        }
        else
        {
            this.dbstatus.setText("Not Connected");
        }
        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }
    @FXML
    public void Login(ActionEvent event)
    {
        try
        {
            if (this.loginModel.isLogin(this.username.getText(),this.password.getText(),this.combobox.getValue().toString()))
            {
                Stage stage= (Stage) this.login.getScene().getWindow();
                stage.close();
                switch (this.combobox.getValue().toString())
                {
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":
                        studentLogin();
                        break;
                }
            }
            else
            {
                this.loginstatus.setText("Wrong Credentials!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void studentLogin() {
        try
        {
            Stage userstage = new Stage();
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/students/studentsFXML.fxml"));
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setResizable(false);
            userstage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adminLogin(){
        try
        {
            Stage adminstage = new Stage();
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/Admin/admin.fxml"));
            Scene scene = new Scene(root);
            adminstage.setScene(scene);
            adminstage.setResizable(false);
            adminstage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

