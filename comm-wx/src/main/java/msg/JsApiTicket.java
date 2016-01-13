package  msg;

import java.io.Serializable;
import java.util.Date;

public class JsApiTicket implements Serializable {
	private String name;
	private String ticket;  
	private Date create_date=new Date();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	/**
	 * 判断是否失效:2小时内有效:true-有效
	 */
	public boolean isAva(){
		return (System.currentTimeMillis()-this.create_date.getTime() < 3600 * 2 * 1000);
	}
}
