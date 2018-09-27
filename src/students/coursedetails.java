package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class coursedetails {
    private final StringProperty cid ;
    private final StringProperty cname;
    private final StringProperty did;
    private final StringProperty sid;
    private final StringProperty fid;

    public coursedetails(String Cid,String Cname,String Did,String Sid,String Fid)
    {
        this.cid= new SimpleStringProperty(Cid);
        this.cname= new SimpleStringProperty(Cname);
        this.did= new SimpleStringProperty(Did);
        this.sid= new SimpleStringProperty(Sid);
        this.fid= new SimpleStringProperty(Fid);
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

    public String getCname() {
        return cname.get();
    }

    public StringProperty cnameProperty() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname.set(cname);
    }

    public String getDid() {
        return did.get();
    }

    public StringProperty didProperty() {
        return did;
    }

    public void setDid(String did) {
        this.did.set(did);
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

    public String getFid() {
        return fid.get();
    }

    public StringProperty fidProperty() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid.set(fid);
    }
}
