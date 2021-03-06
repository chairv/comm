package weixin.popular.msg.recv;

public class WxRecvEventMsg extends weixin.popular.msg.recv.WxRecvMsg {

	private String event;
	private String eventKey;

	public WxRecvEventMsg(weixin.popular.msg.recv.WxRecvMsg msg, String event, String eventKey) {
		super(msg);
		this.event = event;
		this.eventKey = eventKey;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
