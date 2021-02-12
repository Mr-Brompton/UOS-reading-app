package app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class ProjectManager implements Serializable{
	 //default serialVersion id
    private static final long serialVersionUID = 1L;
    private String filepath="C:\\Users\\MrBro\\Desktop\\Reading-App\\workspace\\reading-app-v0.1\\src\\data\\";

	public ProjectManager(String projectName) {
		this.filepath += projectName + ".txt";
	}
	public void WriteProjectToFile(Object serObj) {
		 
        try {
        	System.out.println("Saving to: " + filepath);
        	File file = new File(filepath);
        	file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Project  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	@SuppressWarnings("unchecked")
	public ArrayList<Reference> ReadProjectFromFile(String projectName) {
		ArrayList<Reference> obj = new ArrayList<Reference>();
		try {
			 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
			obj = (ArrayList<Reference>) objectIn.readObject();
 
            System.out.println("The Project has been read from the file");
            objectIn.close();
            
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return obj;
	}
}
