package weixin.popular.msg.send;


public class WxMoreCustomerMsg extends WxSendMsg {

	public WxMoreCustomerMsg(WxSendMsg msg) {
		super(msg);
		setMsgType("transfer_customer_service");
	}

}
