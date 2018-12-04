package com.krishna.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.krishna.entity.CustomerDetails;

/**
 * @author krishnachennamsetti
 *
 */
public class CommonUtils {
	
	
	
	public static void main(String[] args) {
		double groceryAmount=290.00;
		double doubleValue = 15.4;
	    int intValue = (int) groceryAmount/100;
		//long n = Math.round(groceryAmount/100);
		System.out.println(intValue);
		//System.out.println((groceryAmount / 100));
		
		
	}

	public static int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
	        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;
	}

	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}

}
