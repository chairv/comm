package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import java.util.List;

public class SysConf {
	private static PropertiesConfiguration configuration;

	static {
		try {
			configuration = new PropertiesConfiguration("SysConfAll.properties");
			configuration.setReloadingStrategy(new FileChangedReloadingStrategy()); // 当文件变更时,刷新
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
