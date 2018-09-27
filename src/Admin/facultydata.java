package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class facultydata {
    private final StringProperty fname ;
    private final StringProperty gender;
    private final StringProperty fid;
    private final StringProperty salary;
    private final StringProperty cid;
    private final StringProperty age;
    private final StringProperty dob;
    public facultydata(String Fname,String Gender,String Fid,String Salary,String Cid,String Age,String Dob)
    {
        this.fname= new SimpleStringProperty(Fname);
        this.gender= new SimpleStringProperty(Gender);
        this.fid= new SimpleStringProperty(Fid);
        this.salary= new SimpleStringProperty(Salary);
        this.cid= new SimpleStringProperty(Cid);
        this.age= new SimpleStringProperty(Age);
        this.dob= new SimpleStringProperty(Dob);
    }

    public String getFname() {
        return fname.get();
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getFid() {
        return fid.get();
    }

    public StringProperty fidProperty() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid.set(fid);
    }

    public String getSalary() {
        return salary.get();
    }

    public StringProperty salaryProperty() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    public String getCid() {
        return cid.get();
    }

    public StringProperty cidProperty() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid.set(cid);
    }

    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }
}
