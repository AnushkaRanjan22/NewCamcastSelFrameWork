package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class JavaUtility {
	public int getRandomNum() {
		Random ram = new Random();
		int random = ram.nextInt(5000);
		return random;
	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
	
	public String getSystemPlusThirtyDay() {
		Date dateObj= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(dateObj);
		Calendar cd=sdf.getCalendar();
		cd.add(Calendar.DAY_OF_MONTH,30);
		String endDate = sdf.format((cd.getTime()));
		return endDate;
	}



}
