package entity;

/*
展商信息
 */
public class Artist {

    private String a_no;
    private String a_name;
    private String a_ID;
    private String a_major;
    private String a_workplace;
    private String tel;

    public String getA_no() {
        return a_no;
    }

    public void setA_id(String a_id) {
        this.a_no = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getID() {
        return a_ID;
    }

    public void setID(String ID) {
        this.a_ID = ID;
    }

    public String getMajor() {
        return a_major;
    }

    public void setMajor(String work) {
        this.a_major = work;
    }

    public String getWorkplace() {
        return a_workplace;
    }

    public void setWorkplace(String workplace) {
        this.a_workplace = workplace;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
