package entity;

/*
艺术品采购信息
 */
public class Trade {

    private String ti_id;
    private String ti_name;
    private String aw_id;
    private String aw_name;
    private String time;
    private String price;

    public String getTi_id() {
        return ti_id;
    }

    public void setTi_id(String s_id) {
        this.ti_id = s_id;
    }

    public String getTi_name() {
        return ti_name;
    }

    public void setTi_name(String s_name) {
        this.ti_name = s_name;
    }

    public String getAw_id() {
        return aw_id;
    }

    public void setAw_id(String t_id) {
        this.aw_id = t_id;
    }

    public String getAw_name() {
        return aw_name;
    }

    public void setAw_name(String t_name) {
        this.aw_name = t_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
