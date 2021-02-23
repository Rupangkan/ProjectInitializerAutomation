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

		ProcResult result = new ProcBuilder("git")
				.withArg("init")
				.withWorkingDirectory(new File(dir))
				.run();
//		result = new ProcBuilder("touch")
//				.withArg("ReadMe.md")
//				.run();
//		System.out.println("ReadMe.md created");
		result = new ProcBuilder("fsutil")
				.withArgs("file","createnew","Readme.txt","1000")
				.withWorkingDirectory(new File(dir))
				.run();

		result = new ProcBuilder("git")
				.withArgs("add",".")
				.withWorkingDirectory(new File(dir))
				.run();
		result = new ProcBuilder("git")
				.withArgs("commit","-m").withArg("1st commit")
				.withWorkingDirectory(new File(dir))
				.withExpectedExitStatuses(0,1)
				.run();
		
		System.out.println(result.getOutputString());
		//now bail
		if (result.getExitValue()!=0)
			throw new RuntimeException("Failed to run git");
		


	}


}


















