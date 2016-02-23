package weixin.popular.msg.parser;


import org.jdom.Element;
import org.jdom.JDOMException;

import weixin.popular.msg.recv.WxRecvEventMsg;
import weixin.popular.msg.recv.WxRecvMsg;

public class WxRecvEventMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvEventMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String event = getElementText(root, "Event");
		String eventKey = getElementText(root, "EventKey");
		
		return new WxRecvEventMsg(msg, event,eventKey);
	}

}
