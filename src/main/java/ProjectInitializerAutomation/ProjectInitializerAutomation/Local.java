package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Local {
	private String path = "D:\\Projects\\";
	void create(String rep) {
		try {

			File file = new File(path);
			//Creating the directory
			boolean bool = file.mkdir();
			path = path+rep;
			if(bool){
				//make directory name dynamic
				System.out.println("Projects Directory created successfully");
				
			}else{
				System.out.println("Projects folder already there");
				
			}
			createFolder(path);
		}
		catch(Exception e) {
			System.out.println("Could not create folder");
		}
	}
	private void createFolder(String path) {
		try {
			File file = new File(path);
			boolean bool = file.mkdir();
			if(bool){
				System.out.println("Directory created successfully");
				
			}else{
				System.out.println("Folder already there");
				
			}
			command();
		}
		catch(Exception e) {
			System.out.println("Could not create folder");
		}


	}
	private void command() {
		createBat();
		
		try {
			Runtime.getRuntime().exec("cmd /c start tasks.bat");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
//	

	}
	void createBat() {
		 try {
		      File myObj = new File("tasks.bat");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 try {
		      FileWriter myWriter = new FileWriter("tasks.bat");
		      myWriter.write("dir");
		      System.getProperty( "line.separator" );
		      myWriter.write("color 02");
		      System.getProperty( "line.separator" );
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	

}


















