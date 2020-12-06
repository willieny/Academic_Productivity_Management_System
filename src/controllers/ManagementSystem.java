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
					controllerProject.statusChange();
					break;
				case 5:
					controllerProject.allocationOfParticipants(controllerCollaborator);
					break;
				case 6:
					controllerAcademic.allocationOfParticipants(controllerCollaborator);
					break;
				case 7:
					controllerProject.associatePublication(controllerAcademic);;
					break;
				case 8: 
					controllerCollaborator.consultCollaborator();
					break;
				case 9:
					controllerProject.consultProject();
					break;
				case 10:
					// code block
					break;
				case 0:
					sair = true;
					break;
			}
		}while(!sair);
	}	
}
