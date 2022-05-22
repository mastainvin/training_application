/**
 *
 */
package utils;

import java.util.Collection;

/**
 * Utils.
 *
 * @author Vincent Mastain
 * @version 1.0
 * 
 */
public class Utils {

	/**
	 * Gets the month index.
	 *
	 * @param month the month
	 * @return the month integer
	 */
	public static Integer getMonthInteger(String month) {
		switch (month) {
		case ("Janvier"):
			return 1;
		case ("Février"):
			return 2;
		case ("Mars"):
			return 3;
		case ("Avril"):
			return 4;
		case ("Mai"):
			return 5;
		case ("Juin"):
			return 6;
		case ("Juillet"):
			return 7;
		case ("Août"):
			return 8;
		case ("Septembre"):
			return 9;
		case ("Octobre"):
			return 10;
		case ("Novembre"):
			return 11;
		default:
			return 12;
		}
	}

	/**
	 * Gets the month name from is index.
	 *
	 * @param month the month
	 * @return the month name
	 */
	public static String getMonthName(Integer month) {
		switch (month) {
		case (1):
			return "Janvier";
		case (2):
			return "Février";
		case (3):
			return "Mars";
		case (4):
			return "Avril";
		case (5):
			return "Mai";
		case (6):
			return "Juin";
		case (7):
			return "Juillet";
		case (8):
			return "Août";
		case (9):
			return "Septembre";
		case (10):
			return "Octobre";
		case (11):
			return "Novembre";
		default:
			return "Decembre";
		}
	}

	/**
	 * Checks if is empty or null.
	 *
	 * @param collection the collection
	 * @return true, if is empty or null
	 */
	public static boolean isEmptyOrNull(Collection<?> collection) {
		if (collection == null) {
			return true;
		} else {
			return collection.isEmpty();
		}
	}

	/**
	 * Checks if is numeric.
	 *
	 * @param strNum the str num
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if is integer.
	 *
	 * @param strNum the str num
	 * @return true, if is integer
	 */
	public static boolean isInteger(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
}
