/**
 * 
 */
package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class DateGroup.
 *
 * @author cytech
 */
public class DateGroup {

	/** The date list. */
	private Map<Integer, Map<Integer, Map<Integer, String>>> date_list;

	/**
	 * Instantiates a new date group.
	 */
	public DateGroup() {
		date_list = new HashMap<>();
	}

	/**
	 * Adds the date.
	 *
	 * @param str_date the str date
	 */
	public void addDate(String str_date) {
		LocalDate date = LocalDate.parse(str_date);
		if (date_list.keySet().contains(date.getYear())) {
			addMonth(date_list.get(date.getYear()), date);
		} else {
			Map<Integer, Map<Integer, String>> monthMap = new HashMap<>();
			addMonth(monthMap, date);
			date_list.put(date.getYear(), monthMap);

		}

	}

	/**
	 * Adds the day.
	 *
	 * @param dayMap the day map
	 * @param date   the date
	 */
	private void addDay(Map<Integer, String> dayMap, LocalDate date) {
		if (!dayMap.containsKey(date.getDayOfMonth())) {
			dayMap.put(date.getDayOfMonth(), date.toString());
		}
	}

	/**
	 * Adds the month.
	 *
	 * @param monthMap the month map
	 * @param date     the date
	 */
	private void addMonth(Map<Integer, Map<Integer, String>> monthMap, LocalDate date) {
		if (monthMap.containsKey(date.getMonthValue())) {
			addDay(monthMap.get(date.getMonthValue()), date);
		} else {
			Map<Integer, String> dayMap = new HashMap<>();
			addDay(dayMap, date);
			monthMap.put(date.getMonthValue(), dayMap);
		}
	}

	/**
	 * Gets the date list.
	 *
	 * @return the date_list
	 */
	public Map<Integer, Map<Integer, Map<Integer, String>>> getDate_list() {
		return date_list;
	}

	/**
	 * Sets the date list.
	 *
	 * @param date_list the date_list to set
	 */
	public void setDate_list(Map<Integer, Map<Integer, Map<Integer, String>>> date_list) {
		this.date_list = date_list;
	}
}
