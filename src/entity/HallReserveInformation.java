package entity;

/*
展厅预约信息
 */
public class HallReserveInformation {

    private String r_id;
    private String h_id;
    private String a_id;
    private String a_name;
    private String time;
    private String num;

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String geth_id() {
        return h_id;
    }

    public void seth_id(String h_id) {
        this.h_id = h_id;
    }

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String b_id) {
        this.a_id = b_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String b_name) {
        this.a_name = b_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
