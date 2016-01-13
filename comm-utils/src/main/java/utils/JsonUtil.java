package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    private JsonUtil() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    public static JSONObject parseObject(String json) {
        return (JSONObject) parseObject(json, JSONObject.class);
    }
}
