package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.File;

public class Local {
	private String path = "D:\\Projects\\";
	void create(String rep) {
		try {

			File file = new File(path);
			//Creating the directory
			boolean bool = file.mkdir();
			path = path+rep;
			if(bool){
				System.out.println("Directory created successfully");
				createFolder(path);
			}else{
				System.out.println("File already there");
				createFolder(path);
			}
		}
		catch(Exception e) {
			System.out.println("Could not create file");
		}
	}
	private void createFolder(String path) {
		try {
			File file = new File(path);
			boolean bool = file.mkdir();
			if(bool){
				System.out.println("Directory created successfully");
				command();
			}else{
				System.out.println("File already there");
				command();
			}
		}
		catch(Exception e) {
			System.out.println("Could not create file");
		}


	}
	private void command() {
		try {
			Process p = Runtime.getRuntime().exec("cmd");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
