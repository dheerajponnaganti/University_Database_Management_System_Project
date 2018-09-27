package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentdata {
    private final StringProperty sid;
    private final StringProperty sname;
    private final StringProperty dob;
    private final StringProperty phoneno;
    private final StringProperty age;
    private final StringProperty address;

    public studentdata(String id,String name,String DOB,String phone,String AGE,String Address)
    {
        this.sid= new SimpleStringProperty(id);
        this.sname= new SimpleStringProperty(name);
        this.dob= new SimpleStringProperty(DOB);
        this.age= new SimpleStringProperty(AGE);
        this.phoneno= new SimpleStringProperty(phone);
        this.address= new SimpleStringProperty(Address);
    }

    public String getSid() {
        return sid.get();
    }

    public StringProperty sidProperty() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid.set(sid);
    }

    public String getSname() {
        return sname.get();
    }

    public StringProperty snameProperty() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname.set(sname);
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

    public String getPhoneno() {
        return phoneno.get();
    }

    public StringProperty phonenoProperty() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno.set(phoneno);
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

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
