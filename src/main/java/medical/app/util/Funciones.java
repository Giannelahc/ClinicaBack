package medical.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funciones {
	
	private Funciones() {}
	
	public static java.sql.Date convertirFecha(Date fecha) {
		return new java.sql.Date(fecha.getTime());
	}

	public static java.sql.Date convertirFecha(String fecha) {
		java.sql.Date sqlFecha = null;
		try {
			 sqlFecha = new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse(fecha).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlFecha;
	}
}
