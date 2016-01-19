package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import msg.parser.WxMsgKit;
import msg.recv.WxRecvMsg;
import msg.send.WxSendMsg;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

import http.HttpUtils;

public final class WeiXinTools {
	// 微信模板消息接口
	private static final String TEMPLATE_URI = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

	public static boolean access(String token, String signature, String timestamp, String nonce) {
		List<String> ss = new ArrayList<String>();
		ss.add(timestamp);
		ss.add(nonce);
		ss.add(token);

		Collections.sort(ss);

		StringBuilder builder = new StringBuilder();
		for (String s : ss) {
			builder.append(s);
		}
		return signature.equalsIgnoreCase(HashKit.sha1(builder.toString()));
	}

	public static WxRecvMsg recv(InputStream in) throws JDOMException, IOException {
		return WxMsgKit.parse(in);
	}

	public static void send(WxSendMsg msg, OutputStream out) throws JDOMException, IOException {
		Document doc = WxMsgKit.parse(msg);
		if (null != doc) {
			new XMLOutputter().output(doc, out);
		} else {
			Logger.getAnonymousLogger().warning("发送消息时,解析出dom为空 msg :" + msg);
		}
	}

	public static WxSendMsg builderSendByRecv(WxRecvMsg msg) {
		WxRecvMsg m = new WxRecvMsg(msg);
		String from = m.getFromUser();
		m.setFromUser(m.getToUser());
		m.setToUser(from);
		m.setCreateDt((System.currentTimeMillis() / 1000) + "");
		return new WxSendMsg(m);
	}

	/**
	 * 推送模板消息
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String sendTemplateMsg(String token, String content) throws Exception {
		return HttpUtils.post(TEMPLATE_URI + token, content);
	}

}
