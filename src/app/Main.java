package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static ArrayList<Reference> references = new ArrayList<Reference>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		///Options
		displayOptions();
		
		
		sc.close();
	}

	private static void printHTML() {

		System.out.println("\n\n<!Doctype html>\r\n" + 
				" <html>\r\n" + 
				"  <head>\r\n" + 
				"   <title>Master Bibliography</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"   <h1>Bibliography</h1>\r\n" + 
				"   <p>");
		for(Reference reference : references) {
			System.out.println(reference.getAsHTML());
		}
		System.out.println("   </p>\r\n" + 
				"  </body>\r\n" + 
				" </html>  \n\n");
		displayOptions();
	}

	private static void addReference() {
		System.out.println("which type of reference?\n1. Book.\n2. Web Page");
		
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			addBook();
		}
		else if (choice == 2) {
			addWebPage();
		}
		else if (choice == 3) {
			System.out.println("not yet implemented");
		}
		else {System.out.println("please choose 1, 2, or 3");addReference();}
		
		displayOptions();
	}
//Author surname(s)/editor(s), Initial(s). (Year) Title. Available at: URL (Accessed: date).

	private static void addWebPage() {
		WebPage webReference = new WebPage();
		System.out.println("Enter Author (example: Pratchett, T.)");
		webReference.setAuthor(sc.nextLine());
		webReference.setYear(inputYear());
		System.out.println("Enter Title (example: The Colour of Magic.)");
		webReference.setTitle(sc.nextLine());
		System.out.println("Enter URL (example: https://www.terrypratchettbooks.com)");
		webReference.setUrl(sc.nextLine());
		System.out.println("Enter day accessed (example: 16)");
		webReference.setAccessDay(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter month accessed (Example: 1 OR jan OR January)");
		webReference.setAccessedMonth(sc.nextLine());
		System.out.println("Enter Year accessed (example: 2012)");
		webReference.setAccessedYear(sc.nextInt());
		sc.nextLine();
		references.add(webReference);
		System.out.println("Done");
		//System.out.println(webReference.toString() + "added to reference list");
		displayOptions();
	}

	private static void addBook() {
		Book bookReference = new Book();
		System.out.println("Enter Author (example: Pratchett, T.)");
		bookReference.setAuthor(sc.nextLine());
		bookReference.setYear(inputYear());
		System.out.println("Enter Title (example: The Colour of Magic.)");
		bookReference.setTitle(sc.nextLine());
		System.out.println("Enter Edition (example: 2)");
		bookReference.setEdition(sc.nextInt()); sc.nextLine();
		System.out.println("Enter Publisher (example: London: Colin Smythe)");
		bookReference.setPublishingInfo(sc.nextLine());
		System.out.println("Done");
		//System.out.println(bookReference.toString() + "added to reference list");
		references.add(bookReference);	
	}

	private static void displayOptions() {
		System.out.println("Select:");
		System.out.println("1. Add Reference");
		if (references.size() > 0) {System.out.println("2. Print References as HTML");System.out.println("3. Save Project to file");}
		if (references.size() == 0) {System.out.println("4. Load project");}
		int choice = sc.nextInt();
		if (choice == 1) {
			sc.nextLine();
			addReference();
		}
		else if (choice == 2) {
			printHTML();
		}
		else if (choice == 3) {
			saveProject();
		}
		else if (choice == 4) {
			loadProject();
		}
		else {System.out.println("please choose 1, 2, 3, or 4");displayOptions();}
	}

	private static void loadProject() {
		System.out.println("Please enter the project name");
		String projectName;
		sc.nextLine();
		projectName = sc.nextLine();
		ProjectManager project = new ProjectManager(projectName) ;
		 
        //Read object from file
        references = project.ReadProjectFromFile(projectName);
        for (Reference reference: references) {System.out.println(reference.getAsHTML());}
		displayOptions();
	}

	private static void saveProject() {
		System.out.println("Please enter a name for the project");
		
		String projectName;
		sc.nextLine();
		projectName = sc.nextLine();
		ProjectManager project = new ProjectManager(projectName) ;
		 
        
        project.WriteProjectToFile(references);
		
	}
	
	private static int inputYear() {
		int year = 0;
		try {
			System.out.println("Enter Date (example: 1983)");
			year = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Date should be a four digit number");
			
			displayOptions();
		}
		
		sc.nextLine();
		return year;
	}

}
