package Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import dbUtil.dbConnection;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private TextField sid;
    @FXML
    private TextField sname;
    @FXML
    private TextField phoneno;
    @FXML
    private TextField address;
    @FXML
    private TextField age;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField fname;
    @FXML
    private TextField gender;
    @FXML
    private TextField Fid;
    @FXML
    private TextField salary;
    @FXML
    private TextField Cid;
    @FXML
    private TextField Age;
    @FXML
    private DatePicker Dob;
    @FXML
    private TextField CID;
    @FXML
    private TextField CNAME;
    @FXML
    private TextField DID;
    @FXML
    private TextField SID;
    @FXML
    private TextField FID;
    @FXML
    private TableView<studentdata> studenttable;
    @FXML
    private TableColumn<studentdata,String> sidcolumn;
    @FXML
    private TableColumn<studentdata,String> snamecolumn;
    @FXML
    private TableColumn<studentdata,String> phonenocolumn;
    @FXML
    private TableColumn<studentdata,String> addresscolumn;
    @FXML
    private TableColumn<studentdata,String> agecolumn;
    @FXML
    private TableColumn<studentdata,String> dobcolumn;
    @FXML
    private TableView<facultydata> facultytable;
    @FXML
    private TableColumn<facultydata,String> fnamecolumn;
    @FXML
    private TableColumn<facultydata,String> gendercolumn;
    @FXML
    private TableColumn<facultydata,String> Fidcolumn;
    @FXML
    private TableColumn<facultydata,String> salarycolumn;
    @FXML
    private TableColumn<facultydata,String> Cidcolumn;
    @FXML
    private TableColumn<facultydata,String> Agecolumn;
    @FXML
    private TableColumn<facultydata,String> Dobcolumn;
    @FXML
    private TableView<coursedata> coursetable;
    @FXML
    private TableColumn<coursedata, String> cidcolumn;
    @FXML
    private TableColumn<coursedata, String> cnamecolumn;
    @FXML
    private TableColumn<coursedata, String> didcolumn;
    @FXML
    private TableColumn<coursedata, String> Sidcolumn;
    @FXML
    private TableColumn<coursedata, String> fidcolumn;

    private dbConnection dc;
    private ObservableList<studentdata> data;
    private String sql= "SELECT * FROM STUDENT";
    private ObservableList<facultydata> Data;
    private String Sql= "SELECT * FROM FACULTY";
    private ObservableList<coursedata> DATA;
    private String SQL= "SELECT * FROM COURSE";
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.dc = new dbConnection();

    }
    @FXML
    private void loadStudentData(ActionEvent event) throws SQLException
    {
        try {

                Connection conn =dbConnection.getconnection();
                this.data = FXCollections.observableArrayList();
                ResultSet rs = conn.createStatement().executeQuery(sql);
                while (rs.next())
                {
                    this.data.add(new studentdata(rs.getString(4),rs.getString(1),rs.getString(6),rs.getString(3),rs.getString(5),rs.getString(2)));

                }
            }
            catch (SQLException e)
            {
                System.err.println("error: "+ e);
        }
        this.snamecolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("sname"));
        this.addresscolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("address"));
        this.phonenocolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("phoneno"));
        this.agecolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("age"));
        this.sidcolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("sid"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<studentdata,String>("dob"));
        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }
    @FXML
    private void addStudent(ActionEvent event)
    {
        String sqlInsert = "INSERT INTO student(sname,address,phno,sid,age,dob) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = dbConnection.getconnection();
            PreparedStatement stmt= conn.prepareStatement(sqlInsert);
            stmt.setString(1,this.sname.getText());
            stmt.setString(2,this.address.getText());
            stmt.setString(3,this.phoneno.getText());
            stmt.setString(4,this.sid.getText());
            stmt.setString(5,this.age.getText());
            stmt.setString(6,this.dob.getEditor().getText());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cloarForm(ActionEvent event)
    {
        this.sid.setText("");
        this.age.setText("");
        this.address.setText("");
        this.sname.setText("");
        this.phoneno.setText("");
        this.dob.setValue(null);
        this.fname.setText("");
        this.gender.setText("");
        this.Fid.setText("");
        this.salary.setText("");
        this.Cid.setText("");
        this.Age.setText("");
        this.Dob.setValue(null);
        this.CID.setText("");
        this.CNAME.setText("");
        this.DID.setText("");
        this.SID.setText("");
        this.FID.setText("");

    }
    @FXML
    private void loadFacultydetails(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getconnection();
            this.Data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(Sql);
            while (rs.next()) {
                this.Data.add(new facultydata(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));

            }
        } catch (SQLException e) {
            System.err.println("error: " + e);
        }
        this.fnamecolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("fname"));
        this.gendercolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("gender"));
        this.Fidcolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("fid"));
        this.salarycolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("salary"));
        this.Cidcolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("cid"));
        this.Agecolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("age"));
        this.Dobcolumn.setCellValueFactory(new PropertyValueFactory<facultydata, String>("dob"));
        this.facultytable.setItems(null);
        this.facultytable.setItems(this.Data);
    }
    @FXML
    private void addFaculty(ActionEvent event)
    {
        String sqlInsert = "INSERT INTO FACULTY VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = dbConnection.getconnection();
            PreparedStatement stmt= conn.prepareStatement(sqlInsert);
            stmt.setString(1,this.fname.getText());
            stmt.setString(2,this.gender.getText());
            stmt.setString(3,this.Fid.getText());
            stmt.setString(4,this.salary.getText());
            stmt.setString(5,this.Cid.getText());
            stmt.setString(6,this.Age.getText());
            stmt.setString(7,this.Dob.getEditor().getText());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addCourse(ActionEvent event)
    {
        String sqlInsert = "INSERT INTO COURSE VALUES (?,?,?,?,?)";
        try {
            Connection conn = dbConnection.getconnection();
            PreparedStatement stmt= conn.prepareStatement(sqlInsert);
            stmt.setString(1,this.CID.getText());
            stmt.setString(2,this.CNAME.getText());
            stmt.setString(3,this.DID.getText());
            stmt.setString(4,this.SID.getText());
            stmt.setString(5,this.FID.getText());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loadCourses(ActionEvent event) throws SQLException {
        try {

            Connection conn = dbConnection.getconnection();
            this.DATA = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
                this.DATA.add(new coursedata(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
        } catch (SQLException e) {
            System.err.println("error: " + e);
        }
        this.cidcolumn.setCellValueFactory(new PropertyValueFactory<coursedata, String>("cid"));
        this.cnamecolumn.setCellValueFactory(new PropertyValueFactory<coursedata, String>("cname"));
        this.didcolumn.setCellValueFactory(new PropertyValueFactory<coursedata, String>("did"));
        this.Sidcolumn.setCellValueFactory(new PropertyValueFactory<coursedata, String>("sid"));
        this.fidcolumn.setCellValueFactory(new PropertyValueFactory<coursedata, String>("fid"));

        this.coursetable.setItems(null);
        this.coursetable.setItems(this.DATA);
    }
}
