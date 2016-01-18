package utils;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by tancw on 2015/9/15.
 */
public class HttpUtils {
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");

    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static <T> T getModelResult(String url, Class<T> clazz) throws IOException {
        return JSON.parseObject(get(url), clazz);
    }

    public static <T> T postModelResult(String url, String param, Class<T> clazz) throws IOException {
        return JSON.parseObject(post(url, param), clazz);
    }

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON_TYPE, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String post(String url, MediaType mediaType, String param) throws IOException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, param)).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
