package com.comm.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 缓存服务的帮助类
 * @author XYB
 *
 */
public class CacheUtils {
	private static final Log log = LogFactory.getLog(CacheUtils.class);
	private static MemcachedClient memclient;
	static final int HALF_HOUR=1800;
	static final int ONE_HOUR=3600;
	
	public static void setMemclient(MemcachedClient memclient) {
        CacheUtils.memclient = memclient;
	}
	/**
	 * 往缓存放入数据:如果已存在，不会替换
	 * @param key
	 * @param value
	 * @param exp
	 */
	public static void add(String key,Object value,int exp){
		try {
			memclient.add(key, exp, value);
		} catch  (Exception e) {
			log.error("=====Memcached add error=====");
			e.printStackTrace();
		}
	}
	/**
	 * 删除缓存数据
	 * @param key
	 */
	public static void delete(String key){
		try {
			memclient.delete(key);
		} catch  (Exception e) {
			log.error("=====Memcached add error=====");
			e.printStackTrace();
		}
	}
	/**
	 * 删除缓存数据
	 * @param key
	 */
	public static boolean containsKey(String key){
		try {
			return memclient.get(key)!=null;
		} catch  (Exception e) {
			log.error("=====Memcached add error=====");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 往缓存放入数据:如果已存在，替换为新数据
	 * @param key
	 * @param value
	 * @param exp
	 */
	public static void addOrReplace(String key,Object value,int exp){
		try {
			//元素不存在，新增；已存在，替换
			if(memclient.get(key)!=null) memclient.delete(key);
			add(key, value, exp);
		} catch  (Exception e) {
			log.error("=====Memcached add error=====");
			e.printStackTrace();
		}
	}
	/**
	 * 往缓存放入数据:如果已存在，替换为新数据:缓存一个小时
	 * @param key
	 * @param value
	 */
	public static void addOrReplace(String key,Object value){
		addOrReplace(key, value, ONE_HOUR);
	}
	/**
	 * 从缓存中提取数据
	 * @param key
	 * @return
	 */
	public static Object get(String key){
		try {
			return memclient.get(key);
		} catch  (Exception e) {
			log.error("=====Memcached add error=====");
			e.printStackTrace();
		}
		return null;
	}
	
}
