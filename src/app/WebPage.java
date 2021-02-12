package app;

import java.io.Serializable;

/**
 * Creates reference objects to store book references.
 * @author MrBro
 *
 */
public class WebPage extends Reference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private int accessedDay;
	private String accessedMonth;
	private int accessedYear;
/**
 * 
 */
	public WebPage(String author, int year, String title, int edition, int accessedDay, String accessedMonth, int accessedYear){
		this.author = author;
		this.year = year;
		this.title = title;
		this.accessedDay = accessedDay;
		this.accessedMonth = accessedMonth;
		this.accessedYear = accessedYear;
	}
	/**
	 * 
	 */
	public WebPage(){}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the accessedMonth
	 */
	public String getAccessedMonth() {
		return accessedMonth;
	}
	/**
	 * @return the accessedYear
	 */
	public int getAccessedYear() {
		return accessedYear;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param accessedDay the accessedDay to set
	 */
	public void setAccessedDay(int accessedDay) {
		this.accessedDay = accessedDay;
	}
	/**
	 * @param accessedMonth the accessedMonth to set
	 */
	public void setAccessedMonth(String accessedMonth) {
		this.accessedMonth = accessedMonth;
	}
	/**
	 * @param i the accessedYear to set
	 */
	public void setAccessedYear(int i) {
		this.accessedYear = i;
	}
	/**
	 * @return the publishingInfo
	 */
	public int getAccessedDay() {
		return accessedDay;
	}

	/**
	 * @param publishingInfo the publishingInfo to set
	 */
	public void setAccessDay(int i) {
		this.accessedDay = i;
	}
	
	/** Get reference as html
	 */
	//Author surname(s)/editor(s), Initial(s). (Year) Title. Available at: URL (Accessed: date).

	public String getAsHTML() {
		StringBuilder referenceAsHTML = new StringBuilder();
		referenceAsHTML.append(authorFormat());
		referenceAsHTML.append(yearFormat());
		referenceAsHTML.append(titleFormat());
		referenceAsHTML.append(urlFormat());
		referenceAsHTML.append(accessedDateFormat() + '.');
		
		return referenceAsHTML.toString();
		
	}
	private String urlFormat() {
		StringBuilder url = new StringBuilder("Available at: ");
		url.append(this.url + ' ');
		
		
	return url.toString();
	}
	private String accessedDateFormat() {
		StringBuilder accessedDate = new StringBuilder("(Accessed: ");
		accessedDate.append(this.accessedDay + ' ');
		accessedDate.append(formatMonth() + ' ');
		accessedDate.append(this.accessedYear + ")");
		
		return accessedDate.toString();
	}
	private String formatMonth() {
		String month;
		switch(this.accessedMonth.toLowerCase()) {
		case "1": case "jan": case "january":
			month = "January";
			break;
		case "2": case "feb": case "febuary":
			month = "Febuary";
			break;
		case "3": case "mar": case "march":
			month = "March";
			break;
		case "4": case "apr": case "april":
			month = "April";
			break;
		case "5": case "may":
			month = "May";
			break;
		case "6": case "jun": case "june":
			month = "June";
			break;
		case "7": case "jul": case "july":
			month = "July";
			break;
		case "8": case "aug": case "august":
			month = "August";
			break;
		case "9": case "sep": case "september":
			month = "September";
			break;
		case "10": case "oct": case "october":
			month = "October";
			break;
		case "11": case "nov": case "november":
			month = "November";
			break;
		case "12": case "dec": case "december":
			month = "December";
			break;
		default:
			System.err.println("Oops: Invalid month");
			month = "oops";
			break;
		}
		return month;
	}


	
}
