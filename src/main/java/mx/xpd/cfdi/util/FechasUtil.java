package mx.xpd.cfdi.util;

import java.util.Calendar;

public class FechasUtil {

	public int getPrimerDiaDelMes(Integer anio, Integer mes) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, anio);
		cal.set(Calendar.MONTH, mes-1);
		return cal.getMinimum(Calendar.DAY_OF_MONTH);
	}
	
	public int getUltimoDiaDelMes(Integer anio, Integer mes) {
      Calendar cal = Calendar.getInstance();
	  cal.set(Calendar.YEAR, anio);
	  cal.set(Calendar.MONTH, mes-1);
	  return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
}
