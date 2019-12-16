package org.japit.comp.labour.utility;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import javax.servlet.ServletContext;


public class UtilityFunction {
	public static String[] UNIT_NUMBER_VALUE = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Tweleve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] TENS_NUMBER_VALUE = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] UNIT_NAME = {"", "Hundred", "Thousand", "Lakh", "Crore"};

	public static char[] CHAR_ARR = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '`', '~', '1', '!', '2', '@', '3', '#', '4', '$', '5', '%', '6', '^', '7', '&', '8', '*', '9', '(', '0', ')', '-', '_', '=', '+', '[', '{', ']', '}', ';', ':', ',', '<', '.', '>', '/', '?'};

	public static int[][] D = { {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, {2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, {3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, {4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, {5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, {6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, {7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, {8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0} };
	public static int[] INV = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};
	public static int[][] P = { {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, {5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, {8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, {9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, {4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, {2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, {7, 0, 4, 6, 9, 1, 3, 2, 5, 8} };

	public static int[] LAST_DATES = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static String[] HINDI_NUMERIC_VAL = {"०", "१", "२", "३", "४", "५", "६", "७", "८", "९"};

	

	/**
	 * Return reverse of any given string
	 * @param source
	 * @return
	 */
	public static String reverseString(String source) {
	    int i;
	    int length = source.length();
	    StringBuilder revString = new StringBuilder(length);

	    for (i = (length - 1); i >= 0; i--){
	    	revString.append(source.charAt(i));
	    }

	    return revString.toString();
	}

	/**
	 * This will prefix zeros to a given string and change its length to the given length 
	 * @param totalLength
	 * @param var
	 * @return varWithZero
	 */
	public static String prefixZeros(int totalLength, String var) {
		String varWithZero = var;
		int length = totalLength - var.length();
		for(int i = 0; i < length; i++)
			varWithZero = "0" + varWithZero;
		return varWithZero;
	}

	/**
	 * It changes the format of any given date from dd/MM/yyyy to yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String convertNormalToDateDBDate(String date) {
		String[] dateArr = date.split("/");
		return (dateArr[2] + "-" + dateArr[1] + "-" + dateArr[0]);
	}

	/**
	 * It takes user selected date in the format dd/MM/yyyy and convert it to a date object
	 * @param date
	 * @return convertedDate
	 */
	public static Date createDateFromString(String date) {
		String[] dateArr = date.split("/");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dateArr[2]), (Integer.parseInt(dateArr[1]) - 1), Integer.parseInt(dateArr[0]));
		Date convertedDate = new Date(cal.getTime().getTime());
		return convertedDate;
	}

	/**
	 * It takes user selected date in the format ddMMyyyy, then discriminated the date on the basis of the
	 * given eliminator and convert it to a date object by  
	 * @param date
	 * @param deliminator
	 * @return convertedDate
	 */
	public static Date createDateFromString(String date, String eliminator) {
		String[] dateArr = date.split(eliminator);
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dateArr[2]), (Integer.parseInt(dateArr[1]) - 1), Integer.parseInt(dateArr[0]));
		Date convertedDate = new Date(cal.getTime().getTime());
		return convertedDate;
	}

	/**
	 * It takes user given date in the format dd-MM-yyyy, return the date in the format yyyy-MM-dd  
	 * @param date
	 * @param deliminator
	 * @return convertedDate
	 */
	public static String changeDateFormat(String date) {
		String[] dateArr = date.split("-");
		return (dateArr[2] + "-" + dateArr[1] + "-" + dateArr[0]);
	}

	/**
	 * It takes user selected date in the format dd/MM/yyyy and convert it to a date object
	 * @param date
	 * @return convertedDate
	 */
	public static Date createNewDateFromString(String date) {
		String[] dateArr = date.split("/");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(dateArr[2]), (Integer.parseInt(dateArr[1]) - 1), Integer.parseInt(dateArr[0]));
		Date convertedDate = new Date(cal.getTime().getTime());
		return convertedDate;
	}
	
	public static Date createNextDateFromString(String date) {
		String[] dateArr = date.split("-");
		@SuppressWarnings("deprecation")
		Date convertedDate =  new Date(Integer.parseInt(dateArr[0]) - 1900, Integer.parseInt(dateArr[1])-1, Integer.parseInt(dateArr[2]));
		System.out.println("CONVERTED DATE: " + convertedDate);
		return convertedDate;
	}
	
	public static Date createNextLicenseDateFromString(String date) {
		String[] dateArr = date.split("-");
		@SuppressWarnings("deprecation")
		Date convertedDate =  new Date(Integer.parseInt(dateArr[0]) - 1900+1, Integer.parseInt(dateArr[1])-1, Integer.parseInt(dateArr[2]));
		System.out.println("CONVERTED DATE: " + convertedDate);
		return convertedDate;
	}

	/**
	 * Returns the current system date
	 * @return currentDate
	 */
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		Date currentDate =  new Date(cal.getTime().getTime());
		return currentDate;
	}
	
	public static Date getNextDate() {
		java.util.Date date = new java.util.Date();
		@SuppressWarnings("deprecation")
		Date currentDate =  new Date(date.getYear()+1, date.getMonth(), date.getDate());
		return currentDate;
	}

	/**
	 * Returns the current system time
	 * @return currentTime
	 */
	public static Time getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		Time currentTime = new Time(cal.getTime().getTime());
		return currentTime;
	}
	
	public static Timestamp getCurrentTimestamp() {
		java.util.Date date = new java.util.Date();
		@SuppressWarnings("deprecation")
		//Date currentDate =  new Date(date.getYear(), date.getMonth(), date.getDate(),date.getHours(), date.getMinutes(), date.getSeconds());
		Timestamp ts= new Timestamp(date.getYear(), date.getMonth(), date.getDate(),date.getHours(), date.getMinutes(), date.getSeconds(), 000);
		return ts;
	}

	/**
	 * Takes the date in database format (yyyy-MM-dd) and convert it into dd/MM/yyyy format
	 * @param date
	 * @return
	 */
	public static String convertDBDateToNormalDate(String date) {
		String[] dateArr = date.split("-");
		return (dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0]);
	}

	/**
	 * It takes user selected time in the format hh:mm:ss and convert it to a time object
	 * @param time
	 * @return convertedTime
	 */
	public static Time createTimeFromString(String time) {
		String[] timeArr = time.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, Integer.parseInt(timeArr[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(timeArr[1]));
		cal.set(Calendar.SECOND, Integer.parseInt(timeArr[2]));
		Time convertedTime = new Time(cal.getTime().getTime());
		return convertedTime;
	}

	/**
	 * Takes a numeric value and return its equivalent textual representation
	 * @param number
	 * @return convertedTextValue
	 */
	public static String convertNumericToText(int number) {
		String convertedTextValue = "";
		int[] digitsArray =  createDigitsArray(number);
		for(int i = 0; i < digitsArray.length; i++) {
			if(digitsArray[i] > 19) {
				int unitVal = (digitsArray[i] % 10);
				int tensVal = (Integer) (digitsArray[i] / 10);
				convertedTextValue = TENS_NUMBER_VALUE[tensVal] + " " + UNIT_NUMBER_VALUE[unitVal] + " " + UNIT_NAME[i] + " " + convertedTextValue;
			}
			else
				convertedTextValue = UNIT_NUMBER_VALUE[digitsArray[i]] + " " + UNIT_NAME[i] + " " + convertedTextValue;
		}

		return convertedTextValue.trim();
	}

	/**
	 * It takes any numeric value and return an array of its digits numerical places wise
	 * @param number
	 * @return digitsArray
	 */
	public static int[] createDigitsArray(int number) {
		int numberLength = (number + "").length();
		int arraySize = 0;
		if(numberLength < 3)
			arraySize = 1;
		else if(numberLength < 4)
			arraySize = 2;
		else if(numberLength < 6)
			arraySize = 3;
		else if(numberLength < 8)
			arraySize = 4;
		else if(numberLength < 10)
			arraySize = 5;

		int[] digitsArray = new int[arraySize];
		int currNumber = number;
		for(int i = 0; i < arraySize; i++) {
			if(i == 1) {
				digitsArray[i] = (currNumber % 10);
				currNumber = (Integer) (currNumber / 10);
			}
			else {
				digitsArray[i] = (currNumber % 100);
				currNumber = (Integer) (currNumber / 100);
			}
		}

		return digitsArray;
	}

	/**
	 * It takes any numeric value and return an array of its digits
	 * @param number
	 * @return digitsArray
	 */
	public static int[] createEachDigitsArray(int number) {
		int numberLength = (number + "").length();
		int[] digitsArray = new int[numberLength];
		int currNumber = number;
		for(int i = 0; i < numberLength; i++) {
			digitsArray[i] = (currNumber % 10);
			currNumber = (Integer) (currNumber / 10);
		}
		return digitsArray;
	}

	/**
	 * It takes any numeric value as string and return an array of its digits
	 * @param number
	 * @return digitsArray
	 */
	public static int[] createEachDigitsArray(String number) {
		int numberLength = number.length();
		int[] digitsArray = new int[numberLength];
		Long currNumber = Long.parseLong(number);
		for(int i = 0; i < numberLength; i++) {
			digitsArray[i] = (int) (currNumber % 10);
			currNumber = (Long) (currNumber / 10);
		}
		return digitsArray;
	}

	/**
	 * It takes a numerical value as string and generates a checksum value based on Verhoeff Algorithm
	 * @param number
	 * @return checksum
	 */
	public static int createCheckSumDigit(String number) {
		int[] digits = reverseArray(createEachDigitsArray(number));
		digits = addElement(digits, 0);
		int i = 0;
		int checksum = 0;
		for(int j = (digits.length - 1); j > -1; j--) {
			int imod8 = i % 8;
			int p = P[imod8][digits[j]];
			checksum = D[checksum][p];
			i++;
		}
		checksum = INV[checksum];
		return checksum;
	}

	/**
	 * Takes an integer array and returns an integer array with elements are in reverse order from the first one
	 * @param array
	 * @return reversedArray
	 */
	public static int[] reverseArray(int[] array) {
	    int[] reversedArray = new int[array.length];
	    for (int i=0; i<array.length; i++) {
	    	reversedArray[i] = array[array.length - 1 - i];
	    }
	    return reversedArray;
	}

	/**
	 * Takes an integer array and an integer number to add in the given array
	 * @param array
	 * @param num
	 * @return array
	 */
	static int[] addElement(int[] array, int num) {
		array  = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = num;
	    return array;
	}

	/**
	 * Takes an string as input and returns a string containing numeric values corresponding to the characters
	 * present in the given string
	 * @param text
	 * @return numberedText
	 */
	public static String getNumbersOfText(String text) {
		String numberedText = "";
		for(int i = 0; i < text.length(); i++)
			numberedText = numberedText + ((new String(CHAR_ARR).indexOf(text.charAt(i))) % 10);
		return numberedText;
	}

	/**
	 * Returns the calculated age in years from the given date of birth 
	 * @param date_of_birth
	 * @return age
	 */
	public static int calculateAge(String dateOfBirth) {
		int age = 0;
		String[] birthDateArr = dateOfBirth.split("/");
		int birthDate = Integer.parseInt(birthDateArr[0]);
		int birthMonth = Integer.parseInt(birthDateArr[1]);
		int birthYear = Integer.parseInt(birthDateArr[2]);

		String[] currDateArr = ("" + getCurrentDate()).split("-");
		int currDate = Integer.parseInt(currDateArr[2]);
		int currMonth = Integer.parseInt(currDateArr[1]);
		int currYear = Integer.parseInt(currDateArr[0]);

		if(currDate < birthDate)
			currMonth--;
		if(currMonth < birthMonth)
			currYear--;

		age = currYear - birthYear;

		return age;
	}

	/**
	 * Calculate the last date of given month and year
	 * @param month
	 * @param year
	 * @return lastDate
	 */
	public static int getLastDateOfTheMonth(int month, int year) {
		int lastDate = 0;
		int mon = month - 1;
		if(mon == 1 && isLeapYear(year))
			lastDate = 29;
		else
			lastDate =  LAST_DATES[mon];
		return lastDate;
	}

	/**
	 * Takes an year and returns whether it is a leap year or not
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if(year%400 == 0 || (year%4 == 0 && year%100 != 0))
			return true;
		else
			return false;
	}

	/**
	 * Returns the calculated difference between two given dates in the given unit
	 * @param startDate
	 * @param endDate
	 * @param dateFormat
	 * @param differenceUnit
	 * @return dateDifference
	 */
	public static long calculateDateDifference(String startDate, String endDate, String dateFormat, char differenceUnit) {
		long dateDifference = 0;
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);

		java.util.Date d1 = null;
		java.util.Date d2 = null;

		try {
			d1 = format.parse(startDate);
			d2 = format.parse(endDate);

			long difference = d2.getTime() - d1.getTime();
			long dividingUnit = 0;

			switch (differenceUnit) {
			case 's':
				dateDifference = difference / 1000 % 60;
				break;

			case 'm':
				dateDifference = difference / (60 * 1000) % 60;
				break;

			case 'h':
				dateDifference = difference / (60 * 60 * 1000) % 24;
				break;

			case 'D':
				dateDifference = difference / (24 * 60 * 60 * 1000);
				break;

			case 'M':
				dividingUnit=30 * 24;
				dividingUnit=dividingUnit* 60;
				dividingUnit=dividingUnit* 60;
				dividingUnit=dividingUnit* 1000;
				dateDifference = difference /dividingUnit;
				break;

			case 'Y':
				dateDifference = difference / (365 * 30 * 24 * 60 * 60 * 1000);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateDifference;
	}

	/**
	 * Takes the gender in character and return the gender name in Hindi
	 * @param gender
	 * @return hindiGender
	 */
	public static String getGenderInHindi(char gender) {
		String hindiGender = null;
		if(gender == 'M')
			hindiGender = "पुस्र्ष";
		else if(gender == 'F')
			hindiGender = "महिला";
		else if(gender == 'T')
			hindiGender = "किन्नर";
		return hindiGender;
	}

	/**
	 * Takes date of in English and return in Hindi where date format for both is dd/MM/yyyy
	 * @param dateOfBirth
	 * @return hindiDob
	 */
	public static String getDateOfBirthInHindi(String dateOfBirth) {
		String[] dateArr = dateOfBirth.split("/");
		String hindiDob = getHindiNumericValue(dateArr[0]) + "/" + getHindiNumericValue(dateArr[1]) + "/" + getHindiNumericValue(dateArr[2]);
		return hindiDob;
	}

	/**
	 * Takes an integer in English and returns its equivalent Hindi numeric value 
	 * @param numericValue
	 * @return
	 */
	public static String getHindiNumericValue(String numericValue) {
		String hindiNumericValue = "";
		int[] digits = reverseArray(createEachDigitsArray(numericValue));
		for(int i = 0; i < digits.length; i++) {
			hindiNumericValue = hindiNumericValue + HINDI_NUMERIC_VAL[digits[i]];
		}
		return hindiNumericValue;
	}

	/**
	 * Find and return url for the given act and application status
	 * @param service_id
	 * @param applicatoin_status
	 * @return
	 */
	

	

	public static String getFtpPath(ServletContext servletContext) {
		try {
			String absolutePath = servletContext.getRealPath("/");
			absolutePath = absolutePath.substring(0, absolutePath.length() - 1);
		    absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf('\\') + 1).concat("ftp\\");
		    return absolutePath;
		}
	    catch(Exception e) {System.out.println("GET PATH ER: "); e.printStackTrace(); return null;}
	}

	/**
	 * Returns the current day from system date
	 * @return currentDay
	 */
	public static int getCurrentDay() {
		int currentDay =  Calendar.getInstance().get(Calendar.DATE);
		return currentDay;
	}

	/**
	 * Returns the current month from system date
	 * @return currentMonth
	 */
	public static int getCurrentMonth() {
		int currentMonth =  Calendar.getInstance().get(Calendar.MONTH);
		return currentMonth;
	}

	/**
	 * Returns the current year from system date
	 * @return currentYear
	 */
	public static int getCurrentYear() {
		int currentYear =  Calendar.getInstance().get(Calendar.YEAR);
		return currentYear;
	}

	
	public static String capitalize(String text) {
	    char[] stringArray = text.trim().toCharArray();
	    boolean wordStarted = false;
	    for( int i = 0; i < stringArray.length; i++) {
	      char ch = stringArray[i];
	      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ch == '\'') {
	        if( !wordStarted ) {
	          stringArray[i] = Character.toUpperCase(stringArray[i]);
	          wordStarted = true;
	        } 
	      } else {
	        wordStarted = false;
	      }
	    }
	    return new String(stringArray);
	  }
	
	
	/**
	 * Takes the date in database format (yyyy-MM-dd) and convert it into dd-MM-yyyy format for
	 * single window web service
	 * @param date
	 * @return
	 */
	public static String convertDBDateToSWDate(String date) {
		String[] dateArr = date.split("-");
		return (dateArr[2] + "-" + dateArr[1] + "-" + dateArr[0]);
	}
	
	public static String convertDBDateToMonthYear(String date) {
		String[] dateArr = date.split("/");
		return (dateArr[0] + "-" + dateArr[1]);
	}
	
	public static String convertBoilerDateToSWDate (String date) {
		String[] dateArr = date.split("/");
		return (dateArr[0] + "-" + dateArr[1] + "-" + dateArr[2]);
	}
}