package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {
	
	public static String fechaActual() {
		
		return (LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
		
	}

}
