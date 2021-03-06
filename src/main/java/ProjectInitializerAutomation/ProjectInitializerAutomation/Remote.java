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
		
		String Token = System.getenv("TOK");
		String Path = System.getenv("PRO");
//		String dir = Path + "//"+repo;
		
		GitHub github = new GitHubBuilder().withOAuthToken(Token).build();

		String userName = github.getMyself().getLogin();
		github.createRepository(repo).create();
		
		
		ProcResult result = new ProcBuilder("git")
			    .withArgs("remote", "set-url" ,"new").withArg("https://github.com/"+userName+"/"+repo+".git")
			    .run();
		result = new ProcBuilder("git").withArgs("push","new","main").run();
		
		System.out.println(result.getOutputString());
		

		
		 
	}

}
