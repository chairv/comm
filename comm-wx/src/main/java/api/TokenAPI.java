package api;

import model.AccessToken;
import http.HttpUtils;

import java.io.IOException;

/**
 * Created by tancw on 2016/1/18.
 */
public class TokenAPI extends BaseAPI {

	public static AccessToken getToken(String appid, String appsecret) throws IOException {
		String url = BASE_URI + "/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
		return HttpUtils.executeGet(url, AccessToken.class);
	}

    public static void main(String[] args) {
        String appid = "wx62aa1895c2c35ffd";
        String appsecret = "e2a12b12d7fe55822cb5186c6ee19f2a";
        try {
            System.out.println(getToken(appid,appsecret));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
