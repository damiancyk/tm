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

}
