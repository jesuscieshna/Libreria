package utils;

import java.util.regex.Pattern;

public class Validaciones {
	public static boolean validateNumber(String number) {
		return Pattern.matches("[0-9]*[.]{0,1}[0-9]{0,2}", number);
	}
	
	public static boolean validateisbn(String numero, String letra) {
		String nuevo = numero + letra;
		boolean longitudAdecuada = nuevo.length() <= 13;
		return Pattern.matches("[0-9]*", nuevo) && longitudAdecuada;
	}
}
