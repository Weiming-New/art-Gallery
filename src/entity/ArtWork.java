package entity;

/*
展品信息
 */
public class ArtWork {

    private String aw_id;
    private String aw_name;
    private String kind;
    private String price;

    public String getAw_id() {
        return aw_id;
    }

    public void setAw_id(String aw) {
        this.aw_id = aw;
    }

    public String getAw_name() {
        return aw_name;
    }

    public void setAw_name(String aw_name) {
        this.aw_name = aw_name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
