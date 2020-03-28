package entity;

/*
展会信息
 */
public class ExhibitionInformation {

    private String e_id;
    private String e_name;
    private String a_id;
    private String aw_id;
    private String t_name;
    private String address;
    private String time;
    private String kind;
    //private String price;

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String b_id) {
        this.a_id = b_id;
    }

    public String getAw_id() {
        return aw_id;
    }

    public void setAw_id(String t_id) {
        this.aw_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

}
