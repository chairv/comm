package utils;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URL;

/**
 * Created by tancw on 2016/1/18.
 */
public class LocalHttpClient {
    private static final OkHttpClient client = new OkHttpClient();
    private static final com.squareup.okhttp.MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    public static <T> T executeGetJsonResult(String url, Class<T> clazz) throws IOException {
        URL _url = new URL(url);
        Request request = new Request.Builder().url(_url).build();
        Response response = client.newCall(request).execute();
        return null;
    }
}
