package cl.miHospital.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
	
	public static Date stringToDate(String stringDate, String format){
		try{
			DateFormat formatter = new SimpleDateFormat(format);
			Date date = formatter.parse(stringDate);
			return date;
		}catch(ParseException e){
			e.printStackTrace();
			return null;
		}		
	}

}
