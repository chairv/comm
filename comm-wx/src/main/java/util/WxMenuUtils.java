package util;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import http.HttpUtils;
import model.BaseResult;

/**
 * 微信自定义菜单创建
 */
public class WxMenuUtils {
	/**
	 * 发送消息
	 */
	public static BaseResult sendMsg(String params, String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
		Request request = HttpUtils.postJsonRequest(url,params);
		return HttpUtils.execute(request, BaseResult.class);
	}

	/**
	 * 创建菜单
	 */
	public static BaseResult createMenu(String params, String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
		Request request = new Request.Builder().url(url).post(RequestBody.create(HttpUtils.JSON_TYPE, params)).build();
		return HttpUtils.execute(request, BaseResult.class);
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
	public static BaseResult delMenuInfo(String accessToken) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken;
		Request request = new Request.Builder().url(url).build();
		return HttpUtils.execute(request, BaseResult.class);
	}

}