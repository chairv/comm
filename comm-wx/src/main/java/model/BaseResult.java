package model;

/**
 * Created by tancw on 2016/1/19.
 */
public class BaseResult {
	public static final String SUCCESS_CODE = "0";
	private String errocde;
	private String errmsg;

	public String getErrocde() {
		return errocde;
	}

	public void setErrocde(String errocde) {
		this.errocde = errocde;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "BaseResult{" + "errocde='" + errocde + '\'' + ", errmsg='" + errmsg + '\'' + '}';
	}
}
