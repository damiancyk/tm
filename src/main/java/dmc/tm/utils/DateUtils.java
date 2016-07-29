package dmc.tm.utils;

import java.util.Date;

public final class DateUtils {

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

}
