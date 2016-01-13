package msg.parser;

import org.jdom.Document;
import org.jdom.JDOMException;

public interface WxRecvMsgParser {
	msg.recv.WxRecvMsg parser(Document doc) throws JDOMException;
}
