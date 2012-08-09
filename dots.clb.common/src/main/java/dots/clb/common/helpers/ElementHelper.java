package dots.clb.common.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ElementHelper {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static String dateTimeToString(Date date) {
		return dateTimeFormat.format(date);
	}

	public static String dateToString(Date date) {
		return dateFormat.format(date);
	}
}
