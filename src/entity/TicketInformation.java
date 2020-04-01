package entity;

/*
门票预定信息
 */
public class TicketInformation {

    private String t_no;
    private String t_name;
    private String t_sex;
    private String t_work;
    private String e_no;
    private String t_price;

    public String getT_no() {
        return t_no;
    }

    public void setT_no(String t_no) {
        this.t_no = t_no;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_work() {
        return t_work;
    }

    public void setT_work(String t_work) {
        this.t_work = t_work;
    }

    public String getE_no() {
        return e_no;
    }

    public void setE_no(String e_no) {
        this.e_no = e_no;
    }

    public String getT_price() {
        return t_price;
    }

    public void setT_price(String t_price) {
        this.t_price = t_price;
    }
}
