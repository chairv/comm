package utils;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.URL;

/**
 * Created by tancw on 2015/9/15.
 */
public class HttpUtils {
    private static final OkHttpClient client = new OkHttpClient();
    private static final com.squareup.okhttp.MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    private static final com.squareup.okhttp.MediaType MT2 = MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8");

    public static String get(String urltr) throws IOException {
        URL url = new URL(urltr);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        }
        return "";
    }

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static JSONObject postJson(String url, String json) throws IOException {
        return JsonUtil.parseObject(post(url, json));
    }

    public static String post(String url, MediaType mediaType, String param) throws IOException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, param)).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18028786323";
        System.out.println(post(url,JSON, ""));
    }
}
