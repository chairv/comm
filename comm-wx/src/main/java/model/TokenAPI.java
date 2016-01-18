package model;

import utils.LocalHttpClient;
import api.BaseAPI;

/**
 * Created by tancw on 2016/1/18.
 */
public class TokenAPI extends BaseAPI {

	public static AccessToken getToken(String appid, String appsecret) {
		String url = BASE_URI + "/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
		return LocalHttpClient.executeGetJsonResult(url, AccessToken.class);
	}
}
