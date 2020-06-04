package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hora {
	
	public static String horaActual() {
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
}
