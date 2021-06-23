package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTime {
	public String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
	}
	
	public String horaActual() {
		int hh, mm, ss;
		Calendar c = new GregorianCalendar();
		hh = c.get(Calendar.HOUR_OF_DAY);
		mm = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		return ajustar(hh) + ":" + ajustar(mm) + ":" + ajustar(ss);
	}
	
	public static String ajustar(int numero) {
		return String.format("%02d", numero);
	}
}
