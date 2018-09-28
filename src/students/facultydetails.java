package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class facultydetails {
    private final StringProperty fname ;
    private final StringProperty fid;
    private final StringProperty cid;
    public facultydetails(String Fname,String Fid,String Cid)
    {
        this.fname= new SimpleStringProperty(Fname);

        this.fid= new SimpleStringProperty(Fid);

        this.cid= new SimpleStringProperty(Cid);

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



    public String getFid() {
        return fid.get();
    }

    public StringProperty fidProperty() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid.set(fid);
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


}
