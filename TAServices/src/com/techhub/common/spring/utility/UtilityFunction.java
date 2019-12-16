package com.techhub.common.spring.utility;

import java.sql.Date;
import java.util.Calendar;

public class UtilityFunction {

	
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date currentDate =  new Date(cal.getTime().getTime());
		return currentDate;
	}
	
	
}
