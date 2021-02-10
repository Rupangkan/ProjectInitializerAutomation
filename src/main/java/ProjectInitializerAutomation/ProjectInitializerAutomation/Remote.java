package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.IOException;

import org.kohsuke.github.GitHub;

public class Remote {
	Local l = new Local();
	private void create(String repo) throws IOException {
		// TODO Auto-generated method stub
		//Connect to GitHub with OAuth Token if already not connected
//		https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core
		GitHub github = GitHub.connect();
		

		
		
	}

}
