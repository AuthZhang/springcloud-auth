//package com.auth.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.*;
//
///**
// * 日期工具类
// * 使用DateTimeFormatter,LocalDate等线程安全的类格式化日期
// *
// */
//public class DateUtil {
//	/** yyyyMMdd */
//	public static final String YMD = "yyyyMMdd";
//
//	/** yyyyMM */
//	public static final String YM = "yyyyMMd";
//	/** yyyy/MM/dd */
//	public static final String YMD_SLASH = "yyyy/MM/dd";
//	/** yyyy-MM-dd */
//	public static final String YMD_DASH = "yyyy-MM-dd";
//	/** yyyy-MM-dd H:m */
//	public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
//	/** yyyyMMddHHmmss */
//	public static final String YMD_DASH_WITH_TIME_Simple = "yyyyMMddHHmmss";
//
//
//    /** yyyyMMddHHmmss */
//    public static final String YMD_DASH_WITH_TIME_SLANT = "yyyy/MM/dd/HH/mm/ss";
//	/** yyyy/dd/MM */
//	public static final String YDM_SLASH = "yyyy/dd/MM";
//	/** yyyy-dd-MM */
//	public static final String YDM_DASH = "yyyy-dd-MM";
//	/** HHmm */
//	public static final String HM = "HHmm";
//	/** HH:mm */
//	public static final String HM_COLON = "HH:mm";
//	/** 24 * 60 * 60 * 1000L */
//	public static final long DAY = 24 * 60 * 60 * 1000L;
//
//	/** 24 * 60 * 60 * 1000L */
//	public static final long HOUR = 60 * 60 * 1000L;
//
//	/** 1000L */
//	public static final long SECOND = 1000L;
//
//	private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
//
//	/**
//	 * 多线程场景下，每个线程创建自己的SimpleDateFormat对象，防止出现java.lang.NumberFormatException: multiple points问题
//	 */
//	private static final ThreadLocal<SimpleDateFormat> threadLocalSimpleDateFormat = new ThreadLocal<SimpleDateFormat>();
//
//	private DateUtil() {
//	}
//
//
//	public static Date parse(String source, String pattern) {
//		if (source == null) {
//			return null;
//		}
//		Date date;
//		try {
//			DateFormat format = new SimpleDateFormat(pattern);
//			date = format.parse(source);
//		} catch (ParseException e) {
//			if (LOGGER.isDebugEnabled()) {
//				LOGGER.debug(source + " doesn't match " + pattern);
//			}
//			return null;
//		}
//		return date;
//	}
//
//	/**
//	 * 根据传入的pattern格式化日期
//	 *
//	 * @param localDateTime
//	 * @param pattern
//	 * @return
//	 */
//	public static String format(LocalDateTime localDateTime, String pattern) {
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//		if (localDateTime == null) {
//			return null;
//		}
//		return localDateTime.format(dateTimeFormatter);
//	}
//
//	/**
//	 * 校验是否为时间
//	 */
//	public  static  boolean checkIsDate(String str) {
//		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");//括号内为日期格式，y代表年份，M代表年份中的月份（为避免与小时中的分钟数m冲突，此处用M），d代表月份中的天数
//		try {
//			sd.setLenient(false);//此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
//			sd.parse(str);//从给定字符串的开始解析文本，以生成一个日期
//		}
//		catch (Exception e) {
//			return false;
//		}
//		return true;
//	}
//
//
//	/**
//	 * @param year
//	 *            年
//	 * @param month
//	 *            月(1-12)
//	 * @param day
//	 *            日(1-31)
//	 * @return 输入的年、月、日是否是有效日期
//	 */
//	public static boolean isValid(int year, int month, int day) {
//		if (month > 0 && month < 13 && day > 0 && day < 32) {
//			// month of calendar is 0-based
//			int mon = month - 1;
//			Calendar calendar = new GregorianCalendar(year, mon, day);
//			if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == mon
//					&& calendar.get(Calendar.DAY_OF_MONTH) == day) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private static Calendar convert(Date date) {
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTime(date);
//		return calendar;
//	}
//
//	/**
//	 * 返回指定年数位移后的日期
//	 */
//	public static Date yearOffset(Date date, int offset) {
//		return offsetDate(date, Calendar.YEAR, offset);
//	}
//
//	/**
//	 * 返回指定月数位移后的日期
//	 */
//	public static Date monthOffset(Date date, int offset) {
//		return offsetDate(date, Calendar.MONTH, offset);
//	}
//
//	/**
//	 * 返回指定天数位移后的日期
//	 */
//	public static Date dayOffset(Date date, int offset) {
//		return offsetDate(date, Calendar.DATE, offset);
//	}
//
//	/**
//	 * 返回指定天数位移后的日期
//	 */
//	public static Date hourOffset(Date date, int offset) {
//		Calendar calendar = convert(date);
//		calendar.add(Calendar.HOUR, offset); //减填负数
//		return calendar.getTime();
//	}
//	/**
//	 * 返回指定描述位移后的日期
//	 */
//	public static Date minuteOffset(Date date, int offset) {
//		Calendar calendar = convert(date);
//		calendar.add(Calendar.MINUTE, offset); //减填负数
//		return calendar.getTime();
//	}
//
//	/**
//	 * 返回指定日期相应位移后的日期
//	 *
//	 * @param date
//	 *            参考日期
//	 * @param field
//	 *            位移单位，见 {@link Calendar}
//	 * @param offset
//	 *            位移数量，正数表示之后的时间，负数表示之前的时间
//	 * @return 位移后的日期
//	 */
//	public static Date offsetDate(Date date, int field, int offset) {
//		Calendar calendar = convert(date);
//		calendar.add(field, offset);
//		return calendar.getTime();
//	}
//
//	/**
//	 * 返回当月第一天的日期
//	 */
//	public static Date firstDay(Date date) {
//		Calendar calendar = convert(date);
//		calendar.set(Calendar.DATE, 1);
//		return calendar.getTime();
//	}
//
//	/**
//	 * 返回当月最后一天的日期
//	 */
//	public static Date lastDay(Date date) {
//		Calendar calendar = convert(date);
//		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//		return calendar.getTime();
//	}
//
//	/**
//	 * 返回两个日期间的差异天数
//	 *
//	 * @param date1
//	 *            参照日期
//	 * @param date2
//	 *            比较日期
//	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
//	 */
//	public static int dayDiff(Date date1, Date date2) {
//		long diff = date1.getTime() - date2.getTime();
//		return (int) (diff / DAY);
//	}
//
//	/**
//	 * 返回两个日期间的差异小时数
//	 *
//	 * @param date1
//	 *            参照日期
//	 * @param date2
//	 *            比较日期
//	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
//	 */
//	public static int hoursDiff(Date date1, Date date2) {
//		long diff = date1.getTime() - date2.getTime();
//		return (int) (diff / HOUR);
//	}
//
//	/**
//	 * 返回两个日期间的差异秒数
//	 *
//	 * @param date1
//	 *            参照日期
//	 * @param date2
//	 *            比较日期
//	 * @return 参照日期与比较日期之间的天数差异，正数表示参照日期在比较日期之后，0表示两个日期同天，负数表示参照日期在比较日期之前
//	 */
//	public static int secondsDiff(Date date1, Date date2) {
//		long diff = date1.getTime() - date2.getTime();
//		return (int) (diff / SECOND);
//	}
//
//	/**
//	 * 当前月的天数
//	 *
//	 * @param date
//	 * @return
//	 */
//	public static int numberOfDays(LocalDateTime localDateTime) {
//		LOGGER.info("numberOfDays {}", format(localDateTime, YMD_DASH));
//		Date firstDay = firstDay(localDateTime);
//		Date lastDay = lastDay(localDateTime);
//		return dayDiff(lastDay, firstDay) + 1;
//	}
//
//	/**
//	 * 获取当前日期的00:00:00
//	 *
//	 * @param date
//	 * @return
//	 */
//	public static Date getDate(Date date) {
//		Calendar cal = convert(date);
//		int yy = cal.get(Calendar.YEAR);
//		int MM = cal.get(Calendar.MONTH);
//		int dd = cal.get(Calendar.DATE);
//		Calendar cal1 = Calendar.getInstance();
//		cal1.set(yy, MM, dd, 00, 00, 00);
//		return cal1.getTime();
//	}
//
//	/**
//	 * 获取当前日期的周一
//	 *
//	 * @return
//	 */
//	public static Date getMonday(Date date) {
//		Calendar c = convert(date);
//		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
//		if (day_of_week == 0)
//			day_of_week = 7;
//		c.add(Calendar.DATE, -day_of_week + 1);
//		return c.getTime();
//	}
//
//	/**
//	 * 得到本周周日
//	 *
//	 * @return yyyy-MM-dd
//	 */
//	public static Date getSunday(Date date) {
//		Calendar c = convert(date);
//		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
//		if (day_of_week == 0)
//			day_of_week = 7;
//		c.add(Calendar.DATE, -day_of_week + 7);
//		return c.getTime();
//	}
//
//	/**
//	 * 获取mongoDate
//	 *
//	 * @param date
//	 * @return
//	 */
//	public static Date setMongoDate(LocalDateTime localDateTime) {
//		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//			format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
//			String str = DateUtil.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//			date = format.parse(str);
//		} catch (ParseException e) {
//			LOGGER.error("日期格式转换异常", e);
//		}
//		return date;
//	}
//
//	/**
//	 * 根据timemills 返回date 对象
//	 * @param timemills
//	 * @return
//	 */
//	public static Date parseDateFromLong(long timemills){
//		Calendar cal = Calendar.getInstance();
//		cal.setTimeInMillis(timemills);
//		return cal.getTime();
//	}
//
//	/**
//     * 根据日期获得星期
//	 * @param date
//	 * @param type 0 { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }
//	 * @param type 1 { "周日", "周一", "周二", "周三", "周四", "周五", "周六" }
//	 * @param type 2 { "0", "1", "2", "3", "4", "5", "6" }
//	 * @return
//	 */
//	public static String getWeekOfDate(Date date, int type) {
//	  String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
//	  String[] weekDaysName1 = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
//	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
//	  Calendar calendar = Calendar.getInstance();
//	  calendar.setTime(date);
//	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//	  String weekStr = null;
//	  if(type == 0){
//		  weekStr = weekDaysName[intWeek];
//	  }else if(type == 1){
//		  weekStr = weekDaysName1[intWeek];
//	  }else{
//		  weekStr = weekDaysCode[intWeek];
//	  }
//	  return weekStr;
//	}
//	/**
//	 * 获取一天结束时间
//	 * @param date
//	 * @return
//	 */
//	public static Date getDayStartDate(Date date) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		calendar.set(Calendar.HOUR_OF_DAY, 00);
//		calendar.set(Calendar.MINUTE, 00);
//		calendar.set(Calendar.SECOND, 00);
//		calendar.set(Calendar.MILLISECOND, 000);
//		return calendar.getTime();
//	}
//
//	/**
//	 * 获取一天结束时间
//	 * @param date
//	 * @return
//	 */
//	public static Date getDayEndDate(Date date) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		calendar.set(Calendar.HOUR_OF_DAY, 23);
//		calendar.set(Calendar.MINUTE, 59);
//		calendar.set(Calendar.SECOND, 59);
//		calendar.set(Calendar.MILLISECOND, 999);
//		return calendar.getTime();
//	}
//
//	/**
//	 * 获取当前时间离一天结束剩余秒数
//	 * @param currentDate
//	 * @return
//	 */
//	public static Integer getRemainSecondsOneDay(Date currentDate) {
//		LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//		LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),ZoneId.systemDefault());
//		long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
//		return (int) seconds;
//	}
//
//	/**
//	 * 获取指定时间所在星期 的星期一开始时间
//	 *
//	 * Calender 默认星期天为该星期的第一天
//	 *
//	 * @param currentTime
//	 * 	Sat Mar 16 14:23:04 CST 2019
//	 * @return
//	 * 	Mon Mar 11 00:00:00 CST 2019
//	 */
//	public static Date getThisWeekMondayStartTime(Date currentTime){
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(currentTime);
//		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
//		if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//		Date startTime = DateUtil.getDayStartDate(cal.getTime());
//		return startTime;
//	}
//
//}
