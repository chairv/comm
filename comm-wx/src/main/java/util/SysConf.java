package util;

import java.util.Properties;

/**
 * Created by qiao on 2016/1/4.
 */
public class SysConf {
    private static Properties properties;

    public static void setProperties(Properties properties) {
        SysConf.properties = properties;
    }

    public static String get(String key) {
        return (String) properties.get(key);
    }
}
