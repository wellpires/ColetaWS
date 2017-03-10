package br.com.everis.coletaws.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ColetaWSUtils {
	public static String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
}
