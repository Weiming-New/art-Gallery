package entity;

/*
展厅预约信息
 */
public class HallReserveInformation {

    private String r_no;
    private String h_no;
    private String a_no;
    private String r_time;
    private String r_num;

    public String getR_no() {
        return r_no;
    }

    public void setR_no(String r_no) {
        this.r_no = r_no;
    }

    public String getH_no() {
        return h_no;
    }

    public void setH_no(String h_no) {
        this.h_no = h_no;
    }

    public String getA_no() {
        return a_no;
    }

    public void setA_no(String b_no) {
        this.a_no = b_no;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String time) {
        this.r_time = time;
    }

    public String getR_num() {
        return r_num;
    }

    public void setR_num(String num) {
        this.r_num = num;
    }
}
