package br.com.livelo.login.util;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public final class Util {

	/** Constant Mascara no formado yyyy-MM-dd'T'HH:mm:ss'Z' */
	public static final String MASCARA_ZONEDDATETIME_COM_SEGUNDO = "yyyy-MM-dd'T'HH:mm[:ss][.SSS][XXX]['['VV']']";
	/** Constant Mascara no formado yyyy-MM-dd'T'HH:mm:ss.SSS'Z' */
	public static final String MASCARA_ZONEDDATETIME_COM_NANOSEGUNDOS = "yyyy-MM-dd'T'HH:mm:ss.SSS'X'";
	private static final String MASCARA_DATE_COM_SEGUNDOS_12_HOURS = "yyyy-MM-dd hh:mm:ss a";

	private Util() {
	}

	public static ZonedDateTime parseStringToZonedDateTime(final String date) {
		ZonedDateTime dateZonedDateTime = null;
		if (StringUtils.isNotBlank(date)) {
			try {
				dateZonedDateTime = ZonedDateTime.parse(date);
			} catch (DateTimeParseException e) {
				throw new IllegalArgumentException(getMessageDateInvalid());
			}
		}
		return dateZonedDateTime;
	}

	private static String getMessageDateInvalid() {
		StringBuilder message = new StringBuilder();
		message.append("Invalid data format. User according to the mask ");
		message.append(MASCARA_ZONEDDATETIME_COM_SEGUNDO);
		message.append(" or ");
		message.append(MASCARA_ZONEDDATETIME_COM_NANOSEGUNDOS);
		return message.toString();
	}

	public static String parseDateToString(final Date date) {
		String dataFormatada = null;
		if (date != null) {
			SimpleDateFormat formater = new SimpleDateFormat(MASCARA_DATE_COM_SEGUNDOS_12_HOURS);
			dataFormatada = formater.format(date);
		}
		return dataFormatada;
	}
}
