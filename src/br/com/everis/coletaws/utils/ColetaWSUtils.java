package br.com.everis.coletaws.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ColetaWSUtils {
	private static final String JSON_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public static String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
	
	public static Date convertJSONDateToJavaDate(String jsonDate) throws ParseException{
		return new SimpleDateFormat(JSON_DATE_PATTERN).parse((String) jsonDate);
	}
	
}
