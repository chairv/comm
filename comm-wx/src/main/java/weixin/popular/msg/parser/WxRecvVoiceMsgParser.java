package weixin.popular.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import weixin.popular.msg.recv.WxRecvMsg;
import weixin.popular.msg.recv.WxRecvVoiceMsg;

public class WxRecvVoiceMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvVoiceMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String event = getElementText(root, "Event");
		String eventKey = getElementText(root, "EventKey");
		
		return new WxRecvVoiceMsg(msg, event,eventKey);
	}

}
