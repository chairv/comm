package http;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by tancw on 2015/9/15.
 */
public class HttpUtils {
    private static final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");

    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        return execute(request).body().string();
    }

    public static <T> T executeGet(String url, Class<T> clazz) throws IOException {
        return JSON.parseObject(get(url), clazz);
    }

    public static <T> T execute(Request request, Class<T> clazz) throws IOException {
        return JSON.parseObject(execute(request).body().string(), clazz);
    }

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON_TYPE, json);
        Request request = new Request.Builder().url(url).post(body).build();
        return execute(request).body().string();
    }

    public static Response execute(Request request) throws IOException {
        return client.newCall(request).execute();
    }

    public static String post(String url, MediaType mediaType, String param) throws IOException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, param)).build();
        return execute(request).body().string();
    }

    public static Request postJsonRequest(String url, String menuJson) {
        return new Request.Builder().url(url).post(RequestBody.create(JSON_TYPE, menuJson)).build();
    }
}
