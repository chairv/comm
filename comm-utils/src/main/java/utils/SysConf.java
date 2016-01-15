package utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.List;

public class SysConf {
	private static Configuration configuration;

	static {
		try {
			configuration = new PropertiesConfiguration("SysConf.properties");

		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return configuration.getString(key);
	}

	public static float getFloat(String key) {
		return configuration.getFloat(key);
	}

	public static List<Object> getList(String key) {
		return configuration.getList(key);
	}
}
