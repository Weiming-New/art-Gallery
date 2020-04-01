package entity;

/*
艺术品采购信息
 */
public class Trade {

	private String ti_no;
	private String ti_name;
	private String aw_no;
	private String ti_time;

	public String getTi_no() {
		return ti_no;
	}

	public void setTi_no(String ti_no) {
		this.ti_no = ti_no;
	}

	public String getTi_name() {
		return ti_name;
	}

	public void setTi_name(String ti_name) {
		this.ti_name = ti_name;
	}

	public String getAw_no() {
		return aw_no;
	}

	public void setAw_no(String aw_no) {
		this.aw_no = aw_no;
	}

	public String getTi_time() {
		return ti_time;
	}

	public void setTi_time(String ti_time) {
		this.ti_time = ti_time;
	}
}
