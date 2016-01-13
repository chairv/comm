package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tancw on 2015/9/8.
 */
public class DateUtils {

	public final static String formatDate = "yyyy-MM-dd";
	public final static String formatDateTime = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat simpleDateFormat;

	/**
	 * 将日期转换成string
	 * 
	 * @param date
	 * @return
	 */
	public static String Date2Str(Date date) {
		simpleDateFormat = new SimpleDateFormat(formatDate);
		return simpleDateFormat.format(date);
	}

    /**
     * 将日期时间转换成string
     * @param date
     * @return
     */
	public static String DataTime2Str(Date date) {
		return new SimpleDateFormat(formatDateTime).format(date);
	}

	public static void main(String[] args) {
		System.out.println(DataTime2Str(new Date()));
	}
}
