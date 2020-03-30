package entity;

/*
艺术品信息
 */
public class ArtWork {

	private String aw_no;
	private String aw_name;
	private String aw_kind;
	private String aw_price;
	private Boolean aw_sold;

	public String getAw_no() {
		return aw_no;
	}

	public void setAw_no(String aWno) {
		aw_no = aWno;
	}

	public String getAw_name() {
		return aw_name;
	}

	public void setAw_name(String aWname) {
		aw_name = aWname;
	}

	public String getAw_kind() {
		return aw_kind;
	}

	public void setAw_kind(String aWkind) {
		aw_kind = aWkind;
	}

	public String getAw_price() {
		return aw_price;
	}

	public void setAw_price(String aWprice) {
		aw_price = aWprice;
	}

	public Boolean getAw_sold() {
		return aw_sold;
	}

	public void setAw_sold(Boolean aWsold) {
		aw_sold = aWsold;
	}

}
