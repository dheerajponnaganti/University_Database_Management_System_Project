package students;


import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @FXML
    private TableView<coursedetails> coursetable;
    @FXML
    private TableColumn<coursedetails, String> cidcolumn;
    @FXML
    private TableColumn<coursedetails, String> cnamecolumn;
    @FXML
    private TableColumn<coursedetails, String> didcolumn;
    @FXML
    private TableColumn<coursedetails, String> sidcolumn;
    @FXML
    private TableColumn<coursedetails, String> fidcolumn;
    @FXML
    private TableView<facultydetails> facultytable;
    @FXML
    private TableColumn<facultydetails, String> fnamecolumn;

    @FXML
    private TableColumn<facultydetails, String> Fidcolumn;

    @FXML
    private TableColumn<facultydetails, String> Cidcolumn;

    private dbConnection dc;
    private ObservableList<coursedetails> data;
    private String sql = "SELECT * FROM COURSE";
    private ObservableList<facultydetails> Data;
    private String Sql = "select  FID, FNAME,CID from FACULTY";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.dc = new dbConnection();
    }

    @FXML
    private void loadCoursedetails(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getconnection();
            this.data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new coursedetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
        } catch (SQLException e) {
            System.err.println("error: " + e);
        }
        this.cidcolumn.setCellValueFactory(new PropertyValueFactory<coursedetails, String>("cid"));
        this.cnamecolumn.setCellValueFactory(new PropertyValueFactory<coursedetails, String>("cname"));
        this.didcolumn.setCellValueFactory(new PropertyValueFactory<coursedetails, String>("did"));
        this.sidcolumn.setCellValueFactory(new PropertyValueFactory<coursedetails, String>("sid"));
        this.fidcolumn.setCellValueFactory(new PropertyValueFactory<coursedetails, String>("fid"));
        this.coursetable.setItems(null);
        this.coursetable.setItems(this.data);
    }
    @FXML
    private void loadFacultydetails(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getconnection();
            this.Data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(Sql);
            while (rs.next()) {
                this.Data.add(new facultydetails(rs.getString(2), rs.getString(1), rs.getString(3)));

            }
        } catch (SQLException e) {
            System.err.println("error: " + e);
        }
        this.fnamecolumn.setCellValueFactory(new PropertyValueFactory<facultydetails, String>("fname"));

        this.Fidcolumn.setCellValueFactory(new PropertyValueFactory<facultydetails, String>("fid"));

        this.Cidcolumn.setCellValueFactory(new PropertyValueFactory<facultydetails, String>("cid"));

        this.facultytable.setItems(null);
        this.facultytable.setItems(this.Data);
    }
}
