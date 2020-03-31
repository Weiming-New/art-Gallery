package entity;


/*
展厅信息
 */
public class Hall {

    private String h_no;
    private String h_name;
    private String h_area;
    private String h_address;
    private String person_in_charge;
    private String h_num;

    public String getH_no() {
        return h_no;
    }

    public void setH_no(String h_no) {
        this.h_no = h_no;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_area() {
        return h_area;
    }

    public void setH_area(String h_area) {
        this.h_area = h_area;
    }

    public String getH_address() {
        return h_address;
    }

    public void setH_address(String h_address) {
        this.h_address = h_address;
    }

    public String getPerson_in_charge() {
        return person_in_charge;
    }

    public void setPerson_in_charge(String people) {
        this.person_in_charge = people;
    }

    public String getH_num() {
        return h_num;
    }

    public void setH_num(String h_num) {
        this.h_num = h_num;
    }
}
