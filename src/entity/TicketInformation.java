package entity;

/*
门票预定信息
 */
public class TicketInformation {

    private String id;
    private String name;
    private String Tsex;
    private String Twork;
    private String e_name;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return Tsex;
    }

    public void setSex(String Tsex) {
        this.Tsex = Tsex;
    }

    public String getWork() {
        return Twork;
    }

    public void setWork(String Twork) {
        this.Twork = Twork;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String m_id) {
        this.e_name = m_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
