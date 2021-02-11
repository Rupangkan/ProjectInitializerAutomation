package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.io.IOException;

import org.buildobjects.process.ProcBuilder;
import org.buildobjects.process.ProcResult;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class Remote {
	void create(String repo) throws IOException {
		// TODO Auto-generated method stub
		//Connect to GitHub with OAuth Token if already not connected
//		https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core
//		GitHub github = GitHub.connect();
//		Local l = new Local();
//		l.create(repo);
		
		String Token = System.getenv("Tok");
		String Path = System.getenv("Pro");
		String dir = Path + "//"+repo;
		
		GitHub github = new GitHubBuilder().withOAuthToken(Token).build();

		String userName = github.getUser(Token).getName();
		github.createRepository(repo, "","", true);
		
		ProcResult result = new ProcBuilder("git")
			    .withArgs("remote", "add" ,"origin").withArg("https://github.com/"+userName+"/"+repo+".git")
			    .run();
		result = new ProcBuilder("git").withArgs("push","origin","main").run();
		

		
		 
	}

}
