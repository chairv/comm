package weixin.popular.cons;

import utils.SysConf;

/**
 * Created by tancw on 2016/2/25.
 */
public class BaseCons {
	public static final String APPID = SysConf.get("weixin.appid");
	public static final String APPSECRET = SysConf.get("weixin.appsecret");
	public static final String BASE_URL = SysConf.get("base.path");
	public static final String SESSION_USER = "session_user";
}
