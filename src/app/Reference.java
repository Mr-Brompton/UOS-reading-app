package app;

import java.io.Serializable;

public abstract class Reference implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String author;
	protected String title;
	protected int year;
	public abstract String getAsHTML();
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	protected String titleFormat() {
		return "<i>" + title + "</i> ";
	}
	protected String yearFormat() {
		return"(" + year + ") ";
	}
	/**
	 * dummy class under development
	 * @return
	 */
	protected String authorFormat() {
		return author + " ";
/*	A poor attempt at formating multiple authors. Kept for reference when I decide to implement the feature fully.	
 * 		Thought notes
 * 			Probably a good idea to use a hashmap for surname/initial combinations.
 * StringBuilder authors = new StringBuilder();
		ArrayList<String> authorsList = new ArrayList<String>();
		String currentAuthor = null;
		String[] words = author.split("\\s+");		
// ### Author Rules
		// Surnames and initials should be capitalised. 
		// There should be a comma ',' after the surnames 
		// There should be a dot '.' after each initial
// ### Algorithm.
		// Break String into individual Authors.

		for (String word : words) {
			word = word.substring(0, 1).toUpperCase() + word.substring(1);
			// If the current word is a surname
			if (word.length() > 2) {
				// If the currentAuthor is set to null add word to current author
				if(currentAuthor == null) {currentAuthor = word;}
				// If the currentAuthor is not set to null add current author to author list, and replace current author with current word.
				if (!(currentAuthor == null)) {
					authorsList.add(currentAuthor);
					currentAuthor = word;
				}	
			}
			
			// if the current word is an initial, add to current author.
			else if(word.length() <= 2) {
				if (!(currentAuthor.charAt(currentAuthor.length()) == '.')) {authors.append(".");}
				currentAuthor += word;				
			}
			else {System.err.println("ERROR: checking authors failed. " + "author: "+ author+ "failed at: "+ word); }
		}
		
		
		// If there are more than three authors, discard all but first and add et. al.
		if (authorsList.size() > 2) {
			authors.append(authorsList.get(0));
			authors.append("<i> et al.</i>");
		}
		if (!(authors.charAt(authors.length()) == '.')) {authors.append(".");}
		return authors.toString();
	*/}
}


