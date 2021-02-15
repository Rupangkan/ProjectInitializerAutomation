package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.buildobjects.process.ProcBuilder;
import org.buildobjects.process.ProcResult;

//Use Git API ;____;  (jGit)
//Use jproc for System commands
//touch not working

public class Local {
	String path = System.getenv("PRO");
	String dir;
	String repos;
	void create(String rep) {
		repos = rep;
		try {
			System.out.println(path);
			File file = new File(path);
			//Creating the directory
			boolean bool = file.mkdir();
			dir = path+"//"+rep;
			if(bool){
				//make directory name dynamic
				System.out.println("Projects Directory created successfully");

			}else{
				System.out.println("Projects folder already there");

			}

		}
		catch(Exception e) {
			System.out.println("Could not create folder");
		}
		createFolder(dir);
	}
	private void createFolder(String path) {
		try {
			File file = new File(dir);
			boolean bool = file.mkdir();
			if(bool){
				System.out.println("Directory created successfully");

			}else{
				System.out.println("Folder already there");

			}

		}
		catch(Exception e) {
			System.out.println("Could not create folder");
		}

		command();
	}
	private void command() {

//		try {
//			Runtime.getRuntime().exec("cmd /c start", null, new File(dir));
//
//
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		ProcResult result = new ProcBuilder("cd")
//				.withArg(""+path.substring(0,2)+"")
//				.run();
////
//		result = new ProcBuilder("cd")
//				.withArg(""+(char)34+""+path+"\\"+repos+""+(char)34+"")
//				.run();
		ProcResult result = new ProcBuilder("git")
				.withArg("init")
				.withWorkingDirectory(new File(dir))
				.run();
//		result = new ProcBuilder("touch")
//				.withArg("ReadMe.md")
//				.run();
//		System.out.println("ReadMe.md created");

		result = new ProcBuilder("git")
				.withArgs("add",".")
				.run();
		result = new ProcBuilder("git")
				.withArgs("commit","-a","--allow-empty-message","-m").withArg("''")
				.run();
		
//git commit -a --allow-empty-message -m ''
		System.out.println("Successfully commited");
		//		createBat();
		//		
		//		try {
		////			Runtime.getRuntime().exec("cmd /c start tasks.bat");
		//			Runtime.getRuntime().exec("cmd /c start tasks.bat", null, new File(path));
		//			
		//		}catch (Exception e) {
		//			// TODO: handle exception
		//		}

		//	may need to delete the tasks.bat file after using it

	}
	//	void createBat() {
	//		
	//		
	//		
	//		
	//		
	//		
	////		 try {
	////		      File myObj = new File("tasks.bat");
	////		      if (myObj.createNewFile()) {
	////		        System.out.println("File created: " + myObj.getName());
	////		      } else {
	////		        System.out.println("File already exists.");
	////		      }
	////		    } catch (IOException e) {
	////		      System.out.println("An error occurred.");
	////		      e.printStackTrace();
	////		    }
	////		 try {
	////		      FileWriter myWriter = new FileWriter(path+"//"+"tasks.bat");
	////		      myWriter.write("git init");
	////		      myWriter.write(System.getProperty( "line.separator" ));
	//////		      myWriter.write("touch ReadMe.md");
	//////		      myWriter.write(System.getProperty( "line.separator" ));
	//////		      myWriter.write("timeout 5");
	//////		      myWriter.write(System.getProperty( "line.separator" ));
	////		      myWriter.write("git add .");
	////		      myWriter.write(System.getProperty( "line.separator" ));
	////		      myWriter.write("timeout 10");
	////		      myWriter.write(System.getProperty( "line.separator" ));
	////		      myWriter.write("git commit -m "+(char)34+"1st commit"+(char)34+"");
	////		      myWriter.write(System.getProperty( "line.separator" ));
	////		      myWriter.close();
	////		      System.out.println("Successfully wrote to the file.");
	////		    } catch (IOException e) {
	////		      System.out.println("An error occurred.");
	////		      e.printStackTrace();
	////		    }
	//	}


}


















