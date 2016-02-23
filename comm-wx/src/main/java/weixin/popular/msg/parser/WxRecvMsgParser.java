package weixin.popular.msg.parser;

import weixin.popular.msg.recv.WxRecvMsg;

import org.jdom.Document;
import org.jdom.JDOMException;

public interface WxRecvMsgParser {
	 WxRecvMsg parser(Document doc) throws JDOMException;
}
