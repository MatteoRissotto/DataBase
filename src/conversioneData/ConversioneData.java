package conversioneData;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConversioneData {
	
	public static java.sql.Date toSql(String date) throws ParseException{
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date javaDate =  sp.parse(date);
		java.sql.Date dt = new java.sql.Date(javaDate.getTime());
	
		return dt;
	}
	public static String fromSql(java.sql.Date date) throws ParseException{
		java.util.Date dt = new java.util.Date(date.getTime());
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		String converted=sp.format(dt);
	
		return converted;
	}

}
