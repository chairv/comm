package util;

import org.apache.commons.lang.ObjectUtils;

/**
 * Created by tancw on 2015/12/31.
 */
public class Utils {

	public static String toStringTrim(Object obj) {
		return ObjectUtils.toString(obj).trim();
	}
}
