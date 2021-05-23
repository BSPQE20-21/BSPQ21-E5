package es.termibus.data;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	
	public static ResourceBundle lang = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag("es"));
}
