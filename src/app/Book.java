package app;

import java.io.Serializable;

/**
 * Creates reference objects to store book references.
 * @author MrBro
 *
 */
public class Book extends Reference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int edition;
	private String publishingInfo;
/**
 * Constructor to build a populated BookReference Object if all fields are provided
 * @param author
 * @param year
 * @param title
 * @param edition
 * @param publishingInfo
 */
	public Book(String author, int year, String title, int edition, String publishingInfo){
		this.author = author;
		this.year = year;
		this.title = title;
		this.edition = edition;
		this.publishingInfo = publishingInfo;
	}
	/**
	 * Constructor to build a BookReference placeholder object with no values provided
	 */
	public Book(){}
	/**
	 * @return the author
	 */

	/**
	 * @return the edition
	 */
	public int getEdition() {
		return edition;
	}
	/**
	 * @return the publishingInfo
	 */
	public String getPublishingInfo() {
		return publishingInfo;
	}
	/**
	 * @param author the author to set
	 */
	/**
	 * @param edition the edition to set
	 */
	public void setEdition(int edition) {
		this.edition = edition;
	}
	/**
	 * @param publishingInfo the publishingInfo to set
	 */
	public void setPublishingInfo(String publishingInfo) {
		this.publishingInfo = publishingInfo;
	}
	
	/** Get reference as html
	 */
	//Author surname(s), Initial(s). (Year) Book title. Edition. Place of publication: Publisher
	public String getAsHTML() {
		StringBuilder referenceAsHTML = new StringBuilder();
		referenceAsHTML.append(authorFormat());
		referenceAsHTML.append(yearFormat());
		referenceAsHTML.append(titleFormat());
		referenceAsHTML.append(editionFormat());
		referenceAsHTML.append(publisherFormat());
		
		return referenceAsHTML.toString();
		
	}
	private String publisherFormat() {
		return publishingInfo + ".<br>";
	}
	private String editionFormat() {
		String formatEdition;
		switch(edition) {
		case 1:
			formatEdition = edition + "<sup>st</sup>. ";
			break;
		case 2:
			formatEdition = edition + "<sup>nd</sup>. ";
			break;
		case 3:
			formatEdition = edition + "<sup>rd</sup>. ";
			break;
		default:
			formatEdition = edition + "<sup>th</sup>. ";
			break;
		}
		return formatEdition;
	}

	
}
