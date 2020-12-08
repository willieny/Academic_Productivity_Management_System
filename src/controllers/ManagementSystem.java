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
		while(!sair){
			Menu.clearScreen();
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
					controllerProject.editProjectInformation();
					break;
				case 5:
					controllerProject.statusChange();
					break;
				case 6:
					controllerProject.allocationOfParticipants(controllerCollaborator);
					break;
				case 7:
					controllerAcademic.allocationOfParticipants(controllerCollaborator);
					break;
				case 8:
					controllerProject.associatePublication(controllerAcademic);;
					break;
				case 9: 
					controllerCollaborator.consultCollaborator();
					break;
				case 10:
					controllerProject.consultProject();
					break;
				case 11:
					System.out.println("#----------- Relatório de produções do laboratório -----------#");
					System.out.println("| Número de colaboradores: " + controllerCollaborator.collaborators.size() 
					+ "                                  |");
					System.out.println("| Número de projetos em elaboração: " + controllerProject.numberOfInPreparation()
					+ "                         |");
					System.out.println("| Número de projetos em andamento: " + controllerProject.numberOfInProcess()
					+ "                          |");
					System.out.println("| Número de projetos concluídos: " + controllerProject.numberOfConcluded() 
					+ "                            |");
					System.out.println("| Número total de projetos: " + controllerProject.projects.size()
					+ "                                 |");
					System.out.println("| Número de produções acadêmicas:                             |" + "\n| - publicações: " 
					+ controllerAcademic.publications.size() 
					+ "                                            |" + "\n| - orientações: " + controllerAcademic.orientations.size() + "                                            |");
					System.out.println("#-------------------------------------------------------------#");
					break;
				case 0:
					sair = true;
					break;
			}
		}
	}	
}
