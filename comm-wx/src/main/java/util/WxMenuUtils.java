package util;

import com.alibaba.fastjson.JSONObject;
import utils.HttpUtils;

/**
 * 微信自定义菜单创建
 */
public class WxMenuUtils {
	/**
	 * 发送消息
	 */
	public static String sendMsg(String params, String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
		JSONObject object = HttpUtils.postJson(url, params);
		return object.getString("errmsg");
	}

	/**
	 * 创建菜单
	 */
	public static String createMenu(String params, String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
		JSONObject object = HttpUtils.postJson(url, params);
		return object.getString("errmsg");
	}

	/**
	 * 获取accessToken
	 */
	public static JSONObject getAccessToken(String appid, String secret) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret;
		return JsonUtil.parseObject(HttpUtils.get(url));
	}

	/**
	 * 查询菜单
	 */
	public static String getMenuInfo(String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken;
		return HttpUtils.get(url);
	}

	/**
	 * 删除自定义菜单
	 */
	public static String delMenuInfo(String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken;
		JSONObject object = JsonUtil.parseObject(HttpUtils.get(url));
		return object.getString("errmsg");
	}

}