package weixin.popular.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import weixin.popular.msg.recv.WxRecvMsg;
import weixin.popular.msg.recv.WxRecvTextMsg;

public class WxRecvTextMsgParser extends WxRecvMsgBaseParser{

	@Override
	protected WxRecvTextMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvTextMsg(msg, getElementText(root, "Content"));
	}

	
}
