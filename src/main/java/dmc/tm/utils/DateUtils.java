package dmc.tm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

	private final static SimpleDateFormat dfFull = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static Date getDate(Long ms) {
		if (ms == null) {
			return null;
		} else {
			return new Date(ms);
		}
	}

	public static Long getDiff(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return null;
		} else {
			return d1.getTime() - d2.getTime();
		}
	}

	public static Date strToDate(String str) {
		if (str == null || str.trim().equals("")) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dfFull.parse(str));
			return cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String dateToStr(Date date) {
		return date != null ? dfFull.format(date) : "";
	}

	public static Date setZeroTimePart(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

}
