package weixin.popular.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import weixin.popular.msg.recv.WxRecvMsg;
import weixin.popular.msg.recv.WxRecvPicMsg;

public class WxRecvPicMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvPicMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvPicMsg(msg, getElementText(root, "PicUrl"));
	}

}
