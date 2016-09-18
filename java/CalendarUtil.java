
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lidroid.xutils.util.LogUtils;

public class CalendarUtil {

	public CalendarUtil() {

	}

	private int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		}
		else {
			return 1 - dayOfWeek;
		}
	}

	/**
	 * 获取本周一日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 本周一日期
	 */
	public String getMondayOfWeek(String type) {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		java.util.Date monday = currentDate.getTime();
		SimpleDateFormat format = new SimpleDateFormat(type);
		String preMonday = format.format(monday);

		return preMonday;
	}

	/**
	 * 获取本周日日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 本周日日期
	 */
	public String getSundayOfWeek(String type) {

		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		java.util.Date sunday = currentDate.getTime();
		SimpleDateFormat format = new SimpleDateFormat(type);
		String preSunday = format.format(sunday);

		return preSunday;

	}

	/**
	 * 获取本月第一天日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 本月第一天日期
	 */
	public String getFirstDayOfMonth(String type) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;

	}

	/**
	 * 获取本月最后一天日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 本月最后一天日期
	 */
	public String getLastDayOfMonth(String type) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());

		return str;

	}

	/**
	 * 获取前两个月的第一天日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 前两个月的第一天日期
	 */
	public String getFirstDayOfLastTwoMonth(String type) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -2);// 减2个月，变为前两个月的1号
		str = sdf.format(lastDate.getTime());

		return str;

	}

	/**
	 * 获取前五个月的第一天日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 前五个月的第一天日期
	 */
	public String getFirstDayOfLastFiveMonth(String type) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -5);// 减2个月，变为前两个月的1号
		str = sdf.format(lastDate.getTime());

		return str;

	}

	/**
	 * 获取前十一个月的第一天日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 前五个月的第一天日期
	 */
	public String getFirstDayOfLastElevenMonth(String type) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -11);// 减2个月，变为前两个月的1号
		str = sdf.format(lastDate.getTime());

		return str;

	}

	/**
	 * 获取当前日期
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return 当前日期
	 */
	public static String getSystemDate(String type) {
		SimpleDateFormat format = new SimpleDateFormat(type);
		Date date = new Date(System.currentTimeMillis());
		String curdate = format.format(date);
		return curdate;
	}

	/**
	 * 根据传入的时间转换成所需的时间格式
	 * @param millis
	 *            传入时间
	 * @param type
	 *            日期格式 ，如yyyy-MM-dd
	 * @return
	 */
	public String formatDateWithMillis(String millis, String type) {
		SimpleDateFormat format = new SimpleDateFormat(type);
		long ml = Long.valueOf(millis);
		Date date = new Date(ml);
		return format.format(date);
	}
	
	/**
	 * 比较两个日期打大小
	 * @param date1
	 * @param date2
	 * @param type  日期格式 ，如yyyy-MM-dd
	 * @return date1 > date2返回false，date1 < date2返回true
	 */
	public static boolean compareTime(String date1, String date2, String type) {
		SimpleDateFormat formatter = new SimpleDateFormat(type);
		java.util.Date myDate1 = null;
		java.util.Date myDate2 = null;
		try {
			myDate1 = formatter.parse(date1);
			myDate2 = formatter.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time = myDate1.getTime() - myDate2.getTime();
		LogUtils.i("time= " + time);
		if (time > 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
