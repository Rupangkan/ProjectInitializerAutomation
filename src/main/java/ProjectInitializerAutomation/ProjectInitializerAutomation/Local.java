package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Use Git API ;____;  (jGit)
//Use jproc for System commands

public class Local {
	String path = System.getenv("PRO");
	void create(String rep) {
		try {
			System.out.println(path);
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
//			Runtime.getRuntime().exec("cmd /c start tasks.bat");
			Runtime.getRuntime().exec("cmd /c start tasks.bat", null, new File(path));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
//	may need to delete the tasks.bat file after using it

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
		      FileWriter myWriter = new FileWriter(path+"//"+"tasks.bat");
		      myWriter.write("git init");
		      myWriter.write(System.getProperty( "line.separator" ));
//		      myWriter.write("touch ReadMe.md");
//		      myWriter.write(System.getProperty( "line.separator" ));
//		      myWriter.write("timeout 5");
//		      myWriter.write(System.getProperty( "line.separator" ));
		      myWriter.write("git add .");
		      myWriter.write(System.getProperty( "line.separator" ));
		      myWriter.write("timeout 10");
		      myWriter.write(System.getProperty( "line.separator" ));
		      myWriter.write("git commit -m "+(char)34+"1st commit"+(char)34+"");
		      myWriter.write(System.getProperty( "line.separator" ));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	

}


















