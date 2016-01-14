package msg.parser;

import msg.recv.WxRecvMsg;

import org.jdom.Document;
import org.jdom.JDOMException;

public interface WxRecvMsgParser {
	 WxRecvMsg parser(Document doc) throws JDOMException;
}
