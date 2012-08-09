package dots.tool.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ValueHelper {

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	public static String getDateTime(Date date) {

		if (date == null) {
			return dateTimeFormat.format(Calendar.getInstance().getTime());
		} else {
			return dateTimeFormat.format(date);
		}

	}

	public static String getDate(Date date) {

		if (date == null) {
			return dateFormat.format(Calendar.getInstance().getTime());
		} else {
			return dateFormat.format(date);
		}

	}

	public static String getYear(Integer year) {

		if (year == null) {
			return yearFormat.format(Calendar.getInstance().getTime());
		} else {
			return year + "";
		}

	}

	public static String getName(String name) {
		return "system";
	}

	public static String getFileId(String fileId) {
		return "uninitialized";
	}

	public static String getInt0(Integer num) {
		return "0";
	}

	public static String getInt1(Integer documentNumber) {
		return "1";
	}

	public static String getAssociatedWithRecordAs(String assoc) {

		if (assoc == null || assoc.isEmpty()) {

			return "Vedlegg";

		} else {
			return assoc;
		}

	}

	public static String getVariantFormat(String variantFormat) {

		if (variantFormat == null || variantFormat.isEmpty()) {

			return "Produksjonsformat";

		} else {
			return variantFormat;
		}

	}

	public static String getFondsStatus(String fondsStatus) {
		return "Avsluttet";
	}

	public static String getSeriesStatus(String seriesStatus) {
		return "Avsluttet periode";
	}

	public static String getDocumentStatus(String documentStatus) {
		return "Dokumentet er ferdigstilt";
	}

}
