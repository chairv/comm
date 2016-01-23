package api;

import com.squareup.okhttp.Request;
import http.HttpUtils;
import model.BaseResult;

import java.io.IOException;

/**
 * Created by qiao on 2016/1/19.
 */
public class MenuAPI extends BaseAPI {

    /**
     * @param accessToken
     * @param menuJson
     * @return
     * @throws IOException
     */
    public static BaseResult createMenu(String accessToken, String menuJson) throws IOException {
        String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
        Request request = HttpUtils.postJsonRequest(url, menuJson);
        return HttpUtils.execute(request, BaseResult.class);
    }
}
