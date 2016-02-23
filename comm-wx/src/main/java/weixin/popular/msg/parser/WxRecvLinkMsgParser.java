package weixin.popular.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import weixin.popular.msg.recv.WxRecvLinkMsg;
import weixin.popular.msg.recv.WxRecvMsg;

public class WxRecvLinkMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvLinkMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		
		String title = getElementText(root, "Title");
		String description = getElementText(root, "Description");
		String url = getElementText(root, "Url");
		return new WxRecvLinkMsg(msg, title, description, url);
	}

}
