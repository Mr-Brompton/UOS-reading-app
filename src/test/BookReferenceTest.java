package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Book;

public class BookReferenceTest {
	// Initialise reference
			Book bookReference = new Book("Pratchett, T.", 1983, "The Colour of Magic.", 2, "Gerrards Cross: Colin Smythe");
			
	@Test
	public void testCorrectData() {
		// Run tests
		assertEquals("Book Reference Author not correct", "Pratchett, T.", bookReference.getAuthor());
		assertEquals("Book Reference year not correct", 1983, bookReference.getYear());
		assertEquals("Book Reference title not correct", "The Colour of Magic.", bookReference.getTitle());
		assertEquals("Book Reference edition not correct", 2, bookReference.getEdition());
		assertEquals("Book Reference publishing info not correct", "Gerrards Cross: Colin Smythe", bookReference.getPublishingInfo());
		assertEquals("Book Reference as HTML not correct", bookReference.getAsHTML(), "Pratchett, T. (1983) <i>The Colour of Magic.</i> 2<sup>nd</sup>. Gerrards Cross: Colin Smythe<br>");

	}
	@Test
	public void testIncorrectData() {
		fail("not yet implemented");
		// Testing response when authors name and initials are not capitalised
		// Testing response when the year is not 4 digit integer
		// Testing response when edition is very large
		// Testing response when publishing information does not include colon.
		// Testing empty fields responses
			//Author
			//Year
			//Title
			//Edition
			//Publishing
		// Testing if edition is 1
		// Testing if edition is 0
	}

}
