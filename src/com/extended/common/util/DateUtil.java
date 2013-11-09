/**
 * 
 */
package com.extended.common.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @author Gaurav
 * 
 */
public class DateUtil extends DateUtils {

	public static Date dateInTimeZone(Date srcDate, TimeZone fromTimeZone,
			TimeZone toTimeZone) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);
		calendar.setTimeZone(toTimeZone);
		calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		if (fromTimeZone.inDaylightTime(calendar.getTime())) {
			calendar.add(Calendar.MILLISECOND, calendar.getTimeZone()
					.getDSTSavings() * -1);
		}

		calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		if (toTimeZone.inDaylightTime(calendar.getTime())) {
			calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}

		return calendar.getTime();
	}

	public static Calendar dateInTimeZone(Calendar srcCal, TimeZone toTimeZone)
			throws ParseException {
		TimeZone fromTimeZone = srcCal.getTimeZone();
		srcCal.setTimeZone(toTimeZone);
		srcCal.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		if (fromTimeZone.inDaylightTime(srcCal.getTime())) {
			srcCal.add(Calendar.MILLISECOND, srcCal.getTimeZone()
					.getDSTSavings() * -1);
		}

		srcCal.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		if (toTimeZone.inDaylightTime(srcCal.getTime())) {
			srcCal.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}

		return srcCal;
	}

}
