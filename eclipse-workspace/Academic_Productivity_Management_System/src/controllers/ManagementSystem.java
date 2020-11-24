package controllers;

import java.text.ParseException;
import java.util.Scanner;

import views.Menu;

public class ManagementSystem {
	
	Scanner sc = new Scanner(System.in);
	
	ControllerCollaborator controllerCollaborator = new ControllerCollaborator();
	ControllerProject controllerProject = new ControllerProject();
	ControllerAcademicProduction controllerAcademic = new ControllerAcademicProduction();
	
	public void MainSystem() throws ParseException {
		boolean sair = false;
		int option;
		do {
			Menu.showMenu();
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					controllerCollaborator.register();
					break;
				case 2:
					controllerProject.register();
					break;
				case 3:
				    controllerAcademic.register(controllerCollaborator);
					break;
				case 4:
				    // code block
					break;
				case 5:
				    // code block
					break;
				case 6:
				    // code block
					break;
				case 7:
				    // code block
					break;
				case 8:
				    // code block
					break;
				case 9:
					sair = true;
					break;
			}
			
		}while(!sair);
	}	
}
