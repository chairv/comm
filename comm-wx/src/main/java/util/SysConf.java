package util;

import java.util.Properties;

public class SysConf {
	private static Properties properties;

	public static void setProperties(Properties properties) {
		SysConf.properties = properties;
	}

	public static String get(String key) {
		return (String) properties.get(key);
	}
}
