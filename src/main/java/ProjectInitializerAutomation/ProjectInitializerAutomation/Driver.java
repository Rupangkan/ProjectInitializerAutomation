package ProjectInitializerAutomation.ProjectInitializerAutomation;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		int i;
		Local l = new Local();
		Remote r = new Remote();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the repo");
		String repo = sc.nextLine();
		System.out.println("Press [1] for local repo [2] for remote repo");
		i = sc.nextInt();
		//		System.out.println(repo);
		//		System.out.println(i);
		if(i==1) {
			l.create(repo/*file name from batch file*/);
		}else if(i==2) {
//			r.create(/*file name from batch file*/);
		}else {
			System.out.println("Select correct choice ;__;");
		}
	}
}


