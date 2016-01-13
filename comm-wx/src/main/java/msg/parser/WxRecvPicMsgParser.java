package msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import msg.recv.WxRecvMsg;
import msg.recv.WxRecvPicMsg;

public class WxRecvPicMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvPicMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvPicMsg(msg, getElementText(root, "PicUrl"));
	}

}
